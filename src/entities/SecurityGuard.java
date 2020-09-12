package entities;

public final class SecurityGuard {

    private final boolean armed;
    private int amountOfArmed;

    public SecurityGuard(boolean armed) {
        this.armed = armed;
        amountOfArmed = 0;
    }

    public void addAmountOfArmed(int amountOfArmed){
        this.amountOfArmed+=amountOfArmed;
    }

    public int getAmountOfArmed() {
        return amountOfArmed;
    }

    public boolean getArmed() {
        return armed;
    }
}
