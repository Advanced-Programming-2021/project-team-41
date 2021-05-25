package controller.states.deck.commands;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

@Command(name = "show", description = "Show decks or cards")
class Show implements Runnable {
    @Spec
    CommandLine.Model.CommandSpec spec;

    @ArgGroup(exclusive = false, heading = "show specified deck\n")
    Dependent dependent;

    static class Dependent {
        @Option(names = {"--deck-name", "-d"}, paramLabel = "<deck name>", description = "name of deck want to show", required = true)
        String deckName;
        @Option(names = "--side", paramLabel = "optional", description = "set if want to show side deck")
        boolean isSide;
    }

    @ArgGroup
    Exclusive exclusive;

    static class Exclusive {
        @Option(names = "--all", required = true, description = "show call decks")
        boolean showAllDecks;
        @Option(names = "--cards", required = true, description = "show all cards")
        boolean showAllCards;
    }

    @Override
    public void run() {
        validation();
    }

    public void validation() {
        if (dependent == null && exclusive == null)
            throw new CommandLine.ParameterException(spec.commandLine(), "Missing required subcommand");
    }
}
