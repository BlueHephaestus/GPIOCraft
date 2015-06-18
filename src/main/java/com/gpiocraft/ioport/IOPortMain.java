package com.gpiocraft.ioport;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid = IOPortMain.modid, version = IOPortMain.version)

public class IOPortMain {
        public static final String modid = "ioport";
        public static final String version = "0.1 MC1.7.10";
        
        
        /*public static CreativeTabs modTab = new CreativeTabs("GPIOCraft Items") {
                public Item getTabIconItem() {
                        return Items.golden_hoe;
                }
        };*/
        
        public static Block ioPortOff;
        public static Block ioPortOn;
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                
                ioPortOff = new IOPort(false).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("io_port_off").setBlockTextureName(modid + ":io_port_off");
                GameRegistry.registerBlock(ioPortOff,  "ioPortOff");
                LanguageRegistry.addName(ioPortOff, "I/O Port");
                
                ioPortOn = new IOPort(true).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("io_port_on").setBlockTextureName(modid + ":io_port_on");
                GameRegistry.registerBlock(ioPortOn,  "ioPortOn");
                LanguageRegistry.addName(ioPortOn, "Activated I/O Port");
                
                GameRegistry.addShapedRecipe(new ItemStack(ioPortOff, 4), new Object[]{
            		"R  ", "R  ", "R  ", 'R', Items.redstone 
                });
                GameRegistry.addShapedRecipe(new ItemStack(ioPortOff, 4), new Object[]{
            		" R ", " R ", " R ", 'R', Items.redstone 
                });
                GameRegistry.addShapedRecipe(new ItemStack(ioPortOff, 4), new Object[]{
            		"  R", "  R", "  R", 'R', Items.redstone 
                });
                
        }
 
        @EventHandler
        public void init(FMLInitializationEvent event) {
 
        }
 
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
 
        }
        
}
