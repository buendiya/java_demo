package snippet;


import java.util.ArrayList;
import java.util.List;

public class TestShutdownHook {
    public static void main(final String[] args) throws InterruptedException
    {
        List l = new ArrayList();
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran!");
            }
        });

        while (true)
        {
            System.out.println("hi");
            Thread.sleep(1000);
        }
    }
}
