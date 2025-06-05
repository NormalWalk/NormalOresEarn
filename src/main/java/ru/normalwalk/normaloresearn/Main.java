package ru.normalwalk.normaloresearn;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.normalwalk.normaloresearn.Command.ReloadCommand;
import ru.normalwalk.normaloresearn.Listener.OreEarnListener;
import ru.normalwalk.normaloresearn.Utils.Coloriser;
import ru.normalwalk.normaloresearn.Utils.VaultUtils;

public class Main extends JavaPlugin {

    private static Main instance;
    public static ConsoleCommandSender log;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        log = this.getServer().getConsoleSender();
        new VaultUtils();
        getServer().getPluginManager().registerEvents(new OreEarnListener(), this);
        getCommand("normaloresearn").setExecutor(new ReloadCommand());

        log.sendMessage(Coloriser.coloriser(""));
        log.sendMessage(Coloriser.coloriser("&c╔ &fПлагин &aNormalOresEarn &f(&e" + getDescription().getVersion() + "&f)"));
        log.sendMessage(Coloriser.coloriser("&c╚ &fРазработчик - &avk.com/normalwalk &f/ &at.me.normalwalk"));
        log.sendMessage(Coloriser.coloriser(""));
    }

    public static Main getPlugin() {
        return instance;
    }

    public VaultUtils getVault() {
        return new VaultUtils();
    }
}
