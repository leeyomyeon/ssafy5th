package lab.ssafy.corona.virus;

public class CoronaThread extends Thread {
    int num;

    public CoronaThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(num);
    }
}
