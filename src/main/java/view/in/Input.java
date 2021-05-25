package view.in;

import controller.states.CMenu;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Input {
    /* Static Fields */
    public static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'";

    /* Static methods */
    public static String getCommand() {
        return scanner.nextLine();
    }

    public static CommandLine cmdBuilder(Class<? extends CMenu> commandClass) {
        try {
            CommandLine cmd = new CommandLine(commandClass.newInstance());
            cmd.setCaseInsensitiveEnumValuesAllowed(true);
            return cmd;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public static void execute(CommandLine cmd, String command) {
        cmd.execute(splitter(command));
    }

    private static String[] splitter(String args) {
        ArrayList<String> res = new ArrayList<>();
        Matcher matcher = getCommandMatcher(args, SPLIT_REGEX);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // Add double-quoted string without the quotes
                res.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                // Add single-quoted string without the quotes
                res.add(matcher.group(2));
            } else {
                // Add unquoted word
                res.add(matcher.group());
            }
        }
        return res.toArray(new String[0]);
    }

    public static Matcher getCommandMatcher(String input, String regex) {
        return Pattern.compile(regex).matcher(input);
    }
}
