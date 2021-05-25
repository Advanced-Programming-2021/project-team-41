package controller.states.main.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

@Command(name = "", subcommands = {
        UserLogout.class,
        Menu.class,
        HelpCommand.class},
        description = "Main Menu")
public class MainMenu implements CMenu {
}