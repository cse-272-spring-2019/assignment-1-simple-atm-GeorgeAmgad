public interface ATM {
    //Returns the current balance in string format
    String getCurrentBalance();

    //withdraws from current balance and updates it
    boolean withdraw(String amount);

    //adds to the current balance and updates it
    void deposit(String amount);

    //returns the prev transaction in String format, or Null if no more history
    String prev();

    //returns the next transaction in String format, or Null if no more history
    String next();
}

