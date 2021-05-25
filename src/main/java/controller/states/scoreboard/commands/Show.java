package controller.states.scoreboard.commands;

import picocli.CommandLine.Command;

@Command(name = "show", description = "show scoreboard")
public class Show implements Runnable {
    @Override
    public void run() {
        System.out.println("show");
    }
}
