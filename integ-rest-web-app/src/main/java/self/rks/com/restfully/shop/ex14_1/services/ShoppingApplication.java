package self.rks.com.restfully.shop.ex14_1.services;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rapi/ex14_1")
public class ShoppingApplication extends Application
{
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    public ShoppingApplication() {
        //classes.add(CustomerResourceBean.class);
        //classes.add(OrderResourceBean.class);
        //classes.add(ProductResourceBean.class);
        //classes.add(StoreResourceBean.class);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return classes;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}
