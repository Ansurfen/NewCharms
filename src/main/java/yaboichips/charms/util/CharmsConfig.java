package yaboichips.charms.util;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CharmsConfig {
    private static final ForgeConfigSpec CONFIG_SPEC;
    private static final CharmsConfig INSTANCE;

    static {
        final Pair<CharmsConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CharmsConfig::new);
        CONFIG_SPEC = specPair.getRight();
        INSTANCE = specPair.getLeft();
    }

    private final ForgeConfigSpec.IntValue charmSlots;


    public CharmsConfig(ForgeConfigSpec.Builder builder) {
        charmSlots = builder.defineInRange("Charm Slots", 2, 1, 26);
        builder.push("CHARMS CONFIG [NOT FUNCTIONAL DON'T USE]");
        builder.pop();

    }

    public static ForgeConfigSpec getConfigSpec() {
        return CONFIG_SPEC;
    }

    public static CharmsConfig getInstance() {
        return INSTANCE;
    }

    public int charmSlots() {
        return charmSlots.get();
    }

}
