import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTests {

    @Test
    public void buySnackTest() {
        // Chain: Coke -> Pepsi -> Cheetos -> Doritos -> KitKat -> Snickers
        SnackDispenserHandler snickersHandler = new SnackHandler(null, "Snickers");
        SnackDispenserHandler kitKatHandler = new SnackHandler(snickersHandler, "KitKat");
        SnackDispenserHandler doritosHandler = new SnackHandler(kitKatHandler, "Doritos");
        SnackDispenserHandler cheetosHandler = new SnackHandler(doritosHandler, "Cheetos");
        SnackDispenserHandler pepsiHandler = new SnackHandler(cheetosHandler, "Pepsi");
        SnackDispenserHandler cokeHandler = new SnackHandler(pepsiHandler, "Coke");

        Snack coke = new Snack("Coke", 1.50, 5);

        // Verify initial quantity
        assertEquals(5, coke.getQuantity());

        // Successful Purchase
        cokeHandler.handleRequest("Coke", coke, 2.00);

        // Verify quantity dropped by 1
        assertEquals(4, coke.getQuantity());
    }

    @Test
    public void buySnackTestOutOfStock() {
        SnackDispenserHandler snickersHandler = new SnackHandler(null, "Snickers");
        Snack snickers = new Snack("Snickers", 1.00, 1);

        assertEquals(1, snickers.getQuantity());

        // First purchase: verify quantity changed from 0 to 1
        snickersHandler.handleRequest("Snickers", snickers, 1.00);
        assertEquals(0, snickers.getQuantity());

        // Second purchase: should fail because it's out of stock (quantity is 0)
        snickersHandler.handleRequest("Snickers", snickers, 1.00);
        assertEquals(0, snickers.getQuantity(), "Quantity should remain 0 when out of stock");
    }
}
