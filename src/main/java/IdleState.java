public class IdleState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {
        // do nothing
    }

    public void acceptingTender(VendingMachine machine) {
        System.out.println("Please select a product first.");
    }

    public void productSelection(VendingMachine machine) {
        System.out.println("Product selected. Please insert money.");
        machine.setState(new AcceptingTenderState());
    }

    public void dispensing(VendingMachine machine) {
        System.out.println("Cannot dispense. No product selected or money inserted.");
    }


}