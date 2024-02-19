# Budget Manager

- [Budget Manager](#budget-manager)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Count my money](#1-count-my-money)
      - [1.1 Description](#11-description)
      - [1.2 Example](#12-example)
    - [2: Make a menu](#2-make-a-menu)
      - [2.1 Description](#21-description)
      - [2.2 Example](#22-example)
    - [3: Oh the things you can buy](#3-oh-the-things-you-can-buy)
      - [3.1 Description](#31-description)
      - [3.2 Example](#32-example)
    - [4: Memorable purchases](#4-memorable-purchases)
      - [4.1 Description](#41-description)
      - [4.2 Examples](#42-examples)
  - [Code](#code)

## Learning outcomes
You will create a very applicable product, and in the meanwhile also get acquainted with the basic concepts of programming in Java. You will deal with the widest variety of tools: work with strings, perform mathematical calculations, sort the data, and work with files.

## About
Not to sound overly serious, but it’s very important to manage your budget. This implies analyzing your expenses and estimating the income, which sometimes may be difficult to do yourself. Luckily, technology is there to assist: you can create your own personal budget manager program that counts the ins and outs and helps control the finances.

## Stages
### 1: Count my money
#### 1.1 Description
First, let’s implement the counting of your purchases. It’s much easier to analyze when your expenses are presented as a list. Read data from the console and at the end show the list of all purchases and its total amount.
It should be displayed as follows: `Total: $23.00`

Your program should process every line the user inputs. To end the input, the user should type [End-of-file](https://en.wikipedia.org/wiki/End-of-file) symbol that tells your operating system that no more input will be provided. It's `Ctrl+D` on Linux and Mac and `Ctrl+Z` on Windows. Don't be scared: you don’t have to implement it yourself, this is a special built-in hot-key that gives the command to stop input. See for yourself!

#### 1.2 Example
The greater-than symbol followed by a space (`> `) represents the user input. Notice that it's not part of the input.
```
> Almond 250gm $35.43
> LEGO DUPLO Town Farm Animals $10.10
> Sensodyne Pronamel Toothpaste $19.74
> Hershey's milk chocolate bars $8.54
> Gildan LT $8.61
Almond 250gm $35.43
LEGO DUPLO Town Farm Animals $10.10
Sensodyne Pronamel Toothpaste $19.74
Hershey's milk chocolate bars $8.54
Gildan LT $8.61

Total: $82.42
```

<hr/>

### 2: Make a menu
#### 2.1 Description
Let's make your application more convenient. Only counting the expenses is a little bit sad, right?

To make your application flexible and functional, add a menu that consists of 4 items.

1. **Add Income**. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
2. **Add Item**. This item should add a purchase to the list. You have implemented this feature in the previous stage.
3. **Show the list of purchases**. This menu item should display a list of all expenses and incomes in the order they were made.
4. **Balance**. Show the balance.
5. **Exit**. Exit the program. Make this item under number **0**, not number 5.

Notice, that the amount of remaining money cannot be negative. In this case, make the balance equal to $0.

When displaying the price or the total amount, print 2 numbers after the point.
Example: `$14.20`
Follow this rule in the next stages.

#### 2.2 Example
The greater-than symbol followed by a space (`> `) represents the user input. Notice that it's not part of the input.
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 1

Enter income:
> 1000
Income was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 4

Balance: $1000.00

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

The purchase list is empty

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 2

Enter purchase name:
>Red Fuji Apple
Enter its price:
> 5.99
Item was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

Red Fuji Apple $5.99
Total sum: $5.99

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 0

Bye!
```

<hr/>

### 3: Oh the things you can buy
#### 3.1 Description
To better control the expenses, we need to categorize our purchases. It helps to see how exactly your budget is distributed: you may be actually quite surprised!

Implement a function that assigns a purchase to a specific category.

The program should have the following categories:
**Food**
**Clothes**
**Entertainment**
**Other**

The function allows you to output the shopping list by type. After selecting the action of showing the list of expenses, offer to show either a certain category or a general list. At the end print the total amount of purchases that are on the list.

#### 3.2 Example
The greater-than symbol followed by a space (`> `) represents the user input. Notice that it's not part of the input.
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

The purchase list is empty!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 2

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 1

Enter purchase name:
> Milk
Enter its price:
> 3.5
Purchase was added!

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 5

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 4

Other:
The purchase list is empty!

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 1

Food:
Milk $3.50
Total sum: $3.50

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 5

All:
Milk $3.50
Total sum: $3.50

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 6

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 0

Bye!
```

<hr/>

### 4: Memorable purchases
#### 4.1 Description
What's the point of counting the money if the results are lost and forgotten once you close the program? To allow for some long-term budget planning, we need to save purchases to file. Add items Save and Load to the menu.

**Save** should save all purchases to the file.
**Load** should load all purchases from the file.

Use the `purchases.txt` file to store purchases.

#### 4.2 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Notice that it's not part of the input.

**Example 1**:
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 1

Enter income:
> 1000
Income was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 2

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 1

Enter purchase name:
> Almond 250g
Enter its price:
> 35.43
Purchase was added!

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 5

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 5

Purchases were saved!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 0

Bye!
```

**Example 2**:
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 6

Purchases were loaded!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 3

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 1

Food:
Almond 250g $35.43
Total sum: $35.43

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 5

All:
Almond 250g $35.43
Total sum: $35.43

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 6

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 4

Balance: $964.57

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 0

Bye!
```

<hr/>

## Code
- [solution class](./src/main/java/Manager.java)
- [unit tests](./src/test/java/ManagerTest.java)