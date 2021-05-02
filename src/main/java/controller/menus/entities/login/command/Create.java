package controller.menus.entities.login.command;

import com.beust.jcommander.Parameter;
import controller.menus.Command;

public class Create extends Command {
    /* Static Fields */
    private static final String name = "create user";

    /* Instance Fields */
    @Parameter(names = {"-u", "--username"}, description = "user name for account", required = true)
    private String username;

    @Parameter(names = {"-p", "--password"}, description = "password for account", required = true)
    private String password;

    @Parameter(names = {"-n", "--nickname"}, description = "nickname for account", required = true)
    private String nickname;

    /* Getters */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    protected String getName() {
        return name;
    }
}
