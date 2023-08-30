//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SomeParamTest {
//
//    @ParameterizedTest(name = "{index} {0} {1}")
//    @CsvSource({"1, 2", "3, 4"})
//    public void test() {
//        assertEquals(expected, result);
//    }
//}

/*
1. Empty List:
Input: []
Expected Output: {}

2. Single Transaction:
Input: [Transaction("A123", 100)]
Expected Output: {"A123"=100}

3. Multiple Transactions for Same Account:
Input: [Transaction("A123", 100), Transaction("A123", 200), Transaction("A123", 50)]
Expected Output: {"A123"=350}

4. Multiple Transactions for Different Accounts:
Input: [Transaction("A123", 100), Transaction("B456", 200), Transaction("A123", 50), Transaction("C789", 300)]
Expected Output: {"A123"=150, "B456"=200, "C789"=300}

5. Transactions with Zero Sums:
Input: [Transaction("A123", 0), Transaction("B456", 0), Transaction("A123", 0)]
Expected Output: {"A123"=0, "B456"=0}

6. Transactions with Negative Sums:
Input: [Transaction("A123", -100), Transaction("B456", -200), Transaction("A123", -50)]
Expected Output: {"A123"=-150, "B456"=-200}

7. Transactions with Positive Sums:
Input: [Transaction("A123", 100), Transaction("B456", 200), Transaction("A123", 50)]
Expected Output: {"A123"=150, "B456"=200}

8. Transactions with Mixed Sums:
Input: [Transaction("A123", 100), Transaction("B456", -200), Transaction("A123", 50)]
Expected Output: {"A123"=150, "B456"=-200}

9. Transactions with Different Account Numbers:
Input: [Transaction("A123", 100), Transaction("B456", 200), Transaction("C789", 300)]
Expected Output: {"A123"=100, "B456"=200, "C789"=300}

10. Large Number of Transactions:
Input: A list with a large number of transactions
Expected Output: Verify the performance of the method by checking if it completes in a reasonable time without errors

11. **Transactions with Mixed Positive and Negative Sums:**
    Input: `[Transaction("A123", 100), Transaction("B456", -200), Transaction("A123", 50), Transaction("B456", 300)]`
    Expected Output: `{"A123"=150, "B456"=100}`

12. **Transactions with Null Account Numbers:**
    Input: `[Transaction(null, 100), Transaction("B456", 200), Transaction(null, 50)]`
    Expected Output: `{"B456"=200}`

13. **Transactions with Null Sums:**
    Input: `[Transaction("A123", null), Transaction("B456", 200), Transaction("A123", null)]`
    Expected Output: `{"B456"=200, "A123"=0}`

14. **Transactions with Mixed Null and Non-Null Sums:**
    Input: `[Transaction("A123", null), Transaction("B456", 200), Transaction("A123", 50), Transaction("B456", null)]`
    Expected Output: `{"B456"=200, "A123"=50}`

15. **Transactions with Different Currencies:**
    Input: `[Transaction("A123", 100, "USD"), Transaction("A123", 50, "EUR"), Transaction("A123", 200, "USD")]`
    Expected Output: `{"A123"=300}`

16. **Edge Case: Empty Account Numbers:**
    Input: `[Transaction("", 100), Transaction("", 50)]`
    Expected Output: `{" "=150}`

17. **Edge Case: Null Transaction List:**
    Input: `null`
    Expected Output: `null`

 */