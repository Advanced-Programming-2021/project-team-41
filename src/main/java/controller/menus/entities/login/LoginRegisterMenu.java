package controller.menus.entities.login;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;
import controller.menus.entities.login.command.Create;
import controller.menus.entities.login.command.Login;

public class LoginRegisterMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.LOGIN_REGISTER;

        while (controller.getStatus() == AppStatus.LOGIN_REGISTER) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);

            // Control flow of app
            if (command == Commands.LOGIN_REGISTER_CREATE_USER) {
                Create create = new Create();
                if (create.parse(Commands.getArgs(command, enterCommand))) createUser(create);

            } else if (command == Commands.LOGIN_REGISTER_LOGIN_USER) {
                Login login = new Login();
                if (login.parse(Commands.getArgs(command, enterCommand))) loginUser(login);
            } else {
                Menu.globalCommands(enterCommand, menu);
            }
        }
    }


    private static void createUser(Create create) {
        System.out.println(create.getUsername());
        System.out.println(create.getNickname());
        System.out.println(create.getPassword());
        // TODO: create user here
    }

    private static void loginUser(Login login) {
        System.out.println(login.getUsername());
        System.out.println(login.getPassword());
        // TODO: login user
    }

}
