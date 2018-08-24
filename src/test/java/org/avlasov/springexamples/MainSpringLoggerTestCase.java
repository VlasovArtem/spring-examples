package org.avlasov.springexamples;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@PowerMockIgnore({"javax.management.*"})
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public abstract class MainSpringLoggerTestCase {

    private final static Logger MAIN_LOGGER = (Logger) LogManager.getLogger(MainSpringLoggerTestCase.class);
    @Mock
    private Appender mockAppender;
    @Captor
    private ArgumentCaptor<LogEvent> captorLoggingEvent;
    private Logger logger;

    protected abstract Class getLoggerClass();

    @Before
    public void setUpLoggerTest() throws Exception {
        when(mockAppender.getName()).thenReturn("MockAppender");
        when(mockAppender.isStarted()).thenReturn(true);
        when(mockAppender.isStopped()).thenReturn(false);
        logger = (Logger) LogManager.getLogger(Objects.requireNonNull(getLoggerClass()));
        logger.addAppender(mockAppender);
        logger.setLevel(Level.ALL);
    }

    @After
    public void tearDownLoggerTest() {
        logger.removeAppender(mockAppender);
    }

    protected List<LogEvent> getLogEvent(int wantedNumberOfInvocations) {
        if (captorLoggingEvent.getAllValues().isEmpty())
            verify(mockAppender, times(wantedNumberOfInvocations)).append(captorLoggingEvent.capture());
        return captorLoggingEvent.getAllValues();
    }

    protected void validateSingleErrorLogData(String message) {
        validateSingleLogData(Level.ERROR, message);
    }

    protected void validateSingleWarnLogData(String message) {
        validateSingleLogData(Level.WARN, message);
    }

    protected void validateSingleInfoLogData(String message) {
        validateSingleLogData(Level.INFO, message);
    }

    protected void validateSingleLogData(Level level, String message) {
        validateLogData(Collections.singletonList(new LogData(level, message)));
    }

    protected void validateLogData(LogData matcherLogData, LogData... matchersLogData) {
        ArrayList<LogData> logData = new ArrayList<>();
        logData.add(matcherLogData);
        logData.addAll(new ArrayList<>(Arrays.asList(matchersLogData)));
        validateLogData(logData);
    }

    protected void validateEmptyLogData() {
        validateLogData(Collections.emptyList());
    }

    protected void validateLogData(List<LogData> matchersLogData) {
        List<LogEvent> logEvents = getLogEvent(matchersLogData.size());
        assertThat(logEvents, Matchers.hasSize(matchersLogData.size()));
        for (LogEvent logEvent : logEvents) {
            MAIN_LOGGER.log(logEvent.getLevel(), logEvent.getMarker(), logEvent.getMessage());
            LogData result = mapLogEvent(logEvent);
            assertTrue(matchersLogData.stream()
                    .anyMatch(matcher -> matchLogData(matcher, result)));
        }
    }

    protected LogData getInfoLogData(String message) {
        return new LogData(Level.INFO, message);
    }

    private boolean matchLogData(LogData matcher, LogData result) {
        return matcher.level.equals(result.level) && result.message.matches(matcher.message);
    }

    private LogData mapLogEvent(LogEvent logEvent) {
        return new LogData(logEvent.getLevel(), logEvent.getMessage().getFormattedMessage());
    }

    public static class LogData {
        private Level level;
        private String message;

        public LogData(Level level, String message) {
            this.level = Objects.requireNonNull(level);
            this.message = Objects.requireNonNull(message);
        }
    }



}
