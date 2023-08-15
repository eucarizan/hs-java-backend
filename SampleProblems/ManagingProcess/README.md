# Managing a process

## Description
A program system manages a long process. To start the process you should invoke the static method `startLongProcess` that takes a callback. Here is the declaration of this method:

```java
public static void startLongProcess(Callback callback)
```

The `Callback` interface has three methods:
```java
interface Callback {

    void onStarted();
    
    void onStopped(String cause);
    
    void onFinished(int code);
}
```

You should create an anonymous class that implements the `Callback` interface and pass the instance to the method `startLongProcess` as an argument. The method will call the passed callbacks at different stages of the process.

The anonymous class must override all methods of the `Callback` interface (otherwise the code won't be compiled).

- The method `onStarted` must print the message **"The process started"** in the standard output.
- The method `onStopped` takes a cause and prints it to the standard output.
- The method `onFinished` takes a code of the process completion. It should print **"The process successfully finished"** if the process is finished with the code 0, otherwise, the method should print the text **"The process is finished with error: "** plus the given code (for example, **"The process is finished with error: 43"**).

All strings must be printed without quotes. Each message should be in a new line.

Use the provided code template, do not copy the given class and the method.

If the instance (`callback`) of your anonymous class is created correctly, after calling the following code:

```java
callback.onStarted();
callback.onFinished(0);
```

you will get the following output:
```console
The process started
The process successfully finished
```

## Tags
- oop
- nested classes
- anonymous classes properties