package controller.states.shop.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "buy", description = "buy a cards")
public class Buy implements Runnable {
    @Parameters(arity = "1", paramLabel = "<card name>", description = "name of the card")
    private String cardName;

    @Override
    public void run() {
        System.out.println(cardName);
    }
}
