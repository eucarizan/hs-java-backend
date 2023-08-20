# Composite numbers

## Description
You're given a method `isComposite` that checks if the given number is composite or not. A composite number is a positive integer that has at least one divisor other than 1 and itself. This method takes one parameter, a long number, and returns a boolean value. Write the full declaration of this method in one line.

**Note that the method is static and public!**
```java
import java.util.Scanner;

public class Main {

    /*...isComposite(...) */ {
        for (long i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final long number = scanner.nextLong();
            System.out.println(isComposite(number));
    }
}
```

## Tags
- code organization
- methods
- declaring a method