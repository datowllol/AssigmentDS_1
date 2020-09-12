import entities.*;
import interaction.*;


public class Main {
    public static void main(String[] args) {
        Barmen barmen = new Barmen(true);
        SecurityGuard securityGuard = new SecurityGuard(true);
        PoliceRaid policeRaid = new PoliceRaid(2);
        BlackEntrance blackEntrance = new BlackEntrance();
        Saloon saloon = new Saloon(4);

        saloon.add_table(2);
        saloon.add_table(4);
        saloon.add_table(3);

        EntranceInteraction entranceInteraction = new EntranceInteraction(securityGuard, barmen, policeRaid);
        OccupationProcess occupationProcess = new OccupationProcess(saloon);
        NormalLeaveProcess normalLeaveProcess = new NormalLeaveProcess(saloon);
        ReactingTheRaidInteraction reactingTheRaidInteraction = new ReactingTheRaidInteraction(blackEntrance);

        System.out.println("Location is set\nFirst day starts");

        Visitors visitorGroup1 = new Visitors(4, false, true);
        entranceInteraction.entranceCheck(visitorGroup1);
        occupationProcess.occupyTable(visitorGroup1);
        System.out.println(occupationProcess.toString());

        BeerPurchaseInteraction beerPurchaseInteraction1 = new BeerPurchaseInteraction("unfiltered light beer", BeerAmountPrice.halfLiter);
        beerPurchaseInteraction1.sellBeer(visitorGroup1, barmen);
        System.out.println(beerPurchaseInteraction1.toString());

        Visitors visitorGroup2 = new Visitors(5, true, false);
        entranceInteraction.entranceCheck(visitorGroup2);
        occupationProcess.occupyTable(visitorGroup2);
        System.out.println(occupationProcess.toString());

        BeerPurchaseInteraction beerPurchaseInteraction2 = new BeerPurchaseInteraction("dark beer", BeerAmountPrice.thirdLiter);
        beerPurchaseInteraction2.sellBeer(visitorGroup1, barmen);
        System.out.println(beerPurchaseInteraction2.toString());

        Visitors visitorGroup3 = new Visitors(2, false, false);
        entranceInteraction.entranceCheck(visitorGroup3);
        occupationProcess.occupyTable(visitorGroup3);
        System.out.println(occupationProcess.toString());

        normalLeaveProcess.freeTable(visitorGroup1);
        System.out.println(normalLeaveProcess.toString());
        entranceInteraction.leaveCheck(visitorGroup1);

        entranceInteraction.policeRaidCheck(policeRaid, barmen);
        System.out.println(entranceInteraction.toString());

        BeerPurchaseInteraction beerPurchaseInteraction3 = new BeerPurchaseInteraction("dark unfiltered beer", BeerAmountPrice.pint);
        beerPurchaseInteraction3.sellBeer(visitorGroup3, barmen);
        System.out.println(beerPurchaseInteraction3.toString());

        normalLeaveProcess.freeTable(visitorGroup3);
        System.out.println(normalLeaveProcess.toString());
        entranceInteraction.leaveCheck(visitorGroup3);


        System.out.println("Day ends, total earnings = " + barmen.getStoredCash() + "\n New day starts");

        Visitors visitorGroup4 = new Visitors(3, false, false);
        entranceInteraction.entranceCheck(visitorGroup4);
        occupationProcess.occupyTable(visitorGroup4);
        System.out.println(occupationProcess.toString());

        BeerPurchaseInteraction beerPurchaseInteraction4 = new BeerPurchaseInteraction("unfiltered light beer", BeerAmountPrice.halfLiter);
        beerPurchaseInteraction1.sellBeer(visitorGroup4, barmen);
        System.out.println(beerPurchaseInteraction4.toString());

        Visitors visitorGroup5 = new Visitors(5, true, false);
        entranceInteraction.entranceCheck(visitorGroup5);
        occupationProcess.occupyTable(visitorGroup5);
        System.out.println(occupationProcess.toString());

        BeerPurchaseInteraction beerPurchaseInteraction6 = new BeerPurchaseInteraction("dark beer", BeerAmountPrice.thirdLiter);
        beerPurchaseInteraction6.sellBeer(visitorGroup4, barmen);
        System.out.println(beerPurchaseInteraction6.toString());

        Visitors visitorGroup6 = new Visitors(2, false, true);
        entranceInteraction.entranceCheck(visitorGroup6);
        occupationProcess.occupyTable(visitorGroup6);
        System.out.println(occupationProcess.toString());

        normalLeaveProcess.freeTable(visitorGroup4);
        System.out.println(normalLeaveProcess.toString());
        entranceInteraction.leaveCheck(visitorGroup4);

        policeRaid.startRaid();
        entranceInteraction.policeRaidCheck(policeRaid, barmen);
        System.out.println(entranceInteraction.toString());
        reactingTheRaidInteraction.reactingToTheRaid(barmen, securityGuard, policeRaid);
        System.out.println(reactingTheRaidInteraction.toString());
    }
}
