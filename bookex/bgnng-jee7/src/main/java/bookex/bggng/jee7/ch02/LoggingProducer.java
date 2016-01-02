package bookex.bggng.jee7.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggingProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Logger logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        return logger;
    }
}
