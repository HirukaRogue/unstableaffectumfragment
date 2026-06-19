package net.hirukarogue.unstableaffectum.items;

import net.hirukarogue.unstableaffectum.UnstableAffectumMod;
import net.hirukarogue.unstableaffectum.items.custom.AffectumFragment;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AffectumItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnstableAffectumMod.MODID);

    //O Items e o register servem para construir os registradores, o item que criei aqui chamado de AFFECTUM_FRAGMENT é onde criamos e registramos o fragmento de affectum
    public static final DeferredItem<Item> AFFECTUM_FRAGMENT = ITEMS.register("affectum_fragment", () -> new AffectumFragment(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
