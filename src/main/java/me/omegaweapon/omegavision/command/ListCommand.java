package me.omegaweapon.omegavision.command;

import me.omegaweapon.omegavision.OmegaVision;
import me.ou.library.Utilities;
import me.ou.library.commands.PlayerCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class ListCommand extends PlayerCommand {
  
  @Override
  protected void onCommand(final Player player, final String[] strings) {
    if(Utilities.checkPermission(player, "omegavision.list", true)) {
      Utilities.message(player, OmegaVision.getMessagesFile().getConfig().getString("Prefix") + " &bThe following players have nightvision enabled:");
      for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
        if(onlinePlayers.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
          Utilities.message(player,  OmegaVision.getMessagesFile().getConfig().getString("Prefix") +  " &c" + onlinePlayers.getName());
        }
      }
    } else {
      Utilities.message(player, OmegaVision.getMessagesFile().getConfig().getString("Prefix") + "" + OmegaVision.getMessagesFile().getConfig().getString("No_Permission"));
    }

  }
}
