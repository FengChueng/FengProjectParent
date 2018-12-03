import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2018/11/1.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        int tail = 2;
        int t = 1;
        int p = 1;
        int q = 4;
//        p = (p != t && t != (t = tail)) ? t : q;
        boolean x = p != t && t != (t = tail);
        System.out.println(x);
        System.out.println(t);
        System.out.println(p);

        final CyclicBarrier barrier = new CyclicBarrier(2);

        final ConcurrentLinkedQueue<Integer> integers = new ConcurrentLinkedQueue<Integer>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                integers.offer(0);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                integers.offer(1);
            }
        }).start();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
