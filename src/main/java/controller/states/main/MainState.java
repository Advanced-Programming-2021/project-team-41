package controller.states.main;

import controller.App;
import controller.states.State;
import controller.states.StatesMenu;
import controller.states.login.LoginState;
import controller.states.main.commands.MainMenu;
import picocli.CommandLine;
import view.in.Input;

import java.util.Arrays;

public class MainState extends State {
    /* Static Fields */
    static private final CommandLine cmd = Input.cmdBuilder(MainMenu.class);
    static private final String name = "Main Menu";

    /* Instance Methods */
    @Override
    public void run(String command) {
        Input.execute(cmd, command);
    }

    @Override
    public void navigation(StatesMenu statesMenu) throws IllegalAccessException, InstantiationException {
        StatesMenu[] children = {StatesMenu.Duel, StatesMenu.Deck, StatesMenu.Scoreboard,
                StatesMenu.Profile, StatesMenu.Shop, StatesMenu.ImportExport};
        if (Arrays.asList(children).contains(statesMenu)) {
            App.getInstance().changeState(statesMenu.getStateClass().newInstance());
        } else {
            System.out.println("menu navigation is not possible");
        }
    }

    @Override
    public void exit() {
        App.getInstance().changeState(new LoginState());
    }

    @Override
    public String getName() {
        return null;
    }
}
