package controller.states.deck;

import controller.App;
import controller.states.State;
import controller.states.StatesMenu;
import controller.states.deck.commands.DeckMenu;
import controller.states.main.MainState;
import picocli.CommandLine;
import view.in.Input;

public class DeckState extends State {
    /* Static Fields */
    static private final CommandLine cmd = Input.cmdBuilder(DeckMenu.class);
    static private final String name = "Deck Menu";

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
