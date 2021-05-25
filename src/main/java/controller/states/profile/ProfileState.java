package controller.states.profile;

import controller.App;
import controller.states.State;
import controller.states.StatesMenu;
import controller.states.main.MainState;
import controller.states.profile.commands.ProfileMenu;
import picocli.CommandLine;
import view.in.Input;

public class ProfileState extends State {
    /* Static Fields */
    static private final CommandLine cmd = Input.cmdBuilder(ProfileMenu.class);
    static private final String name = "Profile Menu";

    /* Instance Methods */
    @Override
    public void run(String command) {
        Input.execute(cmd, command);
    }

    @Override
    public void navigation(StatesMenu statesMenu) {
        System.out.println("menu navigation is not possible");
    }

    @Override
    public void exit() {
        App.getInstance().changeState(new MainState());
    }

    @Override
    public String getName() {
        return name;
    }
}
