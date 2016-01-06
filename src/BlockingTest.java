/**
 * @author mikhail.smirnou.
 */
public class BlockingTest {

    public static void main(String []args){

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();

        new ThreadWriter(myBlockingQueue, "1", 400).start();
        new ThreadWriter(myBlockingQueue, "2", 400).start();
        new ThreadReader(myBlockingQueue, "1", 500).start();

    }

}


