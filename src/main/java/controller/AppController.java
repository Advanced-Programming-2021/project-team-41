package controller;

import controller.menus.entities.*;

import java.util.Scanner;

public class AppController {
    /* Static Fields */
    private static AppController appController = new AppController();

    /* Instance Fields */
    private AppStatus status = AppStatus.LOGIN_REGISTER;
    public final Scanner scanner = new Scanner(System.in);
    //TODO: Create private user field

    /* Constructor */
    private AppController() {
        // Singleton class
    }

    /* Static methods */
    public static AppController getInstance() {
        if (AppController.appController == null)
            AppController.appController = new AppController();

        return AppController.appController;
    }

    /* Getters And Setters */
    //TODO: Create setter and getter for user
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
            else return;
        }
    }
}
