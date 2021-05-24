package controller;

import controller.states.State;
import controller.states.end.EndState;
import controller.states.login.LoginState;
import view.in.Input;

public class App {
    /* Static Fields */
    private static App app;

    /* Instance Fields */
    private State state;

    /* Constructor */
    private App() {
        // Singleton class
        this.state = new LoginState();
    }

    /* Static methods */
    public static App getInstance() {
        if (App.app == null)
            App.app = new App();

        return App.app;
    }

    /* Getter */
    public State getState() {
        return state;
    }

    /* Instance Methods */
    public void run() {
        while (!(state instanceof EndState)) {
            state.run(Input.getCommand());
        }
    }

    public void changeState(State state) {
        this.state = state;
    }
}
