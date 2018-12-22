package com.kreezcraft.nopoles;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PoleHandler {

	public static void msg(String msg) {
		System.out.println(msg);
	}
	
	@SubscribeEvent
	public static void NoColumns(PlaceEvent event) {
		EntityPlayer player = event.getPlayer();
		if ((!player.onGround) && (!player.capabilities.allowFlying)) {
			event.getPlacedBlock().getBlock().dropBlockAsItem(event.getWorld(), event.getPos(), event.getState(), 0);
			event.getWorld().setBlockToAir(event.getPos());
		}
	}

}