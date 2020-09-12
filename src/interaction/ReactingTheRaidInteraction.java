package interaction;

import entities.*;

public final class ReactingTheRaidInteraction {
    private final BlackEntrance blackEntrance;
    private int numberOfGuns;

    public ReactingTheRaidInteraction(BlackEntrance blackEntrance) {
        this.blackEntrance = blackEntrance;
        numberOfGuns = 0;
    }

    public void reactingToTheRaid(Barmen barmen, SecurityGuard securityGuard, PoliceRaid policeRaid) {
        if (barmen.getRaidKnowledge()) {
            conductingTheGuns(barmen, securityGuard);
            if (numberOfGuns < policeRaid.getAmountPoliceman()) {
                blackEntrance.setOpen();
            }
        }

    }


    private void conductingTheGuns(Barmen barmen, SecurityGuard securityGuard) {
        if (barmen.getArmed())
            numberOfGuns++;
        if (securityGuard.getArmed())
            numberOfGuns++;
        numberOfGuns += securityGuard.getAmountOfArmed();
    }

    @Override
    public String toString() {
        if (!blackEntrance.getConditionOpen())
            return prepareToTheGunplay();
        else return everybodyLeave();
    }

    private String prepareToTheGunplay() {
        return "The number of guns was enough" +
                " so the stuff decided to take a fight with police \n " +
                "Looks like it's the last working day...";
    }

    private String everybodyLeave() {
        return "The number of guns was not enough, so visitors and stuff left the" +
                " bar through the black entrance \n " +
                "Looks like it's the last working day...";
    }
}
