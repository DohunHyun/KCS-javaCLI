package kiosk;

import java.util.Arrays;
import java.util.Scanner;

public class Kiosk {
    static Scanner sc;
    static OrderManager orderManager;
    static MenuListMaker menuListMaker;

    Kiosk() {
        sc = new Scanner(System.in);
        orderManager = new OrderManager();
        menuListMaker = new MenuListMaker();
    }

    void run() {

        while(true) {
            System.out.println("안녕하세요 카페 땡떙 입니다.");

            int userInput = getOrderOrCheck();
            if(userInput == 1) {
                // 주문
                getOrder();
            } else if(userInput == 2) {
                // 주문 확인
            }

            if(askQuit()) {
                System.out.println();
                return;
            }
        }
    }

    int getOrderOrCheck() {
        System.out.println();
        System.out.println("무엇을 도와 드릴까요?");
        System.out.println("1. 주문하기");
        System.out.println("2. 주문확인");

        int userInput = sc.nextInt();
        sc.nextLine();

        if(userInput == 1 || userInput == 2) {
            return userInput;
        } else {
            System.out.println("잘못된 입력입니다. 1 또는 2 를 입력해주세요.");
            System.out.println();
            return getOrderOrCheck();
        }
    }

    void getOrder() {
        System.out.println();
        System.out.println("주문하실 메뉴를 골라주세요.");
        while(true) {
            System.out.println();
            System.out.println("1. 음료 (커피, 차)");
            System.out.println("2. 음식 (케이크, 빵)");
            System.out.println("3. 종료");
            int userInput = sc.nextInt();
            sc.nextLine();

            if(userInput == 1) {
                getDrinkOrder();
            } else if(userInput == 2) {
//                getFoodOrder();
            } else if(userInput == 3) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    void getDrinkOrder() {
        System.out.println();
        System.out.println("음료 메뉴 입니다.");
        System.out.println("1. 커피");
        System.out.println("2. 차");

        int userInput = sc.nextInt();
        sc.nextLine();

        if(userInput == 1) {
            getCoffeeOrder();
        } else if(userInput == 2) {
//            getTeaOrder();
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    void getCoffeeOrder() {
        System.out.println();
        System.out.println("---------------");
        System.out.println();
        System.out.println("커피 메뉴 입니다.");

        System.out.println("<커피 메뉴>");
        menuListMaker.printCoffeeMenu();
        System.out.println();
        System.out.println("원하시는 메뉴의 번호와 개수를 입력해주세요.");
        System.out.println("* 메뉴 번호와 개수 사이에 공백을 넣어주시기 바랍니다.");
        System.out.println("예) 1 1");

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);


            orderManager.makeOrder(new Coffee(menuNumber, menuAmount));
        } else {
            System.out.println("입력이 잘못됐습니다. 다시 시도해주세요.");
        }

        askMoreMenu();
    }

    boolean validateMenuInput(String input) {
        try {
            int[] inputToIntArray = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if(inputToIntArray.length != 2) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    void askMoreMenu() {
        System.out.println();
        System.out.println("추가 주문을 하시겠습니까?");
        System.out.println("1. 추가");
        System.out.println("2. 결제");
        int userInput = sc.nextInt();
        sc.nextLine();

        if(userInput == 1) {
            getOrder();
        } else {
            getCharge();
        }
    }

    void getCharge() {

    }

    boolean askQuit() {
        System.out.println();
        System.out.println("키오스크 사용을 그만할까요?");
        System.out.println("종료를 원하시면 1, 계속 사용하고 싶으면 2 를 입력해주세요.");
        int userInput = sc.nextInt();

        if(userInput == 1) {
            System.out.println("사용해주셔서 감사합니다. 다음에 또 방문해주세요.");
            return true;
        } else {
            System.out.println();
            return false;
        }

    }
}
