package controller.states.shop.commands;

import controller.globals.menu.Menu;
import controller.states.CMenu;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", subcommands = {
        Shop.class,
        Menu.class,
        CommandLine.HelpCommand.class},
        description = "Shop Menu Commands")
public class ShopMenu implements CMenu {
}
