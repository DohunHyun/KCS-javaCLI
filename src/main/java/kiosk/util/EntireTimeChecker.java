package kiosk.util;

public class EntireTimeChecker extends Thread {
    private static EntireTimeChecker entireTimeChecker = new EntireTimeChecker();
    private static long startTime;
    private static final long MAX_RUNTIME =  30 * 1000;
    private volatile boolean running = true;

    private EntireTimeChecker() {
        startTime = System.currentTimeMillis();
    }

    public static EntireTimeChecker getInstance() {
        return entireTimeChecker;
    }

    @Override
    public void run() {
        while(running) {
            if(System.currentTimeMillis() - startTime >= MAX_RUNTIME) {
                System.out.println("전체 사용 시간 5분이 초과되어 프로그램을 종료합니다.");
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopTimer() {
        running = false;
    }
}
