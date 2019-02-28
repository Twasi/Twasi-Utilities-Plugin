package net.twasiplugin.utilities;

import net.twasi.core.plugin.api.TwasiCustomCommand;
import net.twasi.core.plugin.api.TwasiUserPlugin;
import net.twasi.core.plugin.api.events.TwasiInstallEvent;
import net.twasiplugin.utilities.commands.check.Check;
import net.twasiplugin.utilities.commands.game.Game;
import net.twasiplugin.utilities.commands.hosts.Hosts;
import net.twasiplugin.utilities.commands.title.Title;
import net.twasiplugin.utilities.commands.uptime.Uptime;
import net.twasiplugin.utilities.commands.wiki.Wiki;

import java.util.ArrayList;
import java.util.List;

public class Userplugin extends TwasiUserPlugin {

    private List<TwasiCustomCommand> commands = new ArrayList<>();

    public Userplugin() {
        // Register commands
        commands.add(new Check(this));
        commands.add(new Game(this));
        commands.add(new Hosts(this));
        commands.add(new Title(this));
        commands.add(new Uptime(this));
        commands.add(new Wiki(this));
    }

    @Override
    public void onInstall(TwasiInstallEvent e) {
        e.getAdminGroup().addKey("twasi.utilities.streamer.*");
        e.getModeratorsGroup().addKey("twasi.utilities.mod.*");
        e.getDefaultGroup().addKey("twasi.utilities.default.*");
    }

    @Override
    public void onUninstall(TwasiInstallEvent e) {
        e.getAdminGroup().removeKey("twasi.utilities.streamer.*");
        e.getModeratorsGroup().removeKey("twasi.utilities.mod.*");
        e.getDefaultGroup().removeKey("twasi.utilities.default.*");
    }

    @Override
    public List<TwasiCustomCommand> getCommands() {
        return commands;
    }
}
