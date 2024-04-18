# Zookeeper (Java)
![output](output.gif)

- [Zookeeper (Java)](#zookeeper-java)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Rush into print](#1-rush-into-print)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Example](#13-example)
    - [2: Show me an animal!](#2-show-me-an-animal)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Example](#23-example)
    - [3: What's inside?](#3-whats-inside)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Sustainable care \<3](#4-sustainable-care-3)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)

## Learning outcomes
This project is aimed at our beginners. It helps you understand some syntax basics and learn how to work with variables, data storage types such as arrays, and while loops.

## About
This short code challenge can help the local zoo look after its denizens. You will create a tool for monitoring animals and their status.

## Stages
### 1: Rush into print
#### 1.1 Description
```
You need Java 17 to complete this project since it uses Text Blocks feature that is not present in Java 11.
Remember to choose Java 17 when opening the project in the IDE.
```

There are many animals in the zoo, and all of them need care. The animals must be fed, cleaned, surrounded by their kin, and kept happy. That is a difficult task for our large zoo, so one of your employers has suggested a more convinient way to keep track of everything. She wants to be able to pull up a video feed of any animal in the zoo with the help of a program. Being able to check on each habitat would help the zookeepers take care of our furry friends more efficiently!

In this project, you will create a program that helps the zookeepers check on the animals and make sure that they're doing well. Your product will be able to process commands from the zookeepers and display the animals on a monitor.

#### 1.2 Objectives
To begin with, you will develop a simple printer. Your program should display the text from the output example.

#### 1.3 Example
The output:
```console
I love animals!
Let's check on the animals...
The deer looks fine.
The bat looks happy.
The lion looks healthy.
```

### 2: Show me an animal!
#### 2.1 Description
One of the most important parts of workign with animals is keeping an eye on them. We need to see the animals on the screen to know how they are doing, right? Now we are ready to print something awesome: an image of an animal!

#### 2.2 Objectives
For the second stage, you will need to develop an animal printer. Your program should display the animal identified in the code field.

#### 2.3 Example
Your output should contain the following ASCII image:
```console
Switching on the camera in the camel habitat...
 ___.-''''-.
/___  @    |
',,,,.     |         _.'''''''._
     '     |        /           \
     |     \    _.-'             \
     |      '.-'                  '-.
     |                               ',
     |                                '',
      ',,-,                           ':;
           ',,| ;,,                 ,' ;;
              ! ; !'',,,',',,,,'!  ;   ;:
             : ;  ! !       ! ! ;  ;   :;
             ; ;   ! !      ! !  ; ;   ;,
            ; ;    ! !     ! !   ; ;
            ; ;    ! !    ! !     ; ;
           ;,,      !,!   !,!     ;,;
           /_I      L_I   L_I     /_I
Look at that! Our little camel is sunbathing!
```

### 3: What's inside?
#### 3.1 Description
The third stage requires you to increase the capabilities of your software. Now it should be able to recognize the number of a specific habitat from the input and show the animals living there.

Add all of the variables from the template to a single variable with the list type. The order of variabels matters: they must appear on the list in order in which they're defined in the code. The list must contain all of the variables with no duplicates.

#### 3.2 Objectives
In this stage your program should:
1. Ask for the number of the desired habitat using the following phrase: `Please enter the number of the habitat you would like to view:`
2. Use the input number as an index of your habitats to print its content.
3. End with the following phrase:
```console
___
You've reached the end of the program. To check another habitat, please restart the watcher.
```

#### 3.3 Examples
The greater-than symbol followed by a space(`> `) represents the user input. Notice that it's not part of the input.

**Example 3.3.1**
```console
Please enter the number of the habitat you would like to view: > 5

Switching on the camera in the rabbit habitat...
         ,
        /|      __
       / |   ,-~ /
      Y :|  //  /
      | jj /( .^
      >-"~"-v"
     /       Y
    jo  o    |
   ( ~T~     j
    >._-' _./
   /   "~"  |
  Y     _,  |
 /| ;-"~ _  l
/ l/ ,-"~    \
\//\/      .- \
 Y        /    Y
 l       I     !
 ]\      _\    /"\
(" ~----( ~   Y.  )
It looks like we will soon have more rabbits!
---
You've reached the end of the program. To check another habitat, please restart the watcher.
```

**Example 3.3.2**
```console
Please enter the number of the habitat you would like to view: > 4

Switching on the camera in the bat habitat...
_________________               _________________
 ~-.              \  |\___/|  /              .-~
     ~-.           \ / o o \ /           .-~
        >           \\  W  //           <
       /             /~---~\             \
      /_            |       |            _\
         ~-.        |       |        .-~
            ;        \     /        i
           /___      /\   /\      ___\
                ~-. /  \_/  \ .-~
                   V         V
This bat looks like it's doing fine.
---
You've reached the end of the program. To check another habitat, please restart the watcher.
```

### 4: Sustainable care <3
#### 4.1 Description
Now it's time to make our project user-friendly. In this final stage, you'll make your software ready for the zoo staff to use. Your program should understand the habitat numbers, show the animals, and be able to work continuously without having to be restarted.

#### 4.2 Objectives
Your tasks at this point:
1. Your program should repeat the behavior from the previous stage, bot now in a loop.
2. Do not forget to include an exit opportunity: inputting `exit` should end the program.
3. When the program is done running, it should print: `See you later!`

#### 4.3 Examples
The greater-than symbol followed by a space(`> `) represents the user input. Notice that it's not part of the input.

The final version of the program should run like this:

**Example 4.3.1**
```console
Please enter the number of the habitat you would like to view: > 3

Switching on the camera in the goose habitat...

                                    _
                                ,-"" "".
                              ,'  ____  `.
                            ,'  ,'    `.  `._
   (`.         _..--.._   ,'  ,'        \    \
  (`-.\    .-""        ""'   /          (  d _b
 (`._  `-"" ,._             (            `-(   \
 <_  `     (  <`<            \              `-._\
  <`-       (__< <           :
   (__        (_<_<          ;
    `------------------------------------------
The goose is staring intently at you... Maybe it's time to change the channel?
Please enter the number of the habitat you would like to view: > 1

Switching on the camera in the lion habitat...
                                               ,w.
                                             ,YWMMw  ,M  ,
                        _.---.._   __..---._.'MMMMMw,wMWmW,
                   _.-""        '''           YP"WMMMMMMMMMb,
                .-' __.'                   .'     MMMMW^WMMMM;
    _,        .'.-'"; `,       /`     .--""      :MMM[==MWMW^;
 ,mM^"     ,-'.'   /   ;      ;      /   ,       MMMMb_wMW"  @\
,MM:.    .'.-'   .'     ;     `\    ;     `,     MMMMMMMW `"=./`-,
WMMm__,-'.'     /      _.\      F'''-+,,   ;_,_.dMMMMMMMM[,_ / `=_}
"^MP__.-'    ,-' _.--""   `-,   ;       \  ; ;MMMMMMMMMMW^``; __|
           /   .'            ; ;         )  )`{  \ `"^W^`,   \  :
          /  .'             /  (       .'  /     Ww._     `.  `"
         /  Y,              `,  `-,=,_{   ;      MMMP`""-,  `-._.-,
        (--, )                `,_ / `) \/"")      ^"      `-, -;"\:
The lion is roaring!
Please enter the number of the habitat you would like to view: > exit
See you later!
```