# Divisors finding

## Description
Using the given code and the debugger, find the smallest divisor of the number 5977.


```java
class Main {
    public static void main(String[] args) {
        boolean result = isPrime(5977);
    }

    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i != 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
```
## Hint
- put the breakpoint inside the else statement

## Tags
- errorless code
- debugging
- debugging simple constructs