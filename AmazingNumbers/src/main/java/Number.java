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
    boolean jumping;
    boolean happy;
    boolean sad;


    public Number(long number) {
        this.number = number;
        this.buzz = isBuzz();
        this.duck = isDuck();
        this.palindromic = isPalindromic();
        this.gapful = isGapful();
        this.spy = isSpy();
        this.square = isSquare(number);
        this.sunny = isSunny();
        this.jumping = isJumping();
        this.happy = isHappy();
        this.sad = !happy;
        this.even = isEven();
        this.odd = !even;
    }

    public List<String> getPropertiesList() {
        List<String> list = new ArrayList<>();
        if (buzz) {
            list.add("buzz");
        }

        if (duck) {
            list.add("duck");
        }

        if (palindromic) {
            list.add("palindromic");
        }

        if (gapful) {
            list.add("gapful");
        }

        if (spy) {
            list.add("spy");
        }

        if (square) {
            list.add("square");
        }

        if (sunny) {
            list.add("sunny");
        }

        if (jumping) {
            list.add("jumping");
        }

        if (happy) {
            list.add("happy");
        } else {
            list.add("sad");
        }

        if (even) {
            list.add("even");
        } else {
            list.add("odd");
        }

        return list;
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

    private boolean isJumping() {
        long n = number % 10;
        long temp = number / 10;

        if (temp == 0) {
            return true;
        }

        while (temp > 0) {
            long m = temp % 10;
            if (Math.abs(m - n) != 1) {
                return false;
            }

            n = m;
            temp /= 10;
        }

        return true;
    }

    private boolean isHappy() {
        long n = number;

        if (n == 1 || n == 7) {
            return true;
        }

        long sum = n, x = n;

        while (sum > 9) {
            sum = 0;

            while (x > 0) {
                long d = x % 10;
                sum += d * d;
                x /= 10;
            }

            if (sum == 1) {
                return true;
            }
            x = sum;
        }

        return sum == 7;
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

        if (jumping) {
            properties.add("jumping");
        }

        if (happy) {
            properties.add("happy");
        } else {
            properties.add("sad");
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
                String.format("%n%11s: %s", "jumping", jumping) +
                String.format("%n%11s: %s", "happy", happy) +
                String.format("%n%11s: %s", "sad", sad) +
                String.format("%n%11s: %s", "even", even) +
                String.format("%n%11s: %s", "odd", odd) + "\n";
    }
}
