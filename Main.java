public class Main {
    public static void main(String[] args) {
        // 1. Initialize a group of 5 friends
        Person[] group = new Person[5];
        group[0] = new Person("Ori");
        group[1] = new Person("Asif");
        group[2] = new Person("Ofek");
        group[3] = new Person("Alon");
        group[4] = new Person("Noam");

        ExpenseManager tripManager = new ExpenseManager(group);

        System.out.println("--- Starting Complex Settlement Test ---");
        
        // 2. Expense 1: Ori pays 250 for the whole group (Dinner)
        // Everyone owes 50. Ori should be +200.
        System.out.println("Action: Ori paid 250 for everyone (Dinner)");
        tripManager.addAmount("Ori", 250);

        // 3. Expense 2: Alon pays 120 for (Alon, Noam, Ofek)
        // Each of the three owes 40. Alon should get +80 back.
        System.out.println("Action: Alon paid 120 for (Alon, Noam, Ofek) (Drinks)");
        tripManager.addAmount("Alon", 120, new String[]{"Alon", "Noam", "Ofek"});

        // 4. Expense 3: Noam pays 60 for (Noam, Asif, Ori)
        // Each owes 20. Noam should get +40 back.
        System.out.println("Action: Noam paid 60 for (Noam, Asif, Ori) (Taxi)");
        tripManager.addAmount("Noam", 60, new String[]{"Noam", "Asif", "Ori"});

        // 5. Expense 4: Ofek pays 100 only for Alon
        // Ofek is +100, Alon is -100.
        System.out.println("Action: Ofek paid 100 for Alon (Event Ticket)");
        tripManager.addAmount("Ofek", 100, new String[]{"Alon"});

        // 6. Expense 5: Asif pays 15 for (Asif, Noam)
        // Each owes 7.5. Asif is +7.5.
        System.out.println("Action: Asif paid 15 for (Asif, Noam) (Ice Cream)");
        tripManager.addAmount("Asif", 15, new String[]{"Asif", "Noam"});

        // Print status before settling
        System.out.println("\n--- Final Balances Before Settlement ---");
        System.out.print(tripManager);

        // 7. Run the algorithm
        // This should show the minimum number of transfers to reach balance 0
        tripManager.settleUp();
    }

    public static void printStatus(ExpenseManager group) {
        for (int i = 0; i < group.getArray().length; i++) {
            System.out.println(group.getArray()[i]);
        }
    }
}
