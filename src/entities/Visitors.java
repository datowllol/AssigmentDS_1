package entities;

import java.util.UUID;

public final class Visitors {
    private final int visitorsNum;
    private boolean isDrunk;
    private final boolean moodAggressive;
    private final boolean isArmed;
    private boolean isInside;
    private UUID occupyTableId;

    public Visitors(int visitorsAmount, boolean moodAggressive, boolean isArmed) {
        this.isDrunk = false;
        this.moodAggressive = moodAggressive;
        this.visitorsNum = visitorsAmount;
        isInside = false;
        this.isArmed = isArmed;
    }

    public void setDrunk() {
        isDrunk = true;
    }

    public void setIsInside() {
        isInside = true;
    }

    public boolean getIsArmed() {
        return isArmed;
    }

    public boolean getIsInside() {
        return isInside;
    }

    public boolean getMood() {
        return moodAggressive;
    }

    public boolean getIsDrunk() {
        return isDrunk;
    }

    public UUID getOccupyTableId() {
        return occupyTableId;
    }

    public int getVisitorsNum() {
        return visitorsNum;
    }

    public void setOccupyTableId(UUID occupyTableId) {
        this.occupyTableId = occupyTableId;
    }

}
