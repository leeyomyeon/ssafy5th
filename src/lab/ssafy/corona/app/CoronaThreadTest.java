package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadTest {

    public static void main(String[] args) {
//        System.out.println("before Thread.sleep()");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("after Thread.sleep()");


//        for( int t=0; t<1000; t++ ) {
//
//            CoronaThread thread = new CoronaThread(t);
//            thread.start();
        //}
        System.out.println("Main Thread Start!!");

        CoronaThread thread = new CoronaThread(2020);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread End!!");
    }
}
