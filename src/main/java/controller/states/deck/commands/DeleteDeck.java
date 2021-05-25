package controller.states.deck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "delete", description = "Delete a deck")
class DeleteDeck implements Runnable {
    @Parameters(arity = "1", paramLabel = "<deck name>", description = "name of deck you want to delete")
    private String deckName;

    @Override
    public void run() {
        System.out.println(deckName);
    }
}