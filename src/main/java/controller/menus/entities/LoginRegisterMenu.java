package controller.menus.entities;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;

import java.util.Dictionary;

public class LoginRegisterMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        Dictionary<String, String> capturedGroups;
        MenuEntities menu = MenuEntities.LOGIN_REGISTER;

        while (controller.getStatus() == AppStatus.LOGIN_REGISTER) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);
            capturedGroups = Commands.getGroups(enterCommand, command.getRegex());

            // Control flow of app
            if (command == Commands.LOGIN_REGISTER_CREATE_USER) {
                createUser(capturedGroups);
            } else if (command == Commands.LOGIN_REGISTER_LOGIN_USER) {
                loginUser(capturedGroups);
            } else {
                Menu.globalCommands(enterCommand, menu);
            }
        }
    }


    private static void createUser(Dictionary<String, String> captured) {
        System.out.println("in create user");
        String username = captured.get("username"),
                password = captured.get("password"),
                nickname = captured.get("nickname");
        System.out.println(username);
        System.out.println(password);
        System.out.println(nickname);
        // TODO: create user here
    }

    private static void loginUser(Dictionary<String, String> captured) {
        System.out.println("in login user");
        String username = captured.get("username"), password = captured.get("password");
        System.out.println(username);
        System.out.println(password);
        // TODO: login user
    }

}
