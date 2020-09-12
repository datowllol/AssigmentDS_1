package entities;

public final class PoliceRaid {

    private final int amountPoliceman;
    private boolean started;

    public PoliceRaid(int amountPoliceman) {
        this.started = false;
        this.amountPoliceman = amountPoliceman;
    }

    public boolean getStartInfo() {
        return started;
    }

    public int getAmountPoliceman() {
        return amountPoliceman;
    }

    public void startRaid() {
        this.started = true;
    }
}
