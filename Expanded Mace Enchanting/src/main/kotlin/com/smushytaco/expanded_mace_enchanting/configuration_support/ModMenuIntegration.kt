package com.smushytaco.expanded_mace_enchanting.configuration_support
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import me.shedaniel.autoconfig.AutoConfig
class ModMenuIntegration: ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> =
        ConfigScreenFactory { parent -> AutoConfig.getConfigScreen(ModConfiguration::class.java, parent).get() }
}