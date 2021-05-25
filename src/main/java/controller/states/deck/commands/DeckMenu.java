package controller.states.deck.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", subcommands = {
        Deck.class,
        Menu.class,
        CommandLine.HelpCommand.class},
        description = "Deck Menu Commands")
public class DeckMenu implements CMenu {
}
