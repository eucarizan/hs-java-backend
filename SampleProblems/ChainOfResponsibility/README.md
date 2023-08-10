# The chain of responsibility


> Wow! This problem is kind of tricky. If you're ready to put your thinking cap on, brace yourself and good luck! Otherwise, you can skip it for now and return any time later.
>
## Overview
[The chain of responsibility](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern) is an object-oriented design pattern that processes a request through a series of handlers (a chain). The request is passed from one handler to another and processed by one or all of these handlers in the chain.

As a rule, an implementation of this pattern requires the following classes and methods:
- **a general handler** is an abstract class or interface with a method **handle/process/etc** and a method to set the next handler;
- one or more **concrete handlers** that implement the general handler.

The functional style allows us to implement this pattern easier. Instead of writing all concrete handlers we can write lambda expressions (or method references). For setting the next handler it's possible to use function composition in similar way to functions.

## Problem
There is a class called `Request(data: String)` for representing some XML requests in a payment system. It has a getter for the data field and a constructor with a single argument.

The following is what the value of `data` looks like in a human-readable format (it is a single line string when processing).
```xml
<request>
  <transaction>
    <type>payment</type>
    <sum>100000</sum>
    <order_id>e94dc619-6172-4ffe-aae8-63112c551570</order_id>
    <desc>We'd like to buy an elephant</desc>
  </transaction>
  <digest>CZVMYTgc3iiOdJjFP+6dhQ==</digest>
</request>
```

You must implement `the chain of responsibility pattern` in the functional style for stage-by-stage request creating.

1) Write the `RequestHandler` interface with a single abstract method called `handle` and one default method; the first method is needed to use lambda expressions. It should accept a `Request` object and then return a new `Request` with changed data. The second method is used to combine several handlers into a single one.

2) Create `commonRequestHandler` that is combined from three existing handlers: `wrapInTransactionTag`, `createDigest` and `wrapInRequestTag`.

> Use the provided template for your solution. Do not change it and read comments in the code. The template is long enough, scroll it to the bottom. **All comments where your code is expected start with !!!**

Further, you can read how the requests should be created. Keep in mind, all handlers have already been implemented and are made available for you. You need to write only a suitable functional interface and compose all existing handlers as functions into one `commonRequestHandler` to follow the described algorithm.

## The algorithm for creating a XML request
0) Initial request data looks like shown below (it contains only business data).
```xml
<type>payment</type><sum>100000</sum><order_id>e94dc619-6172-4ffe-aae8-63112c551570</order_id><desc>We'd like to buy an elephant</desc>
```

1) First, a tag <transaction>...</transaction> is added as border of the data (data is wrapped in the tag). The result:
```xml
<transaction><type>payment</type><sum>100000</sum><order_id>e94dc619-6172-4ffe-aae8-63112c551570</order_id><desc>We'd like to buy an elephant</desc></transaction>
```

2) Then, a digest (MD5) is calculated for entire data created on the previous stage and added as a new tag. The result:
```xml
<transaction><type>payment</type><sum>100000</sum><order_id>e94dc619-6172-4ffe-aae8-63112c551570</order_id><desc>We'd like to buy an elephant</desc></transaction><digest>CZVMYTgc3iiOdJjFP+6dhQ==</digest>
```

3) After that, the data is wrapped in a tag <request>...</request> as shown below. The request is completed.
```xml
<request><transaction><type>payment</type><sum>100000</sum><order_id>e94dc619-6172-4ffe-aae8-
63112c551570</order_id><desc>We'd like to buy an elephant</desc></transaction>
<digest>CZVMYTgc3iiOdJjFP+6dhQ==</digest></request>
```

So, if you have a request data as shown in stage 0, the algorithm should generate the result as shown in stage 3.

> Note, each stage is already implemented for you in a specific `RequestHandler`.