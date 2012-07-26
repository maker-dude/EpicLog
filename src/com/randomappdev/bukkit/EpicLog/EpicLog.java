package com.randomappdev.bukkit.EpicLog;

import com.randomappdev.bukkit.EpicLog.listeners.BlockEvents;
import com.randomappdev.bukkit.EpicLog.listeners.EntityEvents;
import com.randomappdev.bukkit.EpicLog.listeners.PlayerEvents;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicLog extends JavaPlugin
{

    private final BlockEvents blockListener = new BlockEvents();
    private final PlayerEvents playerListener = new PlayerEvents();
    private final EntityEvents entityListener = new EntityEvents();
    private SaveData saveData = new SaveData();

    public void onEnable()
    {

        PluginDescriptionFile pdfFile = this.getDescription();

        Log.Init(pdfFile.getName());

        try
        {

            Common.theBoss = this;

            PluginManager pm = getServer().getPluginManager();

            pm.registerEvents(this.playerListener, this);
            pm.registerEvents(this.blockListener, this);
            pm.registerEvents(this.entityListener, this);

            getServer().getScheduler().scheduleAsyncRepeatingTask(this, saveData, 20, 100); //1200 = 1 minute

            if (!this.getDataFolder().exists())
            {
                this.getDataFolder().mkdir();
            }

            System.out.println("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled.");

        } catch (Throwable e)
        {
            System.out.println("[" + pdfFile.getName() + "]" + " error starting: " + e.getMessage() + " Disabling plugin");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    public void onDisable()
    {
        getServer().getScheduler().cancelTasks(this);
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is disabled.");
    }
}
