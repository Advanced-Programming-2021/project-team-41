package controller.states.login.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "", subcommands = {
        User.class,
        Menu.class,
        CommandLine.HelpCommand.class},
        description = "Login Menu")
public class UserMenu implements CMenu {
}