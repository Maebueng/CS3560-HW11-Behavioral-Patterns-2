public class SnackHandler extends SnackDispenserHandler {
    private String targetSnackName;

    public SnackHandler(SnackDispenserHandler next, String targetSnackName) {
        super(next);
        this.targetSnackName = targetSnackName;
    }

    @Override
    public void handleRequest(String requestType, Snack snack, double moneyInserted) {
        if (targetSnackName.equalsIgnoreCase(requestType)) {
            if (snack != null && snack.getQuantity() > 0) {
                if (moneyInserted >= snack.getPrice()) {
                    System.out.println("Dispensing " + snack.getName());
                    snack.reduceQuantity();
                    double change = moneyInserted - snack.getPrice();
                    if (change > 0) {
                        System.out.println("Change: $" + change);
                    }
                } else {
                    System.out.println("Insufficient funds for " + snack.getName());
                }
            } else {
                System.out.println("Sorry, " + targetSnackName + " is out of stock");
            }
        } else {
            super.handleRequest(requestType, snack, moneyInserted);
        }
    }




}
