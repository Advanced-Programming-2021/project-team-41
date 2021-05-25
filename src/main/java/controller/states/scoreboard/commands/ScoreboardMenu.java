package controller.states.scoreboard.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", subcommands = {
        Scoreboard.class,
        Menu.class,
        CommandLine.HelpCommand.class},
        description = "Scoreboard Menu Commands")
public class ScoreboardMenu implements CMenu {
}
