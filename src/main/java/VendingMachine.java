public class VendingMachine {
    private StateOfVendingMachine state = new IdleState();

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public StateOfVendingMachine getState() {
        return state;
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