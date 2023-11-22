public enum CoffeeType {
    ESPRESSO(1, 250, 0, 16, 1, 4),
    LATTE(2, 350, 75, 20, 1, 7),
    CAPPUCCINO(3, 200, 100, 12, 1, 6);
    ;

    private final int num;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;
    private final int cost;

    CoffeeType(int num, int water, int milk, int beans, int  cups, int cost) {
        this.num = num;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cost = cost;
    }

    private int getNum() {return num;}

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getCost() {
        return cost;
    }

    public static CoffeeType findByNum(int num) {
        for (CoffeeType type : values()) {
            if (type.num == num) {
                return type;
            }
        }
        return null;
    }
}