public class Dining {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for(int i = 0; i < forks.length; i++){
            forks[i] = new Object();
        }

        for(int i = 0; i < philosophers.length; i++){
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length]; //makes sure we dont go out of the bounds of the forks

            philosophers[i] = new Philosopher(leftFork, rightFork);

            Thread thread = new Thread(philosophers[i], "Philosopher " + (i+1));
            thread.start();
        }
    }
}
