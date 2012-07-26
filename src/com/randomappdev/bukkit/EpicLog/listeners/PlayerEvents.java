/*
This file is part of AutoItemBarReload

Copyright (C) 2011 by Team ESO

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

 */

package com.randomappdev.bukkit.EpicLog.listeners;

import com.randomappdev.bukkit.EpicLog.Common;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class PlayerEvents implements Listener
{

    public PlayerEvents()
    {
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (!event.isCancelled())
        {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
            {
                Common.LogData(event.getPlayer().getName(), event.getAction().toString(), event.getPlayer().getLocation(), event.getMaterial().toString() + " with " + event.getPlayer().getItemInHand());
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDropItem(PlayerDropItemEvent event)
    {
        if (!event.isCancelled())
        {

        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "INTERACTED with ", event.getPlayer().getLocation(), event.getRightClicked().getType().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerFish(PlayerFishEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "FISHED", event.getPlayer().getLocation(), "");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "SCOOPED", event.getPlayer().getLocation(), event.getBlockClicked().getType().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "POURED", event.getPlayer().getLocation(), event.getBucket().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChatEvent(PlayerChatEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "CHAT", event.getPlayer().getLocation(), event.getMessage());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "COMMAND", event.getPlayer().getLocation(), event.getMessage());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "GAMEMODE", event.getPlayer().getLocation(), event.getNewGameMode().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerRespawnEvent(PlayerRespawnEvent event)
    {
        Common.LogData(event.getPlayer().getName(), "RESPAWNED", event.getPlayer().getLocation(), "");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerTeleportEvent(PlayerTeleportEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "TELEPORTED", event.getFrom(), Common.getLocationString(event.getTo()));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeathEvent(PlayerDeathEvent event)
    {
        Common.LogData(event.getEntity().getName(), "DIED", event.getEntity().getLocation(), event.getDeathMessage());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerPortalEvent(PlayerPortalEvent event)
    {
        if (!event.isCancelled())
        {
            Common.LogData(event.getPlayer().getName(), "PORTALED", event.getPlayer().getLocation(), event.getPortalTravelAgent().toString());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoinEvent(PlayerJoinEvent event)
    {
        Common.LogData(event.getPlayer().getName(), "JOINED", event.getPlayer().getLocation(), "");
    }
}
