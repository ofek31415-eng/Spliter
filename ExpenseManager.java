public class ExpenseManager {
    private Person[] _group;

    public ExpenseManager(Person[] group) {
        _group = group;
    }

    public Person[] getArray() {
        return _group;
    }

    /**
     * Divides an amount between everyone in the group
     * 
     * @param name
     * @param amount
     */
    public void addAmount(String name, double amount) {
        String[] allNames = new String[_group.length];
        for (int i = 0; i < _group.length; i++) {
            allNames[i] = _group[i].getName();
        }
        addAmount(name, amount, allNames);
        // double fixedamount = - (amount / _group.length);

        // Person p = findPersonByName(_group, name);
        // p.changeBalance(amount);
        // for (int i = 0; i < _group.length; i++) {
        // _group[i].changeBalance(fixedamount);
        // }
    }

    /**
     * Divides an amount between specific participants
     * 
     * @param name
     * @param amount
     * @param participants
     */
    public void addAmount(String name, double amount, String[] participants) {
        double fixedamount = -(amount / participants.length);

        findPersonByName(_group, name).changeBalance(amount);

        for (int i = 0; i < participants.length; i++) {
            Person p = findPersonByName(_group, participants[i]);
            if (p != null) {
                p.changeBalance(fixedamount);
            }
        }
    }

    private static Person findPersonByName(Person[] group, String nameToFind) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && group[i].getName().equals(nameToFind)) {
                return group[i];
            }
        }
        return null;
    }

    public String toString() {
        String expenseSummary = "";
        for (int i = 0; i < _group.length; i++) {
            expenseSummary += _group[i].toString() + "\n";
        }
        return expenseSummary;
    }

    /**
     * Calculates and prints the most efficient way to settle all debts.
     * This method uses a greedy approach to minimize the number of transactions.
     */
    public void settleUp() {
        // Create a temporary copy of balances to work with
        double[] balances = new double[_group.length];
        for (int i = 0; i < _group.length; i++) {
            balances[i] = _group[i].getBalance();
        }

        System.out.println("\n--- Recommended Settlements ---");

        while (true) {
            int maxDebtorIdx = 0;
            int maxCreditorIdx = 0;

            // Find the person with the largest debt (most negative)
            // and the person with the largest credit (most positive)
            for (int i = 1; i < balances.length; i++) {
                if (balances[i] < balances[maxDebtorIdx]) {
                    maxDebtorIdx = i;
                }
                if (balances[i] > balances[maxCreditorIdx]) {
                    maxCreditorIdx = i;
                }
            }

            // If the largest debt and credit are near zero, we are done
            // (Using 0.01 to account for floating point precision issues)
            if (Math.abs(balances[maxDebtorIdx]) < 0.01 && Math.abs(balances[maxCreditorIdx]) < 0.01) {
                break;
            }

            // The amount to transfer is the minimum of (debt, credit)
            double amountToPay = Math.min(Math.abs(balances[maxDebtorIdx]), balances[maxCreditorIdx]);

            // Round to 2 decimal places
            amountToPay = Math.round(amountToPay * 100.0) / 100.0;

            if (amountToPay > 0) {
                System.out.println(_group[maxDebtorIdx].getName() + " needs to pay " +
                        amountToPay + " to " + _group[maxCreditorIdx].getName());
            }

            // Update the temporary balances
            balances[maxDebtorIdx] += amountToPay;
            balances[maxCreditorIdx] -= amountToPay;
        }
        System.out.println("All accounts are now balanced.\n");
    }
}
