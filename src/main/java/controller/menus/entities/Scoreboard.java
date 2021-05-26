package controller.menus.entities;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;

public class Scoreboard extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.SCOREBOARD;
        while (controller.getStatus() == AppStatus.SCOREBOARD) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, MenuEntities.SCOREBOARD);

            // Control flow of app
            if (command == Commands.SCOREBOARD_SHOW) showScoreboard();
            else globalCommands(enterCommand, menu);
        }
    }

    private static void showScoreboard() {
        System.out.println("In scoreboard");
        // TODO: show score board in proper way
    }
}
