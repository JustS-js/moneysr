package net.just_s;

import net.fabricmc.api.ModInitializer;

import net.just_s.item.SRModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SRMod implements ModInitializer {
	public static final String MOD_ID = "moneysr";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SRModItems.registerModItems();
		LOGGER.info("SR mod for money loaded");
	}
}
