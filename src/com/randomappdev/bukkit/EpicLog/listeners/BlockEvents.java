package com.randomappdev.bukkit.EpicLog.listeners;

import com.randomappdev.bukkit.EpicLog.Common;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEvents implements Listener
{
    public BlockEvents()
    {
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "PLACED", event.getBlock().getLocation(), event.getBlock().getType().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "BROKE", event.getBlock().getLocation(), event.getBlock().getType().toString());
        }
    }
}