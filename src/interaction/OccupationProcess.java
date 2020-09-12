package interaction;

import entities.*;

public final class OccupationProcess {

    private Saloon saloon;
    boolean isFound;

    public OccupationProcess(Saloon saloon) {
        this.saloon = saloon;
        isFound = false;
    }

    public void occupyTable(Visitors visitors) {
        if (saloon.getNumFreeTables() != 0 && visitors.getIsInside())
            for (Table t :
                    saloon.getTables())
                if (t.getIsFree() && t.getPlaceNum() >= visitors.getVisitorsNum())
                    placeOccupation(t, visitors);
    }


    private void placeOccupation(Table t, Visitors visitors) {
        t.setTaken();
        saloon.occupiedTable();
        visitors.setOccupyTableId(t.getTableId());
        isFound = true;
    }

    private String placeFound() {
        return "Group of visitors found a place to seat";
    }

    private String noPlaceLeave() {
        return "Group of visitors didnot found a place to seat or guard didnot let them in" +
                " so they leave the bar";
    }

    @Override
    public String toString() {
        if (isFound) {
            isFound = false;
            return placeFound();
        } else {
            isFound = false;
            return noPlaceLeave();
        }
    }

}
