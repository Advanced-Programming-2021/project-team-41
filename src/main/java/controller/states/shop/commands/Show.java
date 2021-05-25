package controller.states.shop.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "show", description = "show cards")
public class Show implements Runnable {
    @Option(names = "--all", required = true, description = "set if you want to show all cards")
    boolean showAll;

    @Override
    public void run() {
        System.out.println(showAll);
    }
}
