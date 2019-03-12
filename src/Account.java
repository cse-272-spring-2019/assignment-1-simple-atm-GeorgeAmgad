import java.util.LinkedList;

public class Account implements ATM {

    private double currentBalance = 0;
    private LinkedList<String> transactions = new LinkedList<>();
    private int index;

    Boolean validate(String inputCardNumber) {
        String cardNumber = "123456";
        return inputCardNumber.equals(cardNumber);
    }

    Account() {
        transactions.add(String.valueOf(currentBalance));
        index = 1;
    }

    @Override
    public String getCurrentBalance() {
        resetIndex();

        return Double.toString(currentBalance);
    }

    @Override
    public boolean withdraw(String amount) {
        resetIndex();

        if (Double.valueOf(amount) > currentBalance) {
            return false;
        } else {
            currentBalance -= Double.valueOf(amount);
            save("- " + amount);
            return true;
        }
    }

    @Override
    public void deposit(String amount) {
        resetIndex();

        currentBalance += Double.valueOf(amount);
        save("+ " + amount);
    }

    @Override
    public String prev() {
        if (index > 0) {
            return String.valueOf(transactions.get(--index));
        } else {
            return transactions.get(0);
        }
    }

    @Override
    public String next() {
        if (index == transactions.size()) {
            return "";
        } else if (index == transactions.size() - 1) {
            return transactions.get(index);
        } else {
            return transactions.get(++index);
        }
    }

    private void save(String x) {
        if (transactions.size() == 5) {
            transactions.removeFirst();
        }
        transactions.add(x);
    }

    private void resetIndex() {
        index = transactions.size();
    }

}
