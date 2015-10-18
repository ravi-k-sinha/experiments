package jmodern;

public interface FooBar {
    
    int foo(int x, int y);
    
    default boolean bar(int x) {
        return true;
    }
    
}
