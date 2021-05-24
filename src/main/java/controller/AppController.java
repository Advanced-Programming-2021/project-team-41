package controller;

import controller.menus.entities.MainMenu;
import controller.menus.entities.Scoreboard;
import controller.menus.entities.ShopMenu;
import controller.menus.entities.deck.DeckMenu;
import controller.menus.entities.login.LoginRegisterMenu;
import controller.menus.entities.profile.ProfileMenu;
import model.user.User;

import java.util.Scanner;

public class AppController {
    /* Static Fields */
    private static AppController appController = new AppController();

    /* Instance Fields */
    private AppStatus status = AppStatus.LOGIN_REGISTER;
    public final Scanner scanner = new Scanner(System.in);
    private User user;

    /* Constructor */
    private AppController() {
        // Singleton class
    }

    /* Static Methods */
    public static AppController getInstance() {
        if (AppController.appController == null)
            AppController.appController = new AppController();

        return AppController.appController;
    }

    /* Getters And Setters */
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public AppStatus getStatus() {
        return status;
    }

    public void setStatus(AppStatus status) {
        this.status = status;
    }

    /* Instance Methods */
    public void run() {
        while (getStatus() != AppStatus.EXIT) {
            if (getStatus() == AppStatus.LOGIN_REGISTER) LoginRegisterMenu.run();
            else if (getStatus() == AppStatus.MAIN) MainMenu.run();
            else if (getStatus() == AppStatus.DECK) DeckMenu.run();
            else if (getStatus() == AppStatus.SCOREBOARD) Scoreboard.run();
            else if (getStatus() == AppStatus.PROFILE) ProfileMenu.run();
            else if (getStatus() == AppStatus.SHOP) ShopMenu.run();
            else return;
        }
    }

    public void userLogout() {
        setUser(null);
    }
}
