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

    private int getWater() {
        return water;
    }

    private void setWater(int water) {
        this.water = water;
    }

    private int getMilk() {
        return milk;
    }

    private void setMilk(int milk) {
        this.milk = milk;
    }

    private int getBeans() {
        return beans;
    }

    private void setBeans(int beans) {
        this.beans = beans;
    }

    private int getCups() {
        return cups;
    }

    private void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String updateMachine(String order, int water, int milk, int beans, int cups, int money) {
        return switch (order) {
            case "BUY" -> {
                String canMakeCoffee = canMakeCoffee(water, milk, beans, cups);
                if ("ok".equals(canMakeCoffee)) {
                    setWater(getWater() - water);
                    setMilk(getMilk() - milk);
                    setBeans(getBeans() - beans);
                    setCups(getCups() - cups);
                    setMoney(getMoney() + money);
                    yield "I have enough resources, making you a coffee!";
                }
                yield String.format("Sorry, not enough %s!", canMakeCoffee);
            }
            case "FILL" -> {
                setWater(getWater() + water);
                setMilk(getMilk() + milk);
                setBeans(getBeans() + beans);
                setCups(getCups() + cups);
                yield "filled";
            }
            default -> "wrong";
        };
    }

    private String canMakeCoffee(int waterReq, int milkReq, int beansReq, int cupsReq) {
        if (this.water - waterReq < 0) {
            return "water";
        }
        if (this.milk - milkReq < 0) {
            return "milk";
        }
        if (this.beans - beansReq < 0) {
            return "beans";
        }
        if (this.cups - cupsReq < 0) {
            return "cups";
        }
        return "ok";
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
