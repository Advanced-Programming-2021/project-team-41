package controller.states.deck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "add-card", description = "Add a card to deck")
class AddCard implements Runnable {

    @Option(names = {"--card", "-c"}, paramLabel = "<card name>", description = "name of a card you want to add to the deck")
    String cardName;

    @Option(names = {"--deck", "-d"}, paramLabel = "<deck name>", description = "name of deck which you want to add card to it")
    String deckName;

    @Option(names = "--side", arity = "0..1", paramLabel = "(optional)", description = "set if you want add to side deck")
    boolean isSide;


    @Override
    public void run() {
        System.out.println(cardName);
        System.out.println(deckName);
        System.out.println(isSide);
    }
}