package ink.ptms.cronus.internal.condition.impl;

import ink.ptms.cronus.database.data.DataQuest;
import ink.ptms.cronus.internal.bukkit.Location;
import ink.ptms.cronus.internal.bukkit.parser.BukkitParser;
import ink.ptms.cronus.internal.condition.Cond;
import ink.ptms.cronus.internal.condition.Condition;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.regex.Matcher;

/**
 * @Author 坏黑
 * @Since 2019-05-29 11:12
 */
@Cond(name = "location", pattern = "location (?<symbol>\\S+) (?<location>.+)", example = "location [symbol] [location]")
public class CondLocation extends Condition {

    private String symbol;
    private Location location;

    @Override
    public void init(Matcher matcher, String text) {
        symbol = matcher.group("symbol");
        location = BukkitParser.toLocation(matcher.group("location"));
    }

    @Override
    public boolean check(Player player, DataQuest quest, Event event) {
        return symbol.startsWith("=") == location.inSelect(player.getLocation());
    }

    @Override
    public String toString() {
        return "CondLocation{" +
                "symbol='" + symbol + '\'' +
                ", location=" + location +
                '}';
    }
}
