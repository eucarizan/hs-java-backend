# Remote control

## Description
Suppose you are building a remote control application. It performs three commands: turning on the TV, changing the channel to a specific number, and turning off the TV. Use the command pattern to implement this application.

Use the following guidelines.

- Don't change the provided code.
- The first command to execute is to turn on the TV. The `TurnOn` command must print `Turning on the TV`.
- Next, change channels to the inputs given by the user. The user must give only three inputs. The `ChangeChannel` command will print `Channel was changed to X`. X is the number given by the user.
- The last command is to turn off the TV. The `TurnOff` command must print `Turning off the TV`.

## Examples
**Sample Input 1:**
```console
4 7 2
```

**Sample Output 1:**
```console
Turning on the TV
Channel was changed to 4
Channel was changed to 7
Channel was changed to 12
Turning off the TV
```

## Tags
- design patterns
- behavioral patterns
- command