package testNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(testNG.TestListener.class)
public class ListenerTC {
    @Test
    public void testcase01(){
        System.out.println("test case 01");
    }
    @Test
    public void testcase02(){
        System.out.println("test case 02");
    }
}
