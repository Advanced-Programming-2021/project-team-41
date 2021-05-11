package controller.menus.entities.profile;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;
import controller.menus.entities.deck.command.DeckShow;
import controller.menus.entities.profile.command.ChangePass;

import java.util.ArrayList;

public class ProfileMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.PROFILE;

        while (controller.getStatus() == AppStatus.PROFILE) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, MenuEntities.PROFILE);

            // Control flow of app
            if (command == Commands.PROFILE_CHANGE_NICKNAME)
                changeNickname(Commands.getGroups(enterCommand, command.getRegex()));
            else if (command == Commands.PROFILE_CHANGE_PASSWORD) {
                ChangePass changePass = new ChangePass();
                if (changePass.parse(Commands.getArgs(command, enterCommand))) changePassword(changePass);
            } else globalCommands(enterCommand, menu);
        }
    }

    private static void changeNickname(ArrayList<String> captured) {
        try {
            controller.getUser().changeNickname(captured.get(0));
            System.out.println("nickname changed successfully!");//TODO: send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: send this to view
        }
    }

    private static void changePassword(ChangePass changePass) {
        try {
            controller.getUser().changePassword(changePass.getCurrentPass(), changePass.getNewPass());
            System.out.println("password changed successfully!");//TODO: send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: send this to view
        }
    }
}
