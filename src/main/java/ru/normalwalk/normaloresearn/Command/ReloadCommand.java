package ru.normalwalk.normaloresearn.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.normalwalk.normaloresearn.Main;
import ru.normalwalk.normaloresearn.Utils.Coloriser;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("normaloresearn.reload")) {
            return true;
        }

        if (args.length == 0 || !args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage(Coloriser.coloriser("&c&lРУДЫ: &fИспользование: &a/normaloresearn reload"));
            return true;
        }

        try {
            Main.getPlugin().reloadConfig();
            sender.sendMessage(Coloriser.coloriser("&c&lРУДЫ: &fФайл &aconfig.yml &fуспешно перезагружен!"));
        } catch (Exception e) {
            sender.sendMessage(Coloriser.coloriser("&c&lРУДЫ: &fОшибка при перезагрузке конфигурации: " + e.getMessage()));
        }

        return true;
    }
}