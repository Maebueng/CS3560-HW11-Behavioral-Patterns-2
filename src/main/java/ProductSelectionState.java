public class ProductSelectionState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {
        machine.setState(new IdleState());
    }

    public void acceptingTender(VendingMachine machine) {
        machine.setState(new AcceptingTenderState());
    }

    public void productSelection(VendingMachine machine) {
        // do nothing
    }

    public void dispensing(VendingMachine machine) {
        machine.setState(new DispensingState());
    }
}