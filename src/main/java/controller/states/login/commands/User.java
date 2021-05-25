package controller.states.login.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "user", subcommands = {
        CreateUser.class,
        LoginUser.class,
        CommandLine.HelpCommand.class},
        description = "User Commands",
        synopsisSubcommandLabel = "")
class User {
}
