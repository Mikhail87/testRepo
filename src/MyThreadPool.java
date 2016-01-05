import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mikhail.smirnou.
 */
public class MyThreadPool implements Executor {

    private Queue<Runnable> jobQueue = new LinkedList();

    private int poolSize = 2;

    public void start(){
        for (int i = 0; i < poolSize; i++){
            new PooledThread().start();
        }
    }

    @Override
    public void execute(Runnable command) {

    }
}
