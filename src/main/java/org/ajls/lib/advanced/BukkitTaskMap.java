package org.ajls.lib.advanced;

import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class BukkitTaskMap<K> extends HashMap<K, BukkitTask> {
//    HashMap<K, BukkitTask> tasks;
//    public BukkitTaskMap() {
//        tasks = new HashMap<>();
//    }

    public BukkitTask put(K key, BukkitTask task, boolean override) {
        if (containsKey(key)) {
            BukkitTask removedTask = super.get(key);
            if (override) {
                if (removedTask != null) {
                    removedTask.cancel();
                }
                super.put(key, task);
            }
            else {
                if (task != null) {
                    task.cancel();
                }
            }
            return removedTask;
        }
        else {
            super.put(key, task);
            return null;
        }
    }

    @Override
    public BukkitTask put(K key, BukkitTask task) {
        return put(key, task, true);
    }

    @Override
    public BukkitTask remove(Object key) {
        BukkitTask removedTask = super.remove(key);
        if (removedTask != null) {
            removedTask.cancel();
        }
        return removedTask;
    }

    public boolean contains(Object key) {  //deprecated
        return super.containsKey(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

}
