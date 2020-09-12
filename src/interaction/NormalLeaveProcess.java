package interaction;

import entities.Saloon;
import entities.Table;
import entities.Visitors;

public final class NormalLeaveProcess {

    private Saloon saloon;

    public NormalLeaveProcess(Saloon saloon) {
        this.saloon = saloon;
    }


    public void freeTable(Visitors visitors) {
        for (Table t :
                saloon.getTables())
            if (visitors.getOccupyTableId() == t.getTableId()) {
                t.setFree();
                saloon.freeTable();
            }
    }

    @Override
    public String toString() {

        return "Group of visitors had enough beer" +
                " so they leave the bar";
    }

}
