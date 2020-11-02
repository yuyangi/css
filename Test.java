package test;

import com.google.common.util.concurrent.RateLimiter;

/**
 * test
 *
 * @author yuyang48
 * @date 2020/10/29
 */
public class Test {

    public static void main(String[] args) {
        final RateLimiter rateLimiter = RateLimiter.create(2);
        System.out.println("Start:" + System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                rateLimiter.acquire(5);
            } else {
                rateLimiter.acquire(2);
            }
            System.out.println("第" + i + "个:" + System.currentTimeMillis());
        }

    }
}
