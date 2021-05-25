package controller.states.shop.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "shop", subcommands = {
        Buy.class,
        Show.class,
        CommandLine.HelpCommand.class},
        description = "Shop Menu")
public class Shop {
}
