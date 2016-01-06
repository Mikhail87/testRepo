/**
 * @author mikhail.smirnou.
 */
public class ThreadWriter extends Thread {

    private MyBlockingQueue myBlockingQueue;
    private String name;
    private int timeInterval;

    public ThreadWriter(MyBlockingQueue myBlockingQueue, String name, int timeInterval){
        this.myBlockingQueue = myBlockingQueue;
        this.name = name;
        this.timeInterval = timeInterval;
    }

    public void run() {
        for (int i = 0; i < 10; i++){
            try{
                myBlockingQueue.putMsg("writer_" + name);
                Thread.sleep(timeInterval);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
