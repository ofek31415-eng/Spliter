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
        //     _group[i].changeBalance(fixedamount);
        // }
    }

    /**
     * Divides an amount between specific participants
     * @param name
     * @param amount
     * @param participants
     */
    public void addAmount(String name, double amount, String[] participants) {
        double fixedamount = - (amount / participants.length);

        for (int i = 0; i < participants.length; i++) {
            if (findPersonByName(_group, participants[i]) != null) {
                _group[i].changeBalance(fixedamount);
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
        return _group.toString();
    }
}
