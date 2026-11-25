public class VendingMachine {
    private State state = new IdleState();

    public void setState(State state) {
        this.state = state;
    }

    public void getState() {
        return state;
    }

    public void idle() {
        getState().idle(this);
    }

    public void acceptingTender() {
        getState().acceptingTender(this);
    }

    public void productSelection() {
        getState().productSelection(this);
    }

    public void dispensing() {
        getState().dispensing(this);
    }
}