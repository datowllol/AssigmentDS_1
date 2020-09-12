package entities;

import java.util.UUID;

public final class Table {

    private boolean isFree;
    private final int placeNum;
    private final UUID tableId;

    public Table(int placeNum) {
        this.isFree = true;
        this.placeNum = placeNum;
        tableId = UUID.randomUUID();
    }

    public void setFree() {
        this.isFree = true;
    }

    public void setTaken() {
        this.isFree = false;
    }

    public UUID getTableId() {
        return tableId;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public int getPlaceNum() {
        return placeNum;
    }
}
