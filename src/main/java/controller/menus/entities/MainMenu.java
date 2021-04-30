package controller.menus.entities;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;

public class MainMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.MAIN;

        while (controller.getStatus() == AppStatus.MAIN) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);

            // Control flow of app
            if (command == Commands.MAIN_LOGOUT) {
                menuNavigation(AppStatus.LOGIN_REGISTER);
                System.out.println("user logged out successfully!");
            } else {
                Menu.globalCommands(enterCommand, menu);
            }
        }
    }
}
