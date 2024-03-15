# Carsharing

- [Carsharing](#carsharing)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Initialization](#1-initialization)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)

## Learning outcomes
Car-sharing is becoming a more and more popular green alternative to owning a car. Let's create a program that manages a car-sharing service allowing companies to rent out their cars and find customers.

## About
During the project implementation, you will learn the basics of SQL and work with the H2 database. You will also learn about advanced Java features such as Collections.

## Stages
### 1: Initialization
#### 1.1 Description
In this project, you will work with the H2 database. It is an open-source lightweight Java database that can be embedded in Java applications or run in the client-server mode. Mainly, the H2 database can be configured to run as an in-memory database, which means that data will not persist on the disk. Because of the embedded database, it is not used for product development but mostly for development and testing purposes.

Before you start with the project, you need to [connect to the database from Java](https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.htm). For your implementation, do not use login credentials.

Let's start by creating a `COMPANY` table that will store information about the created car companies.

#### 1.2 Objectives
Create a single table named `COMPANY` with the following columns:

- `ID` with the type `INT`;
- `NAME` with the type `VARCHAR`.

After running the program, it should create the database file in the `carsharing/db/` folder, initialize the table described above, and stop.

The database file name is obtained from the command-line arguments. Here is an example of args: `-databaseFileName` carsharing. If the `-databaseFileName` argument is not given, then the database file name can be anything. Your database URL should work out to be like the following: `jdbc:h2:./src/carsharing/db/{DATABASE_NAME}`

>To pass the tests, you have to enable the auto-commit mode so that all changes are automatically saved in the database file. To do that, call the method `connection.setAutoCommit(true)` of the `Connection` object.

<hr/>

[<<](../README.md)