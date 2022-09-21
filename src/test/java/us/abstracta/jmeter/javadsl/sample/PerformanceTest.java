package us.abstracta.jmeter.javadsl.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

public class PerformanceTest {

  @Test
  public void testPerformance() throws IOException {
    TestPlanStats stats = testPlan(
        threadGroup(1, 1,
            httpSampler("https://myservice")
        )
    ).run();
    assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
  }

  public static void main(String[] args) {
    SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();
    LauncherFactory.create()
        .execute(LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectClass(PerformanceTest.class))
                .build(),
            summaryListener);
    TestExecutionSummary summary = summaryListener.getSummary();
    summary.printFailuresTo(new PrintWriter(System.err));
    System.exit(summary.getTotalFailureCount() > 0 ? 1 : 0);
  }

}