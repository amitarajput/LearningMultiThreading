import java.util.Scanner;

class Account{
    int balance;

    Account(int b){
        balance = b;
    }
    boolean isSufficientBalance(int withdraw){
        if(balance > withdraw){
            return true;
        }else{
            return false;
        }
    }
    void withdraw1(int amount, String g1){
        balance = balance - amount;
        System.out.println(g1 + " Transaction successful");
        System.out.println(g1 + " Current balance is: " + balance);
    }

}
class Customer implements Runnable{
    String m1;
    Account x1; // object created to store big info int, float main use less data
    Customer(Account j1, String h1){
        x1 = j1; // x1 has first account information
        m1 = h1;
    }
    public  void run(){
        Scanner s1= new Scanner(System.in);
        synchronized (x1) {//sychronized account
            System.out.println("Enter Amount to Withdraw for " + m1 + ":");
            int amt = s1.nextInt();
            if (x1.isSufficientBalance(amt)) {
                x1.withdraw1(amt, m1);

            } else {
                System.out.println("Insufficient Balance");
            }
        }

    }

}

public class ThreadSync {
    public static void main(String[] args) {
        Account a1 = new Account(5000);
        Customer c1 = new Customer(a1, "Amita");
        Customer c2 = new Customer(a1,"Dinesh");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();

    }
}
