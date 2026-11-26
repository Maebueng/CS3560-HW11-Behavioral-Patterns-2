import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        SnackDispenserHandler snickersHandler = new SnackHandler(null, "Snickers");
        SnackDispenserHandler kitKatHandler = new SnackHandler(snickersHandler, "KitKat");
        SnackDispenserHandler doritosHandler = new SnackHandler(kitKatHandler, "Doritos");
        SnackDispenserHandler cheetosHandler = new SnackHandler(doritosHandler, "Cheetos");
        SnackDispenserHandler pepsiHandler = new SnackHandler(cheetosHandler, "Pepsi");
        SnackDispenserHandler cokeHandler = new SnackHandler(pepsiHandler, "Coke");

        // Initialize Vending Machine with the start of the chain
        VendingMachine machine = new VendingMachine(cokeHandler);

        machine.addSnack(new Snack("Coke", 1.50, 5));
        machine.addSnack(new Snack("Pepsi", 1.50, 5));
        machine.addSnack(new Snack("Cheetos", 1.25, 3));
        machine.addSnack(new Snack("Doritos", 1.25, 3));
        machine.addSnack(new Snack("KitKat", 1.00, 2));
        machine.addSnack(new Snack("Snickers", 1.00, 1));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Vending Machine");

        while (running) {
            System.out.println("Please make a selection (Coke, Pepsi, Cheetos, Doritos, KitKat, or Snickers)");
            String chosenSnack = scanner.nextLine();

            if (chosenSnack.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }

            System.out.println("Enter amount you'd like to insert ($): ");
            double insertedAmount = scanner.nextDouble();
            scanner.nextLine();

            machine.selectSnack(chosenSnack);
            machine.insertMoney(insertedAmount);
        }

        scanner.close();
    }
}