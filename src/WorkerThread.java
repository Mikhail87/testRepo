/**
 * @author mikhail.smirnou.
 */
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println("StartingThread: " + this.command);
        executeTask();
        System.out.println("EndThread: " + this.command);
    }

    private void executeTask(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
