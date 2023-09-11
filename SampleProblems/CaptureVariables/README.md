# Capture variables

## Description
There is an interface `Returner`:

```java
interface Returner {

    public String returnString();
    
    public int returnInt();
}
```

You should create an anonymous class that implements the interface and assign the instance to the variable `returner`. The anonymous class must override both methods of the interface. The method `returnString` should capture the string variable `str` from the context and return it, the second method should capture the integer variable `number` from the context and return it. These variables will be accessible during testing.

## Tags
- code organization
- oop
- other concepts
- nested classes 
- anonymous classes