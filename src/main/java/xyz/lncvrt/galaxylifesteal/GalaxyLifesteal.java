package xyz.lncvrt.galaxylifesteal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GalaxyLifesteal extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getMaxHealth() > 2) {
                player.setMaxHealth(player.getMaxHealth() - 2);

                if (event.getEntity().getKiller() instanceof Player killer) {
                    killer.setMaxHealth(killer.getMaxHealth() + 2);
                }
            }
        }
    }
}
