package entities;

public final class Barmen {

    private final boolean armed;
    private boolean raidKnowledge;
    private int storedCash;

    public Barmen(boolean armed) {
        this.armed = armed;
        raidKnowledge = false;
        storedCash = 0;
    }

    public void addCash(int earnedCash) {
        storedCash += earnedCash;
    }

    public int getStoredCash() {
        return storedCash;
    }

    public void setRaidKnowledge() {
        raidKnowledge = true;
    }

    public boolean getRaidKnowledge() {
        return raidKnowledge;
    }

    public boolean getArmed() {
        return armed;
    }
}
