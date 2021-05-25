package controller.globals.menu;


import controller.App;
import controller.states.StatesMenu;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "menu", subcommands = {
        MenuEnter.class,
        MenuExit.class,
        MenuShowCurrent.class,
        CommandLine.HelpCommand.class},
        description = "Menubar")
public class Menu {
}

@Command(name = "enter")
class MenuEnter implements Runnable {

    @Parameters(paramLabel = "<menu name>", description = "Valid values: ${COMPLETION-CANDIDATES}")
    StatesMenu statesMenu = StatesMenu.Login;

    @Override
    public void run() {
        try {
            App.getInstance().getState().navigation(statesMenu);
        } catch (Exception e) {
            System.err.print(e.getMessage());
            System.exit(1);
        }
    }
}

@Command(name = "exit")
class MenuExit implements Runnable {
    @Override
    public void run() {
        App.getInstance().getState().exit();
    }
}

@Command(name = "show-current")
class MenuShowCurrent implements Runnable {
    @Override
    public void run() {
        System.out.println(App.getInstance().getState().getName());
    }
}