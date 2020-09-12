package interaction;

import entities.*;

public final class EntranceInteraction {

    private SecurityGuard guardian;
    private Barmen barmen;
    private PoliceRaid policeRaid;

    public EntranceInteraction(SecurityGuard guardian, Barmen barmen, PoliceRaid policeRaid) {
        this.guardian = guardian;
        this.policeRaid = policeRaid;
        this.barmen = barmen;
    }

    public void entranceCheck(Visitors visitors) {
        if (!visitors.getMood()) {
            addArmed(visitors);
            visitors.setIsInside();
        }
    }

    private void addArmed(Visitors visitors) {
        if (visitors.getIsArmed()) {
            guardian.addAmountOfArmed(visitors.getVisitorsNum());
        }
    }


    public void leaveCheck(Visitors visitors) {
        if (visitors.getIsArmed()) {
            guardian.addAmountOfArmed(-visitors.getVisitorsNum());
        }
    }

    public void policeRaidCheck(PoliceRaid policeRaid, Barmen barmen) {
        if (policeRaid.getStartInfo()) {
            barmen.setRaidKnowledge();
        }
    }

    @Override
    public String toString() {
        if (barmen.getRaidKnowledge())
            return "It look's like police raid is coming. There are " +
                    policeRaid.getAmountPoliceman() + " of them";
        else return "Another good day without any kind of raid";
    }

}
