public class DispensingState implements StateOfVendingMachine {

    public void idle(VendingMachine machine) {
        System.out.println("Waiting for sufficient amount...");
        machine.setState(new IdleState());
    }

    public void acceptingTender(VendingMachine machine) {
        machine.setState(new AcceptingTenderState());
    }

    public void productSelection(VendingMachine machine) {
        System.out.println("Product selected. Please insert money.");
        machine.setState(new AcceptingTenderState());
    }

    public void dispensing(VendingMachine machine) {
        // do nothing
    }
}

