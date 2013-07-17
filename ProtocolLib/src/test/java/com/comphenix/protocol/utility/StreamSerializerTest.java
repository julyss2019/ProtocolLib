package com.comphenix.protocol.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftItemFactory;
import org.bukkit.inventory.ItemStack;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.comphenix.protocol.BukkitInitialization;

@RunWith(org.powermock.modules.junit4.PowerMockRunner.class)
@PrepareForTest(CraftItemFactory.class)
public class StreamSerializerTest {
	@BeforeClass
	public static void initializeBukkit() throws IllegalAccessException {
		BukkitInitialization.initializeItemMeta();
	}
	
	@Test
	public void testSerializer() throws IOException {
		ItemStack before = new ItemStack(Material.GOLD_AXE);
		
		StreamSerializer serializer = new StreamSerializer();
		String data = serializer.serializeItemStack(before);
		ItemStack after = serializer.deserializeItemStack(data);
	
		assertEquals(before.getType(), after.getType());
		assertEquals(before.getAmount(), after.getAmount());
	}
}