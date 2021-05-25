package controller.states.profile.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "--nickname", description = "change nickname")
public class Nickname implements Runnable{
    @Parameters(arity = "1", paramLabel = "<nick name>", description = "new nickname")
    private String nickname;

    @Override
    public void run() {
        System.out.println(nickname);
    }
}
