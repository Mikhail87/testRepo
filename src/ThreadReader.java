/**
 * @author mikhail.smirnou.
 */
public class ThreadReader extends Thread {

    private MyBlockingQueue myBlockingQueue;
    private String name;
    private int timeInterval;

    public ThreadReader(MyBlockingQueue myBlockingQueue, String name, int timeInterval){
        this.myBlockingQueue = myBlockingQueue;
        this.name = name;
        this.timeInterval = timeInterval;
    }

    public void run() {
        for (int i = 0; i < 30; i++){
            try{
                System.out.println("reader " + name + " reads: " + myBlockingQueue.readMsg());
                Thread.sleep(600);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
