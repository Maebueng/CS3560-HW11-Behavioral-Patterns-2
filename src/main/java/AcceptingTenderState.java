public class AcceptingTenderState implements StateOfVendingMachine {
    public void idle(VendingMachine machine) {
        System.out.println("Waiting for sufficient amount...");
        machine.setState(new IdleState());
    }

    public void acceptingTender(VendingMachine machine) {
        // do nothing
    }

    public void productSelection(VendingMachine machine) {
        System.out.println("Product selected. Please insert money.");
        machine.setState(new AcceptingTenderState());
    }

    public void dispensing(VendingMachine machine) {
        machine.setState(new DispensingState());
        System.out.println("Sufficient amount inserted, dispensing item...");
    }
}