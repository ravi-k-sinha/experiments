package jmodern;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.strands.Strand;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import java.util.concurrent.TimeUnit;

public class Main3 {
    
    public static void main(String[] args) throws Exception {
        
        final Channel<Integer> channel = Channels.newChannel(0);
        
        new Fiber<Void>(
                () -> {
                    for (int i=0; i < 10; i++) {
                        Strand.sleep(100, TimeUnit.MILLISECONDS);
                        channel.send(i);
                    }
                    channel.close();
                }
        ).start();
        
        new Fiber<Void>(
                () -> {
                    Integer x;
                    while ((x = channel.receive()) != null) {
                        System.out.println("--> " + x);
                    }
                }
        ).start().join();
        
    }
    
}
