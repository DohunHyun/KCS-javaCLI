package kiosk.util;

public class TimeChecker {
    EntireTimeChecker entireTimeChecker;
    NoInputTimeChecker noInputTimeChecker;

    public TimeChecker() {
        // 전체 이용 제한 시간
        entireTimeChecker = EntireTimeChecker.getInstance();
        // 미입력 유지 시간
        noInputTimeChecker = NoInputTimeChecker.getInstance();
    }

    public void timerStart() {
        entireTimeChecker.start();
        noInputTimeChecker.start();
    }
}
