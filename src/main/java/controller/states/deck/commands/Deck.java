package controller.states.deck.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "deck", subcommands = {
        CreateDeck.class,
        DeleteDeck.class,
        SetActive.class,
        AddCard.class,
        RemoveCard.class,
        Show.class,
        CommandLine.HelpCommand.class},
        description = "Deck Menu")
public class Deck implements Runnable {
    @Override
    public void run() {
    }
}
