package com.earth2me.essentials.api;

import com.earth2me.essentials.commands.IEssentialsCommand;
import com.earth2me.essentials.storage.IStorageObjectHolder;
import com.earth2me.essentials.user.CooldownException;
import com.earth2me.essentials.user.UserData;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public interface IUser extends Player, IStorageObjectHolder<UserData>, IReload, IReplyTo, Comparable<IUser>
{
	boolean isAuthorized(String node);

	boolean isAuthorized(IEssentialsCommand cmd);

	boolean isAuthorized(IEssentialsCommand cmd, String permissionPrefix);

	Player getBase();

	double getMoney();

	void takeMoney(double value);

	void takeMoney(double value, CommandSender initiator);

	void giveMoney(double value);

	void giveMoney(double value, CommandSender initiator);

	void setMoney(double value);
	
	void payUser(final IUser reciever, final double value) throws Exception;

	String getGroup();

	void setLastLocation();

	Location getHome(String name) throws Exception;

	Location getHome(Location loc) throws Exception;

	boolean isHidden();

	ITeleport getTeleport();

	void checkCooldown(UserData.TimestampType cooldownType, double cooldown, boolean set, String bypassPermission) throws CooldownException;

	boolean toggleAfk();

	void updateActivity(boolean broadcast);

	void updateDisplayName();

	boolean checkJailTimeout(long currentTime);

	boolean checkMuteTimeout(long currentTime);

	boolean checkBanTimeout(long currentTime);

	long getTimestamp(UserData.TimestampType name);

	void setTimestamp(UserData.TimestampType name, long value);

	void setLastOnlineActivity(long currentTime);

	void checkActivity();

	long getLastOnlineActivity();

	boolean isGodModeEnabled();

	boolean isIgnoringPlayer(String name);

	void setIgnoredPlayer(String name, boolean set);

	Location getAfkPosition();

	boolean toggleGodModeEnabled();

	void dispose();

	void updateCompass();

	List<String> getHomes();

	void addMail(String string);

	boolean toggleMuted();

	boolean toggleSocialSpy();

	void requestTeleport(IUser user, boolean b);

	boolean isTeleportRequestHere();

	IUser getTeleportRequester();

	boolean toggleTeleportEnabled();

	public boolean gotMailInfo();

	public List<String> getMails();
}
