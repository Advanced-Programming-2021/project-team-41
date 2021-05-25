package controller.states.profile.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "--password", description = "change password")
public class Pass implements Runnable {

    @Option(names = {"--current", "-c"}, required = true, paramLabel = "<current password>"
            , description = "current password of your account")
    String currentPass;

    @Option(names = {"--new", "-n"}, required = true, paramLabel = "<new password>",
            description = "new password of your account")
    String newPass;

    @Override
    public void run() {
        System.out.println(currentPass);
        System.out.println(newPass);
    }
}
