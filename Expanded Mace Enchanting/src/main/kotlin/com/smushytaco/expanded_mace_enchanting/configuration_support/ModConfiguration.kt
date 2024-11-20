package com.smushytaco.expanded_mace_enchanting.configuration_support
import com.smushytaco.expanded_mace_enchanting.ExpandedMaceEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
@Config(name = ExpandedMaceEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    val canUseKnockbackOnMace = true
    val canUseLootingOnMace = true
    val canUseSharpnessOnMace = true
    val canUseImpalingOnMace = true
    val densityAndBreachCanBeMixed = true
    val densityAndOtherWeaponEnchantmentTypesCanBeMixed = true
    val breachAndOtherWeaponEnchantmentTypesCanBeMixed = true
}