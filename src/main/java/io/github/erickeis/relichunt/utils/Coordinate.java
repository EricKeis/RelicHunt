package io.github.erickeis.relichunt.utils;

import org.bukkit.Location;

public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate (int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return x + ":" + y + ":" + z;
    }
}
