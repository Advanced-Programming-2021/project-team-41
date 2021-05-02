package controller.menus.entities;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;

import java.util.ArrayList;

public class ShopMenu extends Menu {
    /* Static Fields */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.SHOP;

        while (controller.getStatus() == AppStatus.SHOP) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);

            // Control flow of app
            if (command == Commands.SHOP_BUY_CARD)
                buyCard(Commands.getGroups(enterCommand, command.getRegex()));
            else if (command == Commands.SHOP_SHOW_ALL_AVAILABLE_CARDS) showAllAvailableCard();
            else globalCommands(enterCommand, menu);
        }
    }

    private static void buyCard(ArrayList<String> captured) {
        System.out.println("In buy card: " + captured.get(0));
    }

    private static void showAllAvailableCard() {
        System.out.println("In show all available card");
    }
}