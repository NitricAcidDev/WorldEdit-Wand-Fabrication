package com.nitricacid.worldeditwandfabrication;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(WorldEditWandFabrication.MOD_ID)
public final class WorldEditWandFabrication {
    public static final String MOD_ID = "worldeditwandfabrication";

    public WorldEditWandFabrication(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, WandConfig.SPEC);
    }
}
