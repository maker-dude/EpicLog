package com.randomappdev.bukkit.EpicLog;

import com.randomappdev.bukkit.EpicLog.objects.LogRecord;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class SaveData implements Runnable
{

    private String DATA_PATH = "Data";
    private DateFormat df = new SimpleDateFormat("yyyyMMdd");

    public void run()
    {

        if (Common.LogData.size() > 0)
        {
            Set<LogRecord> dataToSave;

            while (Common.waitToSave)
            {
                //Currently logging something, so hold on a second.
                int i = 1 + 1;
            }
            Common.waitToLog = true;
            dataToSave = new HashSet<LogRecord>(Common.LogData);
            Common.LogData.clear();
            Common.waitToLog = false;

            File file = new File(Common.theBoss.getDataFolder() + File.separator + DATA_PATH);
            if (!file.exists())
            {
                file.mkdir();
            }

            file = new File(Common.theBoss.getDataFolder() + File.separator + DATA_PATH + File.separator + generateFileName());
            if (!file.exists())
            {
                try
                {
                    file.createNewFile();
                } catch (IOException e)
                {
                    Log.Write(e.getMessage());
                }
            }

            Save(file, generateData(dataToSave));

        }

    }

    private String generateData(Set<LogRecord> dataToSave)
    {
        String result = "";

        if (Common.announceSaves)
        {
            Log.Write("Saving Data... [" + dataToSave.size() + "] Records.");
        }

        for (LogRecord log : dataToSave)
        {
            result = result + log.toString() + "\n";
        }

        return result;

    }

    private String generateFileName()
    {
        return df.format(new Date()) + ".log";
    }

    private void Save(File file, String data)
    {

        FileOutputStream stream;
        BufferedWriter writer;

        try
        {

            stream = new FileOutputStream(file, true);
            writer = new BufferedWriter(new OutputStreamWriter(stream));

            try
            {
                writer.write(data);
            } finally
            {
                writer.close();
            }
        } catch (IOException e)
        {
            Log.Write(e.getMessage());
        }

    }
}
