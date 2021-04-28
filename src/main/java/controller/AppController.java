package controller;

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
            if (getStatus() == AppStatus.LOGIN_REGISTER) {//TODO: call login/register run
                setStatus(AppStatus.EXIT);
            } else if (getStatus() == AppStatus.MAIN) {//TODO: call main run
            } else if (getStatus() == AppStatus.DUEL) {//TODO: call duel run
            } else if (getStatus() == AppStatus.DECK) {//TODO: call deck run
            } else if (getStatus() == AppStatus.SCOREBOARD) {//TODO: call scoreboard run
            } else if (getStatus() == AppStatus.PROFILE) {//TODO: call profile run
            } else if (getStatus() == AppStatus.SHOP) {//TODO: call shop run
            } else if (getStatus() == AppStatus.IMPORT_EXPORT) {//TODO: call import export run
            } else return;
        }
    }
}
