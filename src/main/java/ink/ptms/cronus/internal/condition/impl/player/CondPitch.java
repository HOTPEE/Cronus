package ink.ptms.cronus.internal.condition.impl.player;

import ink.ptms.cronus.database.data.DataQuest;
import ink.ptms.cronus.internal.condition.Cond;
import ink.ptms.cronus.internal.condition.special.CondNumber;
import io.izzel.taboolib.module.locale.TLocale;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * @Author 坏黑
 * @Since 2019-06-17 20:21
 */
@Cond(name = "player.pitch", pattern = "player\\.pitch (?<expression>.+)", example = "player.pitch [expression]")
public class CondPitch extends CondNumber {

    @Override
    public Number getNumber(Player player, DataQuest quest, Event event) {
        return player.getLocation().getPitch();
    }

    @Override
    public String translate() {
        return TLocale.asString("translate-condition-pitch", expression.translate());
    }

    @Override
    public String toString() {
        return "CondPitch{" +
                "expression=" + expression +
                '}';
    }
}
