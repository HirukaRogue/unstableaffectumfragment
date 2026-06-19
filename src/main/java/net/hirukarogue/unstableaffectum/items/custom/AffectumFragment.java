package net.hirukarogue.unstableaffectum.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class AffectumFragment extends Item {
    public AffectumFragment(Properties properties) {
        super(properties);
    }

    //bem, para fazer o efeito do affectum ser usado com o botão direito, você precisa sobrescrever um método herdado da super classe item chamado use
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        //essa parte é importante para pegar o affectum que o jogador ta segurando na mão
        ItemStack itemStack = player.getItemInHand(usedHand);

        //para funcionar no servidor verifique se está no server side
        if (!level.isClientSide) {
            //decremento do affectum
            itemStack.shrink(1);

            //aqui aplica o efeito de brilho, a mensagem temática e o cooldown em segundos, como 1 segundo equivale a 20 ticks multipliquei a duração em 20*10 e o cooldown em 20*30
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20 * 10, 0));
            player.sendSystemMessage(Component.literal("Você sente o affectum entrando em seu corpo..."));
            player.getCooldowns().addCooldown(this, 20 * 30);

            //e aqui sinaliza para o sistema que a interação funcionou
            return InteractionResultHolder.success(itemStack);
        }

        //aqui só faz as coisas serem standard
        return super.use(level, player, usedHand);
    }
}
