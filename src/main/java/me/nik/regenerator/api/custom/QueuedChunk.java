package me.nik.regenerator.api.custom;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.LinkedList;
import java.util.List;

public class QueuedChunk {

    private final String world;
    private final int x, z;

    private final List<QueuedBlock> queuedBlocks = new LinkedList<>();

    public QueuedChunk(Chunk bukkitChunk) {
        this.world = bukkitChunk.getWorld().getName();
        this.x = bukkitChunk.getX();
        this.z = bukkitChunk.getZ();
    }

    public QueuedChunk(String world, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    public void addQueuedBlock(Block bukkitBlock) {
        addQueuedBlock(new QueuedBlock(bukkitBlock));
    }

    public void addQueuedBlock(QueuedBlock queuedBlock) {
        this.queuedBlocks.add(queuedBlock);
    }

    public List<QueuedBlock> getQueuedBlocks() {
        return queuedBlocks;
    }

    public World getBukkitWorld() {
        return Bukkit.getWorld(this.world);
    }

    public String getWorld() {
        return this.world;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return this.world + "-" + this.x + "-" + this.z;
    }

    public static class QueuedBlock {

        private final Material material;
        private final int x, y, z;

        public QueuedBlock(Block bukkitBlock) {
            this.material = bukkitBlock.getType();
            this.x = bukkitBlock.getX();
            this.y = bukkitBlock.getY();
            this.z = bukkitBlock.getZ();
        }

        public QueuedBlock(String str) {

            String[] data = str.split(",");

            this.material = Material.valueOf(data[0]);
            this.x = Integer.parseInt(data[1]);
            this.y = Integer.parseInt(data[2]);
            this.z = Integer.parseInt(data[3]);
        }

        public Material getMaterial() {
            return material;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        @Override
        public String toString() {
            return this.material.toString() + "," + this.x + "," + this.y + "," + this.z;
        }
    }
}