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

    @Test
    void shouldShowEmptyOnCategoriesOtherThanPurchasedTest() {
        String addIncomeResult = manager.processRequest("1, 50");
        assertEquals("Income was added!", addIncomeResult);

        String requestResult = manager.processRequest("2, Candle; 8.84; other");
        assertEquals("Purchase was added!", requestResult);

        String emptyFood = manager.processRequest("3, 1");
        assertEquals("The purchase list is empty", emptyFood);

        String emptyClothes = manager.processRequest("3, 2");
        assertEquals("The purchase list is empty", emptyClothes);

        String emptyEntertainment = manager.processRequest("3, 3");
        assertEquals("The purchase list is empty", emptyEntertainment);
    }

    @Test
    void shouldShowAllItemsPurchasedTest() {
        String addIncomeResult = manager.processRequest("1, 1000");
        assertEquals("Income was added!", addIncomeResult);

        String foodRequest = manager.processRequest("2, Cider Vinegar; 9.50; food");
        assertEquals("Purchase was added!", foodRequest);
        String clothesRequest = manager.processRequest("2, Briefs; 16.22; clothes");
        assertEquals("Purchase was added!", clothesRequest);
        String entertainmentRequest = manager.processRequest(
                "2, Post Malone Concert Ticket; 72.15; entertainment");
        assertEquals("Purchase was added!", entertainmentRequest);
        String otherRequest = manager.processRequest("2, Car Tire; 61.30; other");
        assertEquals("Purchase was added!", otherRequest);

        String expected = """
                All:
                Cider Vinegar $9.50Briefs $16.22Post Malone Concert Ticket $72.15Car Tire $61.30Total sum: $159.17""";
        String allPurchase = manager.processRequest("3, 5")
                .trim().replaceAll("\r\n", "");
        assertEquals(expected, allPurchase);
    }

    @Test
    void givenAllCategoriesPurchasedThenShowEachCategoryTest() {
        String addIncomeResult = manager.processRequest("1, 1000");
        assertEquals("Income was added!", addIncomeResult);

        String foodRequest = manager.processRequest("2, Breadcrumbs; 15; food");
        assertEquals("Purchase was added!", foodRequest);
        String clothesRequest = manager.processRequest("2, Jacket; 6.31; clothes");
        assertEquals("Purchase was added!", clothesRequest);
        String entertainmentRequest = manager.processRequest("2, Cinema; 8.73; entertainment");
        assertEquals("Purchase was added!", entertainmentRequest);
        String otherRequest = manager.processRequest("2, Candle; 8.84; other");
        assertEquals("Purchase was added!", otherRequest);


        String food = manager.processRequest("3, 1")
                .trim().replaceAll("\r\n", "");
        assertEquals("""
                Food:
                Breadcrumbs $15.00Total sum: $15.00""", food);

        String clothes = manager.processRequest("3, 2")
                .trim().replaceAll("\r\n", "");
        assertEquals("""
                Clothes:
                Jacket $6.31Total sum: $6.31""", clothes);

        String entertainment = manager.processRequest("3, 3")
                .trim().replaceAll("\r\n", "");
        assertEquals("""
                Entertainment:
                Cinema $8.73Total sum: $8.73""", entertainment);

        String other = manager.processRequest("3, 4")
                .trim().replaceAll("\r\n", "");
        assertEquals("""
                Other:
                Candle $8.84Total sum: $8.84""", other);
    }
}
