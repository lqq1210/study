package netty.ch2.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangdecheng on 22/03/2018.
 */
public class TimeServerHandlerExcuterPool {

    private int maxPoolSize;
    private int queueSize;
    private ExecutorService executorService;

    public TimeServerHandlerExcuterPool(int maxPoolSize, int queueSize) {
        this.maxPoolSize = maxPoolSize;
        this.queueSize = queueSize;
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void executeTask(Runnable task){
        executorService.execute(task);
    }

}
