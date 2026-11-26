public abstract class SnackDispenserHandler {
    private SnackDispenserHandler next;

    public SnackDispenserHandler(SnackDispenserHandler next) {
        this.next = next;
    }

    public void handleRequest(String snackName, Snack snack, double moneyInserted) {
        if(next != null) {
            next.handleRequest(snackName, snack, moneyInserted);
        }
    }
}