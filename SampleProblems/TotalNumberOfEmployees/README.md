# The total number of employees

## Description
Let's say you are developing an employee management system for your company. It has two classes:

- `Employee` with the fields `name` (`String`) and `salary` (`Long`)
- `Department` with the fields `name` (`String`), `code` (`String`), and `employees` (`List<Employee>`).

Both classes have getters for all fields with the corresponding names (`getName()`, `getSalary()`, `getEmployees()` and so on).

Using Stream API, implement a method that calculates **the total number of employees** with `salary >= threshold` for all departments whose code starts with the string `"111-"` (without `""`). Perhaps, the `flatMap` method can help you to implement it.

**Important**. Use the given template for your method. Pay attention to type of argument and the returned value. Please, use only Stream API without loops.

**Examples**: there are 2 departments (in JSON notation) below and threshold = 20 000. The result is 1 (because there is only one suitable employee).

```json
[
  {
    "name": "dep-1",
    "code": "111-1",
    "employees": [
      {
        "name": "William",
        "salary": 20000
      },
      {
        "name": "Sophia",
        "salary": 10000
      }
    ]
  },
  {
    "name": "dep-2",
    "code": "222-1",
    "employees": [
      {
        "name": "John",
        "salary": 50000
      }
    ]
  }
]
```

## Tags
- tags