package io.github.erickeis.relichunt.utils;

import org.bukkit.Location;

public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(Location loc) {
        this.x = loc.getBlockX();
        this.y = loc.getBlockY();
        this.z = loc.getBlockZ();
    }

    public Coordinate(String locStr) {
        String[] temp = locStr.split(":");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);
        z = Integer.parseInt(temp[2]);
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
        return x + ":" + y + ":" + z;
    }
}
