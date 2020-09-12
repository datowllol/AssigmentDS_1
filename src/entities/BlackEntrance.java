package entities;

public final class BlackEntrance {

    private boolean conditionOpen;

    public BlackEntrance() {
        this.conditionOpen = false;
    }

    public boolean getConditionOpen() {
        return conditionOpen;
    }

    public void setOpen() {
        this.conditionOpen = true;
    }
}
