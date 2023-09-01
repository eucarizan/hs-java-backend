# The total sum of canceled transactions

## Description
Let's say you are developing a banking system. There are two classes in this system:

- `Transaction` with the fields uuid (`String`), the `State` enum (`CANCELED`, `FINISHED`, `PROCESSING`), `sum` (`Long`)
- `Account` with the fields `number` (`String`), `balance` (`Long`), and `transactions` (`List<Transaction>`)

Both classes have getters for all fields with the corresponding names (getState(), getSum(), getTransactions() and so on).

Using Stream API, implement a method that calculates **the total sum of canceled transactions** for all non-empty accounts (`balance > 0`). Perhaps, flatMap method can help you to implement it.

**Important**. Use the given template for your method. Pay attention to the type of argument and the returned value. Please, use only the Stream API without loops.

**Examples**: there are 2 accounts (in JSON notation) below. The result is 10 000.

```json
[
  {
    "number": "1001",
    "balance": 0,
    "transactions": [
      {
        "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
        "state": "CANCELED",
        "sum": 1000
      }
    ]
  },
  {
    "number": "1002",
    "balance": 8000,
    "transactions": [
      {
        "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
        "state": "FINISHED",
        "sum": 8000
      },
      {
        "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
        "state": "CANCELED",
        "sum": 10000
      }
    ]
  }
]
```

## Tags
- functional programming
- functional streams
- stream pipelines