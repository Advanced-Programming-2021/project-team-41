package controller.states.deck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "create", description = "Create a new deck")
class CreateDeck implements Runnable {

    @Parameters(arity = "1", paramLabel = "<deck name>", description = "name of deck you want to create")
    private String deckName;

    @Override
    public void run() {
        System.out.println(deckName);
    }
}
