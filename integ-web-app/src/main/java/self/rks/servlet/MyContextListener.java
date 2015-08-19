package self.rks.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener{

    private static final Logger LOG = LoggerFactory.getLogger(MyContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.trace("A trace log message when context initialized");
        LOG.debug("A debug log message when context initialized");
        LOG.info("A info log message when context initialized");
        LOG.warn("A warn log message when context initialized");
        LOG.error("A error log message when context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.trace("A trace log message when context destroyed");
        LOG.debug("A debug log message when context destroyed");
        LOG.info("A info log message when context destroyed");
        LOG.warn("A warn log message when context destroyed");
        LOG.error("A error log message when context destroyed");
    }
}
