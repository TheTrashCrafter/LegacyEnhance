package me.hankung.legacyenhance.config;

import java.util.ArrayList;
import java.util.List;

import io.github.axolotlclient.AxolotlClientConfig.common.ConfigHolder;
import io.github.axolotlclient.AxolotlClientConfig.options.BooleanOption;
import io.github.axolotlclient.AxolotlClientConfig.options.Option;
import io.github.axolotlclient.AxolotlClientConfig.options.OptionCategory;

public class LegacyConfig extends ConfigHolder {

	public final BooleanOption generalCleanView = new BooleanOption("CleanView", false);

    public final BooleanOption betterchatCompact = new BooleanOption("Compact", true);
	public final BooleanOption betterchatTransparent = new BooleanOption("Transparent", false);
    public final BooleanOption betterchatAnimate = new BooleanOption("Smooth", true);

	public final BooleanOption securityResourceExploit = new BooleanOption("Resource Exploit Fix", true);

	public final OptionCategory general = new OptionCategory("general");
	public final OptionCategory betterchat = new OptionCategory("BetterChat");
	public final OptionCategory security = new OptionCategory("Security");
	public final List<io.github.axolotlclient.AxolotlClientConfig.common.options.OptionCategory> config = new ArrayList<>();
	private final List<Option<?>> options = new ArrayList<>();
	private final List<io.github.axolotlclient.AxolotlClientConfig.common.options.OptionCategory> categories = new ArrayList<>();

	public void add(Option<?> option) {
		options.add(option);
	}

	public void addCategory(OptionCategory cat) {
		categories.add(cat);
	}

	public List<io.github.axolotlclient.AxolotlClientConfig.common.options.OptionCategory> getCategories() {
		return categories;
	}

	public List<Option<?>> getOptions() {
		return options;
	}

	public void init() {
		categories.add(general);
		categories.add(betterchat);
		categories.add(security);

		categories.forEach(io.github.axolotlclient.AxolotlClientConfig.common.options.OptionCategory::clearOptions);

		general.add(generalCleanView);

		betterchat.add(betterchatCompact);
        betterchat.add(betterchatTransparent);
        betterchat.add(betterchatAnimate);

		security.add(securityResourceExploit);
	}
}