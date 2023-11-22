public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water += water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk += milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans += beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups += cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public void updateMachine(int water, int milk, int beans, int cups, int money) {
        setWater(water);
        setMilk(milk);
        setBeans(beans);
        setCups(cups);
        setMoney(money);
    }

    @Override
    public String toString() {
        return String.format("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money""", water, milk, beans, cups, money);
    }
}
