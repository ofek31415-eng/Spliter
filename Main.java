public class Main {
    public static void main(String[] args) {
        Person[] group = new Person[3];

        group[0] = new Person("Ori");
        group[1] = new Person("Asif");
        group[2] = new Person("Ofek");

        // 2. Create the manager for the trip
        ExpenseManager tripManager = new ExpenseManager(group);

        System.out.println("--- Initial Status ---");
        System.out.print(tripManager);

        // 3. Scenario 1: General Expense
        // Ori pays 90 for the whole group (30 each)
        // Ori: +90 (payment) - 30 (share) = +60
        // Asif: -30 (share) = -30
        // Ofek: -30 (share) = -30
        System.out.println("\n--- Ori paid 90 for everyone ---");
        tripManager.addAmount("Ori", 90);
        System.out.print(tripManager);

        // 4. Scenario 2: Specific Participants
        // Ofek pays 40 for a snack shared only with Asif
        // Share is 40 / 2 = 20 each.
        // Ofek: -30 (prev) + 40 (payment) - 20 (share) = -10
        // Asif: -30 (prev) - 20 (share) = -50
        // Ori: +60 (prev, did not participate) = +60
        System.out.println("\n--- Ofek paid 40 for Asif and himself only ---");
        String[] snackParticipants = {"Ofek", "Asif"};
        tripManager.addAmount("Ofek", 40, snackParticipants);
        System.out.print(tripManager);

        // 5. Scenario 3: Payment for someone else
        // Asif pays 15 for Ori's coffee (Asif did not drink)
        // Share is 15 / 1 = 15.
        // Asif: -50 (prev) + 15 (payment) = -35
        // Ori: +60 (prev) - 15 (share) = +45
        System.out.println("\n--- Asif paid 15 for Ori's coffee only ---");
        String[] coffeeParticipant = {"Ori"};
        tripManager.addAmount("Asif", 15, coffeeParticipant);
        System.out.print(tripManager);
        
        // Final verification: Sum of all balances should be 0.0
        // -10 (Ofek) - 35 (Asif) + 45 (Ori) = 0

        tripManager.settleUp();
    }

    public static void printStatus(ExpenseManager group) {
        for (int i = 0; i < group.getArray().length; i++) {
            System.out.println(group.getArray()[i]);
        }
    }
}
