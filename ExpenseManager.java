public class ExpenseManager {
    private Person[] _group;

    public ExpenseManager(Person[] group) {
        _group = group;
    }

    public Person[] getArray() {
        return _group;
    }

    public void addExpense(String name, double expense) {
        double fixedExpense = - (expense / _group.length);

        Person p = findPersonByName(_group, name);
        p.changeBalance(expense);
        for (int i = 0; i < _group.length; i++) {
            _group[i].changeBalance(fixedExpense);
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
