package us.abstracta.jmeter.javadsl.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

import java.io.IOException;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

class PerformanceTest {

  @Test
  void testPerformance() throws IOException {
    TestPlanStats stats = testPlan(
        threadGroup(5, 3,
            httpSampler("https://myservice")))
        .run();
    assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
  }

}