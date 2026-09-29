package com.nitricacid.worldeditwandfabrication;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(WorldEditWandFabrication.MOD_ID)
public final class WorldEditWandFabrication {
    public static final String MOD_ID = "worldeditwandfabrication";

    public WorldEditWandFabrication(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, WandConfig.SPEC);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }
}
