package io.github.erickeis.relichunt;

public class Machine {
    private int percentComplete = 0;
    private RelicHunt spigotPlugin;

    public Machine(RelicHunt spigotPlugin) {
        this.spigotPlugin = spigotPlugin;
    }

    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }

    public int getPercentComplete() {
        return percentComplete;
    }
}
