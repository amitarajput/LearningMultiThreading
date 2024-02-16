class Process3 extends Thread{ // implement runnable for add p1 into thread
    public void run() {// create run function
        int i;
        for (i = 1; i <= 10; i++) {
            System.out.println("process3 " + i);
        }
    }

}
class Process4 extends Thread {
    public void run() {
        int i;
        for (i = 1; i <= 10; i++) {
            System.out.println("process4 " + i);
        }
    }

}

public class Multi2 {
    public static void main(String[] args) {
        Process3 p3 = new Process3();
        Process4 p4 = new Process4();
        p3.start();
        p4.start();
    }

}
