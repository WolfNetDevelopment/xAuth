/*
 * xAuth for Bukkit
 * Copyright (C) 2012 Lycano <https://github.com/lycano/xAuth/>
 *
 * Copyright (C) 2011 CypherX <https://github.com/CypherX/xAuth/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.luricos.bukkit.xAuth.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author lycano
 */
public class DelayedPlayerExactTask extends BukkitRunnable {

    private String playerName = "";
    private xAuthTasks xauthTasks;

    public DelayedPlayerExactTask(xAuthTasks xauthTasks, String playerName) {
        this.xauthTasks = xauthTasks;
        this.playerName = playerName;
    }

    @Override
    public void run() {
        if (Bukkit.getPlayerExact(this.playerName) == null)
            this.getTasks().getPlayerTask(this.playerName, xAuthTask.xAuthTaskType.DELAYED_PLAYER_EXACT).setResult(false);
    }

    public xAuthTasks getTasks() {
        return this.xauthTasks;
    }

}
