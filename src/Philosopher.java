import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }


    @Override
    public void run() {
        try{
            while(true) {
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + ": Picked up Left fork");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + ": Picked up Right fork - Eating");
                        doAction(System.nanoTime() + ": Put down Right fork");
                    }
                    doAction(System.nanoTime() + ": Put down Left fork. Back to thinking");
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }
}
