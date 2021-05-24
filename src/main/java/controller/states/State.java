package controller.states;

abstract public class State {
    /* Instance Methods */
    public abstract void run(String command);

    public abstract void navigation(StatesMenu statesMenu) throws IllegalAccessException, InstantiationException;

    public abstract void exit();

    public abstract String getName();
}
