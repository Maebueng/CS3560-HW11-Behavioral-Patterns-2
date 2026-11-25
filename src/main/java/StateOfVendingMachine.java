public interface StateOfVendingMachine {
    void idle(VendingMachine machine);
    void acceptingTender(VendingMachine machine);
    void productSelection(VendingMachine machine);
    void dispensing(VendingMachine machine);
}