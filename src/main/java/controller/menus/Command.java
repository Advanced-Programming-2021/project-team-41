package controller.menus;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    /* Static Fields */
    private static final String splitRegex = "\\s+";

    /* Instance Fields */
    @Parameter
    private List<String> parameters = new ArrayList<>();

    /* Abstract method */
    protected abstract String getName();

    /* Instance Methods */
    public boolean parse(String args) {
        JCommander jCommander = JCommander.newBuilder().addObject(this).build();
        jCommander.setProgramName(this.getName());
        try {
            jCommander.parse(args.trim().split(splitRegex));
            if (parameters.size() != 0) throw new Exception("Unknown parameter(s): " + String.join(", ", parameters));

        } catch (Exception e) {
            //TODO: edit this and send value to view
            System.out.println(e.getMessage());
            jCommander.usage();
            return false;
        }
        return true;
    }
}
