import java.util.ArrayList;
import java.util.List;

public class Number {
    long number;
    boolean buzz;
    boolean duck;
    boolean palindromic;
    boolean gapful;
    boolean spy;
    boolean square;
    boolean sunny;
    boolean even;
    boolean odd;


    public Number(long number) {
        this.number = number;
        this.buzz = isBuzz();
        this.duck = isDuck();
        this.palindromic = isPalindromic();
        this.gapful = isGapful();
        this.spy = isSpy();
        this.square = isSquare(number);
        this.sunny = isSunny();
        this.even = isEven();
        this.odd = !isEven();
    }

    public boolean hasProperty(String property) {

        return switch (property) {
            case "buzz" -> buzz;
            case "duck" -> duck;
            case "palindromic" -> palindromic;
            case "gapful" -> gapful;
            case "spy" -> spy;
            case "square" -> square;
            case "sunny" -> sunny;
            case "even" -> even;
            case "odd" -> odd;
            default -> false;
        };
    }

    private boolean isBuzz() {
        long digit = number % 10;

        return number % 7 == 0 || digit == 7;
    }

    private boolean isEven() {
        return number % 2 == 0;
    }

    private boolean isDuck() {
        String strN = String.valueOf(number);
        return strN.contains("0") && strN.lastIndexOf("0") > 0;
    }

    private boolean isPalindromic() {
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        return str.contentEquals(sb);
    }

    private boolean isGapful() {
        String numStr = String.valueOf(number);

        if (numStr.length() < 3) {
            return false;
        }

        int gap = Integer.parseInt(numStr.charAt(0) + "" + numStr.charAt(numStr.length() - 1));
        return number % gap == 0;
    }

    private boolean isSpy() {
        long temp = number;
        long sum = 0;
        long product = 1;

        while (temp > 0) {
            sum += temp % 10;
            product *= (long) ((double) temp % 10);
            temp = temp / 10;
        }

        return sum == product;
    }

    private boolean isSunny() {
        long temp = number + 1;

        return isSquare(temp);
    }

    private boolean isSquare(long num) {
        if (num >= 0) {
            long temp = (long) (Math.sqrt(num) + 0.5);
            return temp * temp == num;
        }
        return false;
    }

    public String getProperties() {
        List<String> properties = new ArrayList<>();

        if (buzz) {
            properties.add("buzz");
        }

        if (duck) {
            properties.add("duck");
        }

        if (palindromic) {
            properties.add("palindromic");
        }

        if (gapful) {
            properties.add("gapful");
        }

        if (spy) {
            properties.add("spy");
        }

        if (square) {
            properties.add("square");
        }

        if (sunny) {
            properties.add("sunny");
        }

        if (even) {
            properties.add("even");
        } else {
            properties.add("odd");
        }

        return String.format("%5d is %s%n", number, String.join(", ", properties));
    }

    @Override
    public String toString() {
        return "\nProperties of " + number +
                String.format("%n%11s: %s", "buzz", buzz) +
                String.format("%n%11s: %s", "duck", duck) +
                String.format("%n%11s: %s", "palindromic", palindromic) +
                String.format("%n%11s: %s", "gapful", gapful) +
                String.format("%n%11s: %s", "spy", spy) +
                String.format("%n%11s: %s", "square", square) +
                String.format("%n%11s: %s", "sunny", sunny) +
                String.format("%n%11s: %s", "even", even) +
                String.format("%n%11s: %s", "odd", odd) + "\n";
    }
}
