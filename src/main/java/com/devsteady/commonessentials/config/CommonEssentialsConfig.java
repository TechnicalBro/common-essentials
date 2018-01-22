package com.devsteady.commonessentials.config;

import com.caved_in.commons.yml.*;
import lombok.Getter;
import lombok.Setter;

public class CommonEssentialsConfig extends YamlConfig {
	@Path("allow-bukkit-commands")
	@Comments({
			"Allows usage of 'Bukkit:' prefixed commands",
			"Changing this value to false disable these commands",
			"from being used on your server."
	})
	@Getter @Setter
	private boolean bukkitCommandsEnabled = true;

	@Path("allow-plugins-command")
	@Comments({
			"Changing the value of this option to false",
			"Stops players from using '/plugins' on your server."
	})
	@Getter @Setter
	private boolean pluginsCommandEnabled = true;

	@Path("join-messages")
	@Comments({
			"Whether or not to enable join messages",
			"in chat when a player joins the server"
	})
	@Getter @Setter
	private boolean joinMessagesEnabled = true;

	@Path("leave-messages")
	@Comments({
			"Whether or not to enable leave messages",
			"in chat when a player leaves the server"
	})
	@Getter @Setter
	private boolean leaveMessagesEnabled = true;

	@Path("kick-messages")
	@Comments({
			"Whether or not to show 'player was kicked'",
			"messages in chat, when a player is kicked."
	})
	@Getter @Setter
	private boolean kickMessagesEnabled = true;

	@Path("silence-chat")
	@Comments({
			"When enabled, only players with 'commons.silence.bypass'",
			"in their permissions will be able to talk"
	})
	@Getter @Setter
	private boolean silenceChat = false;


	@Path("warps-gui")
	@Comments({
			"When enabled, it provides an interactive GUI",
			"of which players can use to teleport and interact",
			"with warps.",
			"",
			"If it's disabled, and a player does /warps, they'll receive",
			"a chat based menus with pages detailing the available warps."
	})
	@Getter
	@Setter
	private boolean warpsGuiEnabled = true;

	@Path("teleport-to-spawn-on-join")
	@Comment("When enabled, players will be teleported to their worlds spawn when joining the server")
	@Getter @Setter
	private boolean teleportToSpawnOnJoin = false;

	@Path("environment.weather")
	@Comments({
			"All the options beneath this are used to control",
			"various aspects of the worlds across all",
			"the enabled worlds on your server.",
			"",
			"If you have another plugin enabled that also",
			"Modifies any of these values, there's no guarantee",
			"that they will function as expected."
	})
	@Getter @Setter
	private boolean weatherEnabled = true;

	@Path("environment.lightning")
	@Comment("Whether or not lightning will strike during a storm.")
	@Getter @Setter
	private boolean lightningEnabled = true;

	@Path("environment.thunder")
	@Comment("Whether or not thunder will rumble during a storm.")
	@Getter @Setter
	private boolean thunderEnabled = true;

	@Path("environment.ice-accumulation")
	@Comment("Toggles whether or not Ice will accumulate and spread.")
	@Getter @Setter
	private boolean iceAccumulationEnabled = true;

	@Path("environment.snow-accumulation")
	@Comment("Toggles whether or not snow will accumulate and spread.")
	@Getter @Setter
	private boolean snowAccumulationEnabled = true;

	@Path("environment.mycelium-spread")
	@Comment("Whether or not mycelium will infect other blocks around it and spread.")
	@Getter @Setter
	private boolean myceliumSpreadEnabled = true;

	@Path("environment.fire-spread")
	@Comment("Defines whether or not fire will spread.")
	@Getter @Setter
	private boolean fireSpreadEnabled = false;

	@Path("environment.leaf-decay")
	@Comment("Whether or not leaves will decay.")
	@Getter @Setter
	private boolean leafDecayEnabled = true;

	@Path("environment.block-break")
	@Comments({"Defines whether or not players can break blocks outside of creative","There is the option to bypass this with a permission","which you can define below."})
	@Getter @Setter
	private boolean blockBreakEnabled = true;

	@Path("environment.block-place")
	@Comments({"Defines whether or not players can place blocks outside of creative","There is the option to bypass this with a permission","which you can define below."})
	@Getter @Setter
	private boolean blockPlaceEnabled = true;

	@Path("environment.item-pickup")
	@Comment("Changes if players are able to pick up items that are dropped")
	@Getter @Setter
	private boolean itemPickupEnabled = true;

	@Path("environment.item-drop")
	@Comment("Changes if players are able to drop their items")
	@Getter @Setter
	private boolean itemDropEnabled = true;

	@Path("environment.food-change")
	@Comments("Determines whether or not a players hunger level decreases.")
	@Getter @Setter
	private boolean foodChangeEnabled = true;

	@Path("environment.fall-damage")
	@Comment("Determines whether or not players take fall damage.")
	@Getter
	@Setter
	private boolean fallDamageEnabled = true;

	@Path("permissions.block-break-bypass")
	@Comments({"Permission that can be given to players / groups","and will allow them to bypass the block break restrictions"})
	@Getter @Setter
	private String blockBreakBypassPermission = "cessentials.bypass.block-break";

	@Path("permissions.block-break-bypass")
	@Comments({"Permission that can be given to players / groups","and will allow them to bypass the block break restrictions"})
	@Getter @Setter
	private String blockPlaceBypassPermission = "cessentials.bypass.block-place";


	public CommonEssentialsConfig() {

	}

}
