package controller.menus.entities.profile.command;

import com.beust.jcommander.Parameter;
import controller.menus.Command;

public class ChangePass extends Command {
    /* Static Fields */
    private static final String name = "create user";

    /* Instance Fields */
    @Parameter(names = {"-c", "--current"}, description = "current password of account", required = true)
    private String currentPass;

    @Parameter(names = {"-n", "--new"}, description = "new password", required = true)
    private String newPass;

    /* Getters */
    public String getCurrentPass() {
        return currentPass;
    }

    public String getNewPass() {
        return newPass;
    }

    @Override
    protected String getName() {
        return name;
    }
}
