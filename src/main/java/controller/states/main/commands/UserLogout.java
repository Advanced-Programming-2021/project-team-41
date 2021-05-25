package controller.states.main.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "user", subcommands = {CommandLine.HelpCommand.class},
        description = "User Logout")
public class UserLogout implements Runnable {
    @Option(names = "logout", required = true, description = "set if you want to logout")
    boolean logout;

    @Override
    public void run() {
        System.out.println(logout);
    }
}
