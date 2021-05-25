package controller.states.login;

import controller.App;
import controller.states.State;
import controller.states.StatesMenu;
import controller.states.end.EndState;
import controller.states.login.commands.UserMenu;
import picocli.CommandLine;
import view.in.Input;

public class LoginState extends State {
    /* Static Fields */
    static private final CommandLine cmd = Input.cmdBuilder(UserMenu.class);
    static private final String name = "Login Menu";

    /* Instance Methods */
    @Override
    public void run(String command) {
        Input.execute(cmd, command);
    }

    @Override
    public void navigation(StatesMenu statesMenu) throws IllegalAccessException, InstantiationException {
        if (statesMenu == StatesMenu.Main) {
            App.getInstance().changeState(statesMenu.getStateClass().newInstance());
        } else {
            System.out.println("menu navigation is not possible");
        }
    }

    @Override
    public void exit() {
        App.getInstance().changeState(new EndState());
        System.out.println("See you");
    }

    @Override
    public String getName() {
        return name;
    }


}
