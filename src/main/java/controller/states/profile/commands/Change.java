package controller.states.profile.commands;

import picocli.CommandLine.Command;

@Command(name = "change", description = "change nickname|password", subcommands = {Pass.class, Nickname.class})
class Change {
}