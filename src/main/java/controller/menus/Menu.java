package controller.menus;

import controller.AppController;
import controller.AppStatus;

import java.util.ArrayList;

public abstract class Menu {
    /* Static Fields */
    protected static final AppController controller = AppController.getInstance();

    /* Static methods */
    protected static void globalCommands(String enterCommand, MenuEntities menu) {
        Commands command = Commands.validCommands(enterCommand, MenuEntities.GLOBAL);
        AppStatus appStatus = controller.getStatus();

        if (command == Commands.GLOBAL_EXIT_MENU) {
            menuNavigation(AppStatus.getUpperState(appStatus));
        } else if (command == Commands.GLOBAL_SHOW_MENU) {
            //TODO: send this to view
            System.out.println(menu.getName());
        } else if (command == Commands.GLOBAL_ENTER_MENU) {
            enterMenu(Commands.getGroups(enterCommand, command.getRegex()), menu);
        } else if (command == Commands.GLOBAL_INVALID_COMMAND) {
            //TODO: send this to view
            System.out.println("invalid");
        }
    }

    private static void enterMenu(ArrayList<String> capturedGroup, MenuEntities currentMenu) {
        assert capturedGroup.get(0) != null;
        MenuEntities selectedMenu = MenuEntities.getMenuByName(capturedGroup.get(0));
        if (selectedMenu == null) {
            System.out.println("We don't have menu with this name");
        } else if (currentMenu == MenuEntities.LOGIN_REGISTER && selectedMenu == MenuEntities.MAIN) {
            menuNavigation(selectedMenu.getAppStatus());
        } else if (currentMenu == MenuEntities.MAIN) {
            menuNavigation(selectedMenu.getAppStatus());
        } else {
            System.out.println("Can't navigate");
        }
    }


    protected static void menuNavigation(AppStatus appStatus) {
        controller.setStatus(appStatus);
    }
}