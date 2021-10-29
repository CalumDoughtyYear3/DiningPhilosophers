//Exercise 7.13
public class CounterApp implements Runnable {

    private String thread;
    private ThreadGroup threadGroup;
    private Counter counter = new Counter(0);

    public CounterApp(String thread, ThreadGroup threadGroup){
        this.thread = thread;
        this.threadGroup = threadGroup;
    }

    private void doAction(int action) throws InterruptedException{
        if (action == 1){
            counter.increment();
            System.out.println(Thread.currentThread().getName() + " increment");
        }else{
            counter.decrement();
            System.out.println(Thread.currentThread().getName() + " decrement");
        }
        Thread.sleep(((int) (Math.random() * 100)));
    }


    @Override
    public void run() {
        try{
            while(true) {
                System.out.println("Thinking");
                synchronized (thread) {
                    doAction(1);
                    synchronized (thread) {
                        doAction(2);
                    }
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }

}
