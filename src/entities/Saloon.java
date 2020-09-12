package entities;

import java.util.ArrayList;
import java.util.List;

public final class Saloon {

    private int numFreeTables;
    private final List<Table> tables;

    public Saloon(int tableNum) {
        this.numFreeTables = tableNum;
        this.tables = new ArrayList<>();
    }

    public void add_table(int placeNum) {
        this.tables.add(new Table(placeNum));
    }

    public List<Table> getTables() {
        return tables;
    }

    public int getNumFreeTables() {
        return numFreeTables;
    }

    public void occupiedTable() {
        numFreeTables--;
    }

    public void freeTable() {
        numFreeTables++;
    }

}
