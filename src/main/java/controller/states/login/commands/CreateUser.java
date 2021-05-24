package controller.states.login.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "create", description = "Create new account")
class CreateUser implements Runnable {

    @Option(names = {"--username", "-u"}, required = true, paramLabel = "<username>", description = "Username of your account")
    String username;

    @Option(names = {"--nickname", "-n"}, required = true, paramLabel = "<nickname>", description = "Nickname of your account")
    String nickname;

    @Option(names = {"--password", "-p"}, required = true, paramLabel = "<password>", description = "Password of your account")
    String password;

    @Override
    public void run() {
        System.out.println(username);
        System.out.println(nickname);
        System.out.println(password);
    }
}