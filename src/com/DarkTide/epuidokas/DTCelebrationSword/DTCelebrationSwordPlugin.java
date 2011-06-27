package com.DarkTide.epuidokas.DTCelebrationSword;

import java.io.*;
import java.util.*;

import com.sk89q.minecraft.util.commands.CommandsManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.event.Event;

public class DTCelebrationSwordPlugin extends JavaPlugin{

    private static DTCelebrationSwordPlugin plugin;
    private final Properties config = new Properties();
    private final DTCelebrationSwordBlockListener blockListener = new DTCelebrationSwordBlockListener();
    private final DTCelebrationSwordEntityListener entityListener = new DTCelebrationSwordEntityListener();
    private final DTCelebrationSwordPlayerListener playerListener = new DTCelebrationSwordPlayerListener();
    public static List<String> players = new ArrayList();

    public void onEnable() {
        
        plugin = this;

        // Set up plugin directory
        getDataFolder().mkdir();
        getDataFolder().setWritable(true);
        getDataFolder().setExecutable(true);

        // Extract software license
        extractFile("/README.txt");

        // Load config
        extractFile("/config.properties");
        try {
            config.load(new FileInputStream(this.getDataFolder() + File.separator +"config.properties"));
        }
        catch(IOException e) {
            e.printStackTrace();
            log("loading FAILED");
            return;
        }

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Low, this);
        pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Event.Priority.Low, this);
        pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerListener, Event.Priority.Low, this);

        // Load successful
        log("loaded");
    }
    public void onDisable() {
        log("disabled");
    }

    private void extractFile(String name) {
        File actual = new File(getDataFolder(), name);
        if (!actual.exists()) {
            InputStream input = this.getClass().getResourceAsStream( name);
            if (input != null) {
                FileOutputStream output = null;

                try {
                    output = new FileOutputStream(actual);
                    byte[] buf = new byte[8192];
                    int length = 0;

                    while ((length = input.read(buf)) > 0) {
                        output.write(buf, 0, length);
                    }

                    log("Extracted file: " + actual.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (input != null) {
                            input.close();
                        }
                    } catch (Exception e) { }
                    try {
                        if (output != null) {
                            output.close();
                        }
                    } catch (Exception e) { }
                }
            }
        }
    }

    public static void log(String message) {
        PluginDescriptionFile pdfFile = plugin.getDescription();
        System.out.println("["+pdfFile.getName()+"]["+pdfFile.getVersion()+"] " + message);
    }

    public static boolean isCelebrating(String player) {
        return players.contains(player);
    }

    public static boolean startTheParty(String player) {
        return players.add(player);
    }

    public static boolean endTheParty(String player) {
        return players.remove(player);
    }
}
