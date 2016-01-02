package bookex.bggng.jee7.ch02;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.debug("Entering::" + ic.getTarget().getClass().getName() + "." + ic.getMethod().getName());
//        System.out.println("Called for " + ic.getTarget().getClass().getName() + "::" + ic.getMethod().getName());
        try {
            return ic.proceed();
        }
        finally {
            logger.debug("Exiting::" + ic.getTarget().getClass().getName() + "." + ic.getMethod().getName());
        }
    }
}
