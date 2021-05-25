package controller.states.profile.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", subcommands = {
        Profile.class,
        Menu.class,
        CommandLine.HelpCommand.class},
        description = "Deck Menu Commands")
public class ProfileMenu implements CMenu {
}
