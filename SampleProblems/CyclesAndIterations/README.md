#  Cycles and iterations

## Description
Look at the following code:

```java
class Main {
public static void main(String[] args) {
fibonacci();
}

    static void fibonacci() {
        int prev = 0;
        int current = 1;
        for (int i = 0; i <= 25; i++) {
            int swap = prev;
            prev = current;
            current += swap;
            System.out.println(current);
        }
    }
}
```

What is the value of the current variable after it has been updated in the 20th iteration (i == 19)?

## Tags
- errorless code
- debugging
- debugging simple constructs