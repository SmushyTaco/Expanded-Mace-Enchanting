package com.smushytaco.expanded_mace_enchanting
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = ExpandedMaceEnchanting.MOD_ID)
@Config(name = ExpandedMaceEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var canUseKnockbackOnMace = true
    @JvmField
    var canUseLootingOnMace = true
    @JvmField
    var canUseSharpnessOnMace = true
    @JvmField
    var canUseImpalingOnMace = true
    @JvmField
    var densityAndBreachCanBeMixed = true
    @JvmField
    var densityAndOtherWeaponEnchantmentTypesCanBeMixed = true
    @JvmField
    var breachAndOtherWeaponEnchantmentTypesCanBeMixed = true
}