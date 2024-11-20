package com.smushytaco.expanded_mace_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_mace_enchanting.ExpandedMaceEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class MaceModification {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (ExpandedMaceEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.KNOCKBACK)) {
            if (!ExpandedMaceEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnMace() || !(stack.getItem() instanceof MaceItem)) return original;
            return true;
        }  else if (ExpandedMaceEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.LOOTING)) {
            if (!ExpandedMaceEnchanting.INSTANCE.getConfig().getCanUseLootingOnMace() || !(stack.getItem() instanceof MaceItem)) return original;
            return true;
        } else if (ExpandedMaceEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.SHARPNESS)) {
            if (!ExpandedMaceEnchanting.INSTANCE.getConfig().getCanUseSharpnessOnMace() || !(stack.getItem() instanceof MaceItem)) return original;
            return true;
        } else if (ExpandedMaceEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.IMPALING)) {
            if (!ExpandedMaceEnchanting.INSTANCE.getConfig().getCanUseImpalingOnMace() || !(stack.getItem() instanceof MaceItem)) return original;
            return true;
        }
        return original;
    }
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) { return original || ExpandedMaceEnchanting.INSTANCE.getConfig().getDensityAndBreachCanBeMixed() && ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.DENSITY, Enchantments.BREACH)) || ExpandedMaceEnchanting.INSTANCE.getConfig().getDensityAndOtherWeaponEnchantmentTypesCanBeMixed() && (ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.DENSITY, Enchantments.SMITE)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.DENSITY, Enchantments.BANE_OF_ARTHROPODS)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.DENSITY, Enchantments.SHARPNESS)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.DENSITY, Enchantments.IMPALING))) || ExpandedMaceEnchanting.INSTANCE.getConfig().getBreachAndOtherWeaponEnchantmentTypesCanBeMixed() && (ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.BREACH, Enchantments.SMITE)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.BREACH, Enchantments.BANE_OF_ARTHROPODS)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.BREACH, Enchantments.SHARPNESS)) || ExpandedMaceEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.BREACH, Enchantments.IMPALING))); }
}