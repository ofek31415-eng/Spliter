public class Person {
    private String _name;
    private double _balance;

    public Person(String name) {
        _name = name;
        _balance = 0;
    }

    public Person(String name, double balance) {
        _name = name;
        _balance = balance;
    }

    public String getName() {
        return _name;
    }

    public double getBalance() {
        return _balance;
    }

    public void changeBalance(double change) {
        _balance += change;
    }

    public String toString() {
        return _name + ", Balance = " + _balance;
    }
}