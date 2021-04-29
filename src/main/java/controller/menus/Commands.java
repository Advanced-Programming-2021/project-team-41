package controller.menus;


import java.util.Dictionary;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    // Commands for login register menu
    LOGIN_REGISTER_CREATE_USER(MenuEntities.LOGIN_REGISTER, "^\\s*user create --(?<key1>username|nickname|password) (?<value1>\\S+) --(?<key2>username|nickname|password) (?<value2>\\S+) --(?<key3>username|nickname|password) (?<value3>\\S+)\\s*$", "user create --username <username> --nickname <nickname> --password <password>"),
    LOGIN_REGISTER_LOGIN_USER(MenuEntities.LOGIN_REGISTER, "^\\s*user login --(?<key1>username|password) (?<value1>\\S+) --(?<key2>username|password) (?<value2>\\S+)\\s*$", "user login --username <username> --password <password>"),

    // Global commands
    GLOBAL_SHOW_MENU(MenuEntities.GLOBAL, "^\\s*menu show-current\\s*$", "menu show-current"),
    GLOBAL_ENTER_MENU(MenuEntities.GLOBAL, "^\\s*menu enter " + String.join("|", MenuEntities.getAllMenusName()) + "\\s*$", "menu enter <menu name>"),
    GLOBAL_EXIT_MENU(MenuEntities.GLOBAL, "^\\s*menu exit\\s*$", "menu exit"),
    GLOBAL_INVALID_COMMAND(MenuEntities.GLOBAL, "", "");

    // Value
    private final MenuEntities menuEntities;
    private final String regex;
    private final String helper;

    /* Constructor */
    Commands(MenuEntities menuEntities, String regex, String help) {
        this.menuEntities = menuEntities;
        this.regex = regex;
        this.helper = help;
    }

    /* Getters And Setters */
    public String getRegex() {
        return this.regex;
    }

    private String getHelper() {
        return this.helper;
    }

    private MenuEntities getMenuSection() {
        return menuEntities;
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

    public static void commandsHelper(MenuEntities menuEntities) {
        StringBuilder commandsFormat = new StringBuilder();
        for (Commands command : Commands.values()) {
            if (command != Commands.GLOBAL_INVALID_COMMAND && command.getMenuSection() == menuEntities)
                commandsFormat.append(command.getHelper()).append("\n");
        }
        System.out.print(commandsFormat.toString());
    }

    protected static Integer parseToInt(String intValue) {
        try {
            return Integer.parseInt(intValue);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Matcher getCommandMatcher(String input, String regex) {
        return Pattern.compile(regex).matcher(input);
    }

    public static Dictionary<String, String> getGroups(String input, String regex) {
        Dictionary<String, String> result = new Hashtable<>();
        Matcher matcher = getCommandMatcher(input, regex);
        while (matcher.find()) {
            for (int j = 1; j <= matcher.groupCount() / 2; j++) {
                result.put(matcher.group("key" + j), matcher.group("value" + j));
            }
        }
        return result;
    }

}
