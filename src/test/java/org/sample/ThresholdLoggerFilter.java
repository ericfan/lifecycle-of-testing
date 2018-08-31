package org.sample;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.util.Arrays;
import java.util.List;

/**
 * @author Eric Fan
 */
public class ThresholdLoggerFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        List<StackTraceElement> stackTraceElementList = Arrays.asList(event.getCallerData());
        if (stackTraceElementList.stream().anyMatch(stackTrace -> stackTrace.getClassName().matches("(.*)IntegrationTest"))
                || stackTraceElementList.stream().anyMatch(stackTrace -> stackTrace.getClassName().matches("org.springframework.(.*)"))) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
