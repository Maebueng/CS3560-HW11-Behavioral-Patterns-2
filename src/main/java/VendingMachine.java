import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine state = new IdleState();
    private List<Snack> inventory = new ArrayList<>();
    private SnackDispenserHandler handlerHead;

    private String selectedSnackName;
    private double insertedMoney;

    public VendingMachine(SnackDispenserHandler handlerHead) {
        this.handlerHead = handlerHead;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void addSnack(Snack snack) {
        inventory.add(snack);
    }

    public Snack getSnack(String name) {
        for (Snack s : inventory) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void selectSnack(String snackName) {
        this.selectedSnackName = snackName;
        // Trigger state transition for product selection
        state.productSelection(this);
    }

    public void insertMoney(double amount) {
        this.insertedMoney = amount;
        // Trigger state transition for accepting tender
        state.acceptingTender(this);

        // Once money is inserted, proceed to dispense
        dispenseSnack();
    }

    public void dispenseSnack() {
        // Trigger dispensing state
        state.dispensing(this);

        // Find the snack and pass it down the Chain of Responsibility
        Snack snack = getSnack(selectedSnackName);
        if (handlerHead != null) {
            handlerHead.handleRequest(selectedSnackName, snack, insertedMoney);
        }

        // Reset back to Idle after transaction finishes
        state.idle(this);
    }

    public void idle() {
        state.idle(this);
    }

    public void acceptingTender() {
        state.acceptingTender(this);
    }

    public void productSelection() {
        state.productSelection(this);
    }

    public void dispensing() {
        state.dispensing(this);
    }
}