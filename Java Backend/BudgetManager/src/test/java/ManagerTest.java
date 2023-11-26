import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager();
    }

    @Test
    void request0Test() {
        String result = manager.processRequest("0");
        assertEquals("Bye!", result);
    }

    @Test
    void request1Test() {
        String requestResult = manager.processRequest("1, 1000");
        assertEquals("Income was added!", requestResult);

        String incomeAdded = manager.processRequest("4");
        assertEquals("Balance: $1000.00", incomeAdded);
    }

    @Test
    void request23Test() {
        String requestResult = manager.processRequest("2, Red Fuji Apple; 5.99; Food");
        assertEquals("Purchase was added!", requestResult);

        String purchaseList = "Red Fuji Apple $5.99Total sum: $5.99";
        String purchaseSuccess = manager.processRequest("3, 1")
                .replace("\r\n", "");;
        assertEquals(purchaseList, purchaseSuccess);
    }

    @Test
    void request4Test() {
        String addIncomeResult = manager.processRequest("1, 10");
        assertEquals("Income was added!", addIncomeResult);

        String requestResult = manager.processRequest("2, Red Fuji Apple; 5.99; Food");
        assertEquals("Purchase was added!", requestResult);

        String getBalanceResult = manager.processRequest("4");
        assertEquals("Balance: $4.01", getBalanceResult);
    }

    // TODO: given 1 purchase, test for other empty different categories
    // TODO: given all category purchased, test for different categories
}
