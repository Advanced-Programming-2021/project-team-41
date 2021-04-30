package controller.menus;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    // Commands for login register menu
    LOGIN_REGISTER_CREATE_USER(MenuEntities.LOGIN_REGISTER, "^\\s*user create(?<args>.*)\\s*$"),
    LOGIN_REGISTER_LOGIN_USER(MenuEntities.LOGIN_REGISTER, "^\\s*user login(?<args>.*)\\s*$"),

    // Commands for main menu
    MAIN_LOGOUT(MenuEntities.MAIN, null),

    // Global commands
    GLOBAL_SHOW_MENU(MenuEntities.GLOBAL, "^\\s*menu show-current\\s*$"),
    GLOBAL_ENTER_MENU(MenuEntities.GLOBAL, "^\\s*menu enter (\\S+)\\s*$"),
    GLOBAL_EXIT_MENU(MenuEntities.GLOBAL, "^\\s*menu exit\\s*$"),
    GLOBAL_INVALID_COMMAND(MenuEntities.GLOBAL, "");

    // Value
    private final MenuEntities menuEntities;
    private final String regex;

    /* Constructor */
    Commands(MenuEntities menuEntities, String regex) {
        this.menuEntities = menuEntities;
        this.regex = regex;
    }

    /* Getters And Setters */
    public String getRegex() {
        return this.regex;
    }

    /* Static methods */
    public static Commands validCommands(String enteredCommand, MenuEntities menuEntities) {
        for (Commands command : Commands.values()) {
            if (command != Commands.GLOBAL_INVALID_COMMAND &&
                    command.menuEntities == menuEntities &&
                    enteredCommand.matches(command.getRegex())) return command;
        }
        return Commands.GLOBAL_INVALID_COMMAND;
    }

    public static String getArgs(Commands command, String input) {
        Matcher matcher = getCommandMatcher(input, command.getRegex());
        String args = null;
        if (matcher.find()) {
            args = matcher.group("args");
        }
        return args;
    }

    public static Matcher getCommandMatcher(String input, String regex) {
        return Pattern.compile(regex).matcher(input);
    }

    public static ArrayList<String> getGroups(String input, String regex) {
        ArrayList<String> result = new ArrayList<>();
        Matcher matcher = getCommandMatcher(input, regex);
        while (matcher.find()) {
            for (int j = 1; j <= matcher.groupCount(); j++) {
                result.add(matcher.group(j));
            }
        }
        return result;
    }

}
