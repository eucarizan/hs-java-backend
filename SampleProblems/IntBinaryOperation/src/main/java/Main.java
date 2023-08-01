public class Main {
    public static void main(String[] args) {
        IntBinaryOperation add = new Addition(1, 2);
        IntBinaryOperation multiply = new Multiplication(1, 2);

        System.out.println(add.perform());
        System.out.println(multiply.perform());
    }
}

abstract class IntBinaryOperation {
    protected int firstArg;
    protected int secondArg;

    public IntBinaryOperation(int firstArg, int secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    public abstract int perform();
}

class Addition extends IntBinaryOperation {
    public Addition(int firstArg, int secondArg) {
        super(firstArg, secondArg);
    }

    @Override
    public int perform() {
        return firstArg + secondArg;
    }
}

class Multiplication extends IntBinaryOperation {
    public Multiplication(int firstArg, int secondArg) {
        super(firstArg, secondArg);
    }

    @Override
    public int perform() {
        return firstArg * secondArg;
    }
}
