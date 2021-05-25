package controller.states.deck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "rm-card", description = "Remove a card from deck")
class RemoveCard implements Runnable {

    @Option(names = {"--card", "-c"}, paramLabel = "<card name>", description = "name of a card you want to remove from deck")
    String cardName;

    @Option(names = {"--deck", "-d"}, paramLabel = "<deck name>", description = "name of deck which you want to remove card from it")
    String deckName;

    @Option(names = "--side", arity = "0..1", paramLabel = "optional", description = "set if you want to remove from side deck")
    boolean isSide;


    @Override
    public void run() {
        System.out.println(cardName);
        System.out.println(deckName);
        System.out.println(isSide);
    }
}

