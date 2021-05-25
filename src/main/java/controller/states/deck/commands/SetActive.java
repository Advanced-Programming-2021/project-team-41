package controller.states.deck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "set-active", description = "Set a deck as active deck")
class SetActive implements Runnable {

    @Parameters(arity = "1", paramLabel = "<deck name>", description = "name of deck you want to set as active")
    private String deckName;

    @Override
    public void run() {
        System.out.println(deckName);
    }
}