package interaction;

import entities.*;


public final class BeerPurchaseInteraction {

    private final String orderedBeerType;
    private final BeerAmountPrice amountAndPrice;
    private boolean toSell;
    boolean isSuccessful;

    public BeerPurchaseInteraction(String orderedBeerType, BeerAmountPrice amountAndPrice) {
        this.orderedBeerType = orderedBeerType;
        this.amountAndPrice = amountAndPrice;
        toSell = true;
        isSuccessful = false;
    }

    private void drunkCheck(Visitors visitors) {
        if (visitors.getIsDrunk()) {
            toSell = false;
        }
    }

    private void setDrunk(Visitors visitors) {
        if (amountAndPrice.getAmount().equals("halfLiter")) {
            visitors.setDrunk();
        }
    }

    public void sellBeer(Visitors visitors, Barmen barmen) {
        drunkCheck(visitors);
        if (toSell) {
            setDrunk(visitors);
            barmen.addCash(amountAndPrice.getPrice());
            isSuccessful = true;
        }
    }

    @Override
    public String toString() {
        if (isSuccessful)
            return purchaseInfo();
        else return refuse();
    }

    private String refuse() {
        return "Barmen refuses to sell bear to the group of visitors because they are drunk";
    }

    private String purchaseInfo() {
        return "Barmen sold a " + amountAndPrice.getAmount() + " of "
                + orderedBeerType + " and received " + amountAndPrice.getPrice() + " pounds";
    }
}
