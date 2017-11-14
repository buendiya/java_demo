package snippet.MultipleThreading;

/**
 * Created by jingsz on 9/17/17.
 */
public class SleepThread {
}

class TestSleepMethod1 extends Thread{
    public void run(){
        for(int i=1;i<10;i++){
            try{Thread.sleep(100);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestSleepMethod1 t1=new TestSleepMethod1();
        TestSleepMethod1 t2=new TestSleepMethod1();

        t1.start();
        t2.start();
    }
}

