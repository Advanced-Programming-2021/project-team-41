package controller.menus;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public abstract class Command {
    /* Static Fields */
    private static final String splitRegex = "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'";

    /* Instance Fields */
    @Parameter
    private final List<String> parameters = new ArrayList<>();

    /* Abstract method */
    protected abstract String getName();

    /* Instance Methods */
    public boolean parse(String args) {
        JCommander jCommander = JCommander.newBuilder().addObject(this).build();
        jCommander.setProgramName(this.getName());
        try {
            jCommander.parse(splitter(args.trim()));
            if (parameters.size() != 0) throw new Exception("Unknown parameter(s): " + String.join(", ", parameters));

        } catch (Exception e) {
            //TODO: edit this and send value to view
            System.out.println(e.getMessage());
            jCommander.usage();
            return false;
        }
        return true;
    }

    public String[] splitter(String args) {
        ArrayList<String> res = new ArrayList<>();
        Matcher matcher = Commands.getCommandMatcher(args, splitRegex);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // Add double-quoted string without the quotes
                res.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                // Add single-quoted string without the quotes
                res.add(matcher.group(2));
            } else {
                // Add unquoted word
                res.add(matcher.group());
            }
        }
        return res.toArray(new String[0]);
    }
}
