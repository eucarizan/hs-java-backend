# Cinema Room Manager

- [Cinema Room Manager](#cinema-room-manager)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Arrangement](#1-arrangement)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Example](#13-example)
    - [2: Sold!](#2-sold)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)
    - [3: Tickets](#3-tickets)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Menu, please!](#4-menu-please)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)
    - [5: Errors!](#5-errors)
      - [5.1 Description](#51-description)
      - [5.2 Objectives](#52-objectives)
      - [5.3 Examples](#53-examples)
  - [Nice to have](#nice-to-have)

## Learning outcomes
This project is a good opportunity to work with input and output in Java.
You will deal with arrays and functions as well as loops and conditional statements

## About
Cinema has been a part of the entertainment industry for a long time: a good movie is a way to escape reality and live through a variety of emotions. The best cinema experience you can get is probably in a cinema theatre. In this project, you will create an application that helps manage a cinema theatre: sell tickets, check available seats, see sales statistics, and more.

## Stages
### 1: Arrangement
#### 1.1 Description
There are many enjoyable activities on this funny little planet Earth, and still, the happiest, simplest, and most fulfilling one is probably going to the movies. Going with friends, going with loved ones, experiencing a whole new adventure from the safety of a cinema seat, surrounded by like-minded fellow travelers.

As a beginner developer, you can contribute to creating this wonderful cinema experience. Your good friends asked you to help them create an application for a cinema theatre where people can get tickets, reserve seats, and enjoy their movie night.

#### 1.2 Objectives
There is not a lot of space in our new cinema theatre, so you need to take into account the restrictions on the number of seats. Your friends said that the room would fit 7 rows of 8 seats. Your task is to help them visualize the seating arrangement by printing the scheme to the console.

Your output should be like in the example below and should contain 9 lines.

#### 1.3 Example
```console
Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
```

### 2: Sold!
#### 2.1 Description
Good job: our friends really liked your program! Now they want to expand their theater and add screen rooms with more seats. However, this is expensive, so they want to make sure this will pay off. Help them calculate the profit from all the sold tickets depending on the number of available seats.

#### 2.2 Objectives
In this stage, you need to read two positive integer numbers from the input: the number of rows and the number of seats in each row. The ticket price is determined by the following rules:

- If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
- In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the other 5 rows.

Calculate the profit from the sold tickets depending on the number of seats and print the result as shown in the examples below. After that, your program should stop. Note that in this project, the number of rows and seats won't be greater than 9.

#### 2.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 2.3.1**
```console
Enter the number of rows:
> 4
Enter the number of seats in each row:
> 5
Total income:
$200
```

**Example 2.3.2**
```console
Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9
Total income:
$648
```

**Example 2.3.3**
```console
Enter the number of rows:
> 9
Enter the number of seats in each row:
> 7
Total income:
$560
```

### 3: Tickets
#### 3.1 Description
When choosing a ticket you are guided not only by your space preference but also by your finances. Let's implement the opportunity to check the ticket price and see the reserved seat.

#### 3.2 Objectives
Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. Then, read two integer numbers from the input: a row number and a seat number in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. The ticket price is determined by the same rules as the previous stage:

- If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
- In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the last 5 rows.

After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the `B` symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.

#### 3.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 3.3.1**
```console
Enter the number of rows:
> 7
Enter the number of seats in each row:
> 8

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S

Enter a row number:
> 3
Enter a seat number in that row:
> 6

Ticket price: $10

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S B S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
```

**Example 3.3.2**
```console
Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S S S S S S
7 S S S S S S S S S
8 S S S S S S S S S

Enter a row number:
> 6
Enter a seat number in that row:
> 5

Ticket price: $8

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S B S S S S
7 S S S S S S S S S
8 S S S S S S S S S
```

### 4: Menu, please!
#### 4.1 Description
The theatre is getting popular, and the customers started complaining that it's not practical that the program stops after buying one ticket. Let's add a menu that will allow them to buy tickets and display the current state of the seating arrangement when needed.

#### 4.2 Objectives
At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. Then, it should print a menu with the following three items:

- `Show the seats` should print the current seating arrangement. The empty seats should be marked with an `S` symbol, and taken seats are marked with a `B` symbol.
- `Buy a ticket` should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a `B` when the item `Show the seats` is called.
- `Exit` should stop the program.

#### 4.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.
```console
Enter the number of rows:
> 7
Enter the number of seats in each row:
> 7

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 0
```

### 5: Errors!
#### 5.1 Description
Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. The stats will show the current income, total income, the number of available seats, and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience: it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

#### 5.2 Objectives
Now your menu should look like this:
```console
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
```

When the item `Statistics` is chosen, your program should print the following information:
- The number of purchased tickets;
- The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
- Current income;
- The total income that shows how much money the theatre will get if all the tickets are sold.

The rest of the menu items should work the same way as before, except the item `Buy a ticket` shouldn't allow a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print `That ticket has already been purchased!` and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print `Wrong input!` and ask to enter different seat coordinates until the user picks an available seat.


#### 5.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.
```console
Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

That ticket has already been purchased!

Enter a row number:
> 10
Enter a seat number in that row:
> 20

Wrong input!

Enter a row number:
> 4
Enter a seat number in that row:
> 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0
```


## Nice to have
- [ ] Break down the program to classes
- [ ] Create unit tests