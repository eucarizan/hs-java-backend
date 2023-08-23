# Bitwise and integers

## Description
Below you can see a code that uses bitwise operations. By default, the debugger shows variables as integer numbers. However, it is much more convenient in this case to see them in the binary format. To do this, right-click on the variable in the **Variables** panel of the debugger and choose `View as > Binary` option (to go back to the default representation choose `View as > Primitive`). Please, give it a try!

```java
class Main {
    public static void main(String[] args) {
        int number1 = 38;
        int number2 = 54;
    
        number1 = number1 << 2;
        number2 = number2 >> 1;
        int result = number2 ^ number1;
    }
}
```

As an answer, enter the binary representation of the result variable that will appear in the debugger with the 0b prefix.

## Tags
- errorless code
- debugging
- debugging simple constructs