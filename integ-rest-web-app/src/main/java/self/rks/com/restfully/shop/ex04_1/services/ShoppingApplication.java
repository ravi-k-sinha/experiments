package self.rks.com.restfully.shop.ex04_1.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ShoppingApplication extends Application
{
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> empty = new HashSet<>();

    public ShoppingApplication()
    {
        singletons.add(new CustomerResource());
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return empty;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}