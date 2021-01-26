package feature.java;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.junit.jupiter.api.Test;

public class HystrixTest {

    @Test
    void testCircuitBreaker() throws InterruptedException {
        HystrixCommand.Setter commandConfig = createHystrixCommandConfig();

        execute(() -> Thread.sleep(1000), commandConfig);
        execute(() -> Thread.sleep(1000), commandConfig);
        execute(() -> Thread.sleep(5000), commandConfig);
        execute(() -> Thread.sleep(5000), commandConfig);
        execute(() -> Thread.sleep(5000), commandConfig);
        execute(() -> Thread.sleep(1000), commandConfig);
        execute(() -> Thread.sleep(1000), commandConfig);
        execute(() -> Thread.sleep(1000), commandConfig);
        Thread.sleep(5000);
        execute(() -> Thread.sleep(1000), commandConfig);
    }

    private static HystrixCommand.Setter createHystrixCommandConfig() {
        HystrixCommand.Setter res = HystrixCommand
                .Setter
                .withGroupKey(hystrixGroup("TestCircuitBreaker"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withMaxQueueSize(10)
                        .withCoreSize(1)
                        .withQueueSizeRejectionThreshold(5));

        HystrixCommandProperties.Setter commandProps = HystrixCommandProperties.Setter();
        commandProps.withExecutionTimeoutInMilliseconds(1200);
        commandProps.withCircuitBreakerSleepWindowInMilliseconds(3000);
        commandProps.withExecutionIsolationStrategy
                (HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
        commandProps.withCircuitBreakerEnabled(true);
        commandProps.withCircuitBreakerRequestVolumeThreshold(5);
        commandProps.withCircuitBreakerErrorThresholdPercentage(100);

        res.andCommandPropertiesDefaults(commandProps);
        return res;
    }

    private interface Callback {
        void call() throws Exception;
    }

    private static void execute(Callback callback, HystrixCommand.Setter config) {
        try {
            new HystrixCommand<String>(config) {
                @Override
                protected String run() throws Exception {
                    callback.call();
                    System.out.println("Done.");
                    return "done";
                }
            }.execute();
        } catch (Exception e) {
            System.out.println("Fail. " + e.getClass().getName() + ". " + e.getMessage());
        }
    }

    private static HystrixCommandGroupKey hystrixGroup(String key) {
        return HystrixCommandGroupKey.Factory.asKey(key);
    }
}
