package com.randomappdev.bukkit.EpicLog.objects;

import com.randomappdev.bukkit.EpicLog.Common;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.Date;

public class LogRecord
{
    public String who; //Who did it
    public String what; //What did they do
    public Date when; //When did they do it
    public Location where; //Where did they do it
    public String extra; //Extra Info

    public LogRecord(String who, String what, Location where, String extra)
    {
        this.who = who;
        this.what = what;
        this.where = where;
        this.extra = extra;
        this.when = new Date();
    }

    public String getWho()
    {
        return who;
    }

    public String toString()
    {
        if (extra.length() > 0)
        {
            return Common.dateFormat.format(when) + " " + who + " " + what + " " + extra + " at " + Common.getLocationString(where);
        } else
        {
            return Common.dateFormat.format(when) + " " + who + " " + what + " at " + Common.getLocationString(where);
        }
    }
}
