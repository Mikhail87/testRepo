import java.util.LinkedList;
import java.util.List;

/**
 * @author mikhail.smirnou.
 */
public class MyBlockingQueue {

    private int capacity = 5;

    List<String> queueList = new LinkedList<String>();

    public MyBlockingQueue(){
    }

    public synchronized String readMsg() throws InterruptedException {

        while(queueList.isEmpty()){
            wait();
        }

        if (queueList.size() >= capacity){
            notifyAll();
        }

        return queueList.remove(0);
    }

    public synchronized void putMsg(String msg) throws InterruptedException {
        while(queueList.size() >= capacity){
            wait();
        }

        if (queueList.isEmpty()){
            notifyAll();
        }

        System.out.println(msg);
        queueList.add(msg);
    }

}
