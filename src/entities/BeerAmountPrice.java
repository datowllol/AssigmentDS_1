package entities;

public enum BeerAmountPrice {
    pint("pint", 15),
    thirdLiter("thirdLitter", 12),
    halfLiter("halfLiter", 20);

    private final String amount;
    private final int price;

    BeerAmountPrice(String amount, int price) {
        this.amount = amount;
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
