package practices.practice1;

public enum BuyerClass {
    BASIC(0.0d),
    SILVER(0.01d),
    GOLD(0.02d),
    PLATINUM(0.03d);

    private final double rate;

    BuyerClass(double rate){
        this.rate = rate;
    }

    public double getRate(){
        return rate;
    }

}

//The BuyerClass enum represents the different classes of buyers, each with a corresponding discount rate.
// The enum constants (BASIC, SILVER, GOLD, PLATINUM) are predefined values that cannot be changed.
// The rate field stores the discount rate for each class, and the getRate() method provides access to this value.
