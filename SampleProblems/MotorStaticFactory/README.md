# Motor static factory

## Description
In the very heart of suburbia, there stood a motor factory; in the very heart of that factory worked a programmer. Implement the static method make of the `MotorStaticFactory` that produces motors of different types. The method takes three parameters: the `type` of a motor as a character, `model` as a string, and `power` as a long number. It should return a new motor according to the `type` with initialized fields.

Here is the correspondence between the passed type and the class of the motor: `'P'` for pneumatic, `'H'` for hydraulic, `'E'` for electric and `'W'` for warp. Ignore the upper/lower case when creating motors, i.e. `'p'` must work as well as `'P'`. If an invalid character is given, the method should return `null`.

Do not change the provided code of the motor classes.

## Tags
- Design Patterns
- Creational patterns
- Static factory idiom

[//]: # (failed test: P P-MOTOR-4000 4000)