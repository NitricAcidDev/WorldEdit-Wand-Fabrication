package com.nitricacid.worldeditwandfabrication;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class WandConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue ENABLED;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        ENABLED = builder.comment("Restore the WorldEdit Items Wand Axe in creative mode.")
                .define("enabled", true);
        SPEC = builder.build();
    }

    private WandConfig() {}
}
