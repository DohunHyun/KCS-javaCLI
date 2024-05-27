package kiosk.util;

import java.util.Scanner;

public class InputManager {
    Scanner sc;
    NoInputTimeChecker noInputTimeChecker = NoInputTimeChecker.getInstance();

    public InputManager() {
        sc = new Scanner(System.in);
    }

    public String getInput() {
        noInputTimeChecker.resetTimer();
        return sc.nextLine();
    }

    public int getInputInteger() {
        noInputTimeChecker.resetTimer();
        return Integer.parseInt(sc.nextLine());
    }

}
