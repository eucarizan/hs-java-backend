# The total sum of transaction by each account

## Description
You have two classes:

- **Account**: number: String, balance: Long
- **Transaction**: uuid: String, sum: Long, account: Account

Both classes have getters for all fields with the corresponding names (getNumber(), getSum(), getAccount() and so on).

Write a collector that calculates **the total sum of transactions (long type, not integer) by each account (i.e. by account number)**. The collector will be applied to **a stream of transactions**.

## Tags
- functional programming
- functional streams
- grouping collectors