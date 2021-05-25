package controller.states.profile.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "profile", subcommands = {
        Change.class,
        CommandLine.HelpCommand.class},
        description = "Profile Menu")
public class Profile {

}
