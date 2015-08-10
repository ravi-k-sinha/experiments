package self.rks.example1;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RESTEasyJSONApplication extends Application {
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> empty = new HashSet<>();

    public RESTEasyJSONApplication() {
        singletons.add(new RESTEasyJSONServices());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
