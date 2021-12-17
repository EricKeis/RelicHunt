package io.github.erickeis.relichunt;

public class Machine {
    private int percentComplete = 0;
    private RelicHunt plugin;

    public Machine(RelicHunt plugin) {
        this.plugin = plugin;
    }

    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }

    public int getPercentComplete() {
        return percentComplete;
    }
}
