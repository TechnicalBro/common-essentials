package com.devsteady.commonessentials;

import com.caved_in.commons.plugin.BukkitPlugin;
import com.caved_in.commons.yml.InvalidConfigurationException;
import com.devsteady.commonessentials.config.CommonEssentialsConfig;
import com.devsteady.commonessentials.listeners.*;

import java.io.File;

public class CommonEssentials extends BukkitPlugin {
    private static CommonEssentials instance = null;

    public static CommonEssentials getInstance() {
        return instance;
    }

    private static CommonEssentialsConfig config = null;

    @Override
    public void startup() {

    }

    private void registerListeners() {
        /* Check the ice and snow spread configuration */
        if (config.isIceAccumulationEnabled() || config.isSnowAccumulationEnabled()) {
            registerListeners(new BlockFormListener());
        }

        /* Check for mycellium spreading */
        if (config.isMyceliumSpreadEnabled()) {
            registerListeners(new BlockSpreadListener());
        }

        /* Check if thunder is disabled */
        if (config.isThunderEnabled()) {
            registerListeners(new ThunderChangeListener());
        }

        /* Check if we're disabling weatherEnabled */
        if (config.isWeatherEnabled()) {
            registerListeners(new WeatherChangeListener());
        }

        /* Check to see if we're disabling lightning */
        if (config.isLightningEnabled()) {
            registerListeners(new LightningStrikeListener());
        }

        /* Check if we're disabling fire spread */
        if (config.isFireSpreadEnabled()) {
            registerListeners(new FireSpreadListener());
        }

        /* If we're not allowing items to be picked up then we need to register that listener too */
        if (!config.isItemPickupEnabled()) {
            registerListeners(new ItemPickupListener());
        }

        /* If item drops are disabled then we need to register that listener too */
        if (!config.isItemDropEnabled()) {
            registerListeners(new ItemDropListener());
        }

        /* If food (hunger) level is disabled then we have a listener for that, too */
        if (!config.isFoodChangeEnabled()) {
            registerListeners(new FoodChangeListener());
        }


    }

    @Override
    public void shutdown() {

    }

    @Override
    public String getAuthor() {
        return "TheGamersCave";
    }

    @Override
    public void initConfig() {
        instance = this;

        File yamlConfigFile = new File(getDataFolder(),"config.yml");

        File warpsFolder = new File(getDataFolder(),"warps/");

        if (!warpsFolder.exists()) {
            warpsFolder.mkdirs();
        }

        config = new CommonEssentialsConfig();
        if (!yamlConfigFile.exists()) {
            try {
                config.init(yamlConfigFile);
            } catch (InvalidConfigurationException e) {
                e.printStackTrace();
            }
        } else {
            try {
                config.load(yamlConfigFile);
            } catch (InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    public CommonEssentialsConfig getConfiguration() {
        return config;
    }
}
