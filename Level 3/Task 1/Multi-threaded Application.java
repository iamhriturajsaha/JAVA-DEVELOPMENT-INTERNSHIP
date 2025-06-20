import java.util.concurrent.locks.ReentrantLock;

class Wallet {
    private int balance = 200;
    private final ReentrantLock lock = new ReentrantLock();

    // Using synchronized method
    public synchronized void withdrawSynchronized(String user, int amount) {
        System.out.println(user + " [sync] is trying to withdraw $" + amount);
        if (balance >= amount) {
            simulateDelay();
            balance -= amount;
            System.out.println(user + " [sync] completed withdrawal. Balance: $" + balance);
        } else {
            System.out.println(user + " [sync] failed to withdraw. Insufficient funds!");
        }
    }

    // Using ReentrantLock
    public void withdrawWithLock(String user, int amount) {
        System.out.println(user + " [lock] is trying to withdraw $" + amount);
        lock.lock();
        try {
            if (balance >= amount) {
                simulateDelay();
                balance -= amount;
                System.out.println(user + " [lock] completed withdrawal. Balance: $" + balance);
            } else {
                System.out.println(user + " [lock] failed to withdraw. Insufficient funds!");
            }
        } finally {
            lock.unlock();
        }
    }

    private void simulateDelay() {
        try {
            Thread.sleep(100); // simulate processing delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBalance() {
        return balance;
    }
}

class SyncWithdrawTask implements Runnable {
    private final Wallet wallet;
    private final String user;
    private final int amount;

    public SyncWithdrawTask(Wallet wallet, String user, int amount) {
        this.wallet = wallet;
        this.user = user;
        this.amount = amount;
    }

    public void run() {
        wallet.withdrawSynchronized(user, amount);
    }
}

class LockWithdrawTask implements Runnable {
    private final Wallet wallet;
    private final String user;
    private final int amount;

    public LockWithdrawTask(Wallet wallet, String user, int amount) {
        this.wallet = wallet;
        this.user = user;
        this.amount = amount;
    }

    public void run() {
        wallet.withdrawWithLock(user, amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Wallet sharedWallet = new Wallet();

        // Create threads using both synchronization and locks
        Thread t1 = new Thread(new SyncWithdrawTask(sharedWallet, "Alice", 70));
        Thread t2 = new Thread(new SyncWithdrawTask(sharedWallet, "Bob", 90));
        Thread t3 = new Thread(new LockWithdrawTask(sharedWallet, "Charlie", 80));
        Thread t4 = new Thread(new LockWithdrawTask(sharedWallet, "Dave", 50));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}