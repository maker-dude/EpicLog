package com.randomappdev.bukkit.EpicLog;

import com.randomappdev.bukkit.EpicLog.objects.LogRecord;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class Common
{
    public static EpicLog theBoss;
    public static Set<LogRecord> LogData = new HashSet<LogRecord>();
    public static boolean waitToLog = false;
    public static boolean waitToSave = true;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    public static boolean announceSaves = false;

    public static void LogData(String who, String what, Location where, String extra)
    {
        while (waitToLog)
        {
            //We are in the process of saving, so don't do anything at the moment
            int i = 1 + 1;
        }
        waitToSave = true;
        who = who.toLowerCase();
        LogData.add(new LogRecord(who, what, where, extra));
        waitToSave = false;
    }

    public static String getLocationString(Location location)
    {
        String worldName = location.getWorld().getName();
        Block block = location.getBlock();
        return worldName + ":" + block.getX() + ":" + block.getY() + ":" + block.getZ();
    }
}
