package controller.states;

import controller.states.deck.DeckState;
import controller.states.login.LoginState;
import controller.states.main.MainState;
import controller.states.profile.ProfileState;
import controller.states.scoreboard.ScoreboardState;
import controller.states.shop.ShopState;

public enum StatesMenu {
    Login(LoginState.class),
    Main(MainState.class),
    Duel(null),
    Deck(DeckState.class),
    Scoreboard(ScoreboardState.class),
    Profile(ProfileState.class),
    Shop(ShopState.class),
    ImportExport(null);

    private final Class<? extends State> stateClass;

    /* Constructor */
    StatesMenu(Class<? extends State> stateClass) {
        this.stateClass = stateClass;
    }

    /* Getters And Setters */
    public Class<? extends State> getStateClass() {
        return stateClass;
    }
}
