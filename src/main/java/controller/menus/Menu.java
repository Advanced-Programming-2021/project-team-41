package controller.menus;

import controller.AppController;
import controller.AppStatus;

import java.util.Dictionary;

public abstract class Menu {
    /* Static Fields */
    protected static final AppController controller = AppController.getInstance();

    /* Static methods */
    protected static void globalCommands(String enterCommand, MenuEntities menu) {
        Commands command = Commands.validCommands(enterCommand, MenuEntities.GLOBAL);
        AppStatus appStatus = controller.getStatus();
        Dictionary<String, String> capturedGroup = Commands.getGroups(enterCommand, command.getRegex());

        if (command == Commands.GLOBAL_EXIT_MENU) {
            menuNavigation(AppStatus.getUpperState(appStatus));
        } else if (command == Commands.GLOBAL_SHOW_MENU) {
            System.out.println(menu.getName());
        } else if (command == Commands.GLOBAL_ENTER_MENU) {
            enterMenu(capturedGroup);
        } else if (command == Commands.GLOBAL_INVALID_COMMAND) {
            System.out.println("invalid");
        }
    }

    private static void enterMenu(Dictionary<String, String> capturedGroup) {
        // TODO: Send user to desire menu
    }


    protected static void menuNavigation(AppStatus appStatus) {
        controller.setStatus(appStatus);
    }
}