package org.ajls.lib.advanced;

import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class BukkitTaskMap<K> {
    HashMap<K, BukkitTask> tasks;
    public BukkitTaskMap() {
        tasks = new HashMap<>();
    }

    public BukkitTask put(K key, BukkitTask task, boolean override) {
        if (tasks.containsKey(key)) {
            BukkitTask removedTask = tasks.get(key);
            if (override) {
                if (removedTask != null) {
                    removedTask.cancel();
                }
                tasks.put(key, task);
            }
            else {
                if (task != null) {
                    task.cancel();
                }
            }
            return removedTask;
        }
        else {
            tasks.put(key, task);
            return null;
        }
    }

    public BukkitTask put(K key, BukkitTask task) {
        return put(key, task, true);
    }

    public BukkitTask remove(K key) {
        BukkitTask removedTask = tasks.remove(key);
        if (removedTask != null) {
            removedTask.cancel();
        }
        return removedTask;
    }

    public boolean contains(K key) {
        return tasks.containsKey(key);
    }

}
