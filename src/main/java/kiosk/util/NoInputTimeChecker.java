package kiosk.util;

public class NoInputTimeChecker extends Thread{
    long lastInputTime;
    private static final long NO_INPUT_TIME_OUT = 60 * 1000;
    private static NoInputTimeChecker noInputTimeChecker = new NoInputTimeChecker();
    private static final Object lock = new Object();

    private NoInputTimeChecker() {

    }

    public static NoInputTimeChecker getInstance() {
        if(noInputTimeChecker == null) {
            synchronized (lock) {
                if(noInputTimeChecker == null) {
                    noInputTimeChecker = new NoInputTimeChecker();
                }
            }
        }
        return noInputTimeChecker;
    }

    @Override
    public void run() {
        System.out.println("쓰레드 실행! ");
        while (true) {
            if(System.currentTimeMillis() - lastInputTime >= NO_INPUT_TIME_OUT) {
                System.out.println("1분 동안 입력이 없어 프로그램을 종료합니다.");
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void resetTimer() {
        lastInputTime = System.currentTimeMillis();
    }
}
