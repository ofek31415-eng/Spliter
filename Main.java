public class Main {
    public static void main(String[] args) {
        Person[] group = new Person[3];

        group[0] = new Person("Ori");
        group[1] = new Person("Asif");
        group[2] = new Person("Ofek");

        ExpenseManager bulgaria = new ExpenseManager(group);
        printStatus(bulgaria);
        bulgaria.addAmount("Ori", 90);
        printStatus(bulgaria);
    }

    public static void printStatus(ExpenseManager group) {
        for (int i = 0; i < group.getArray().length; i++) {
            System.out.println(group.getArray()[i]);
        }
    }
}
