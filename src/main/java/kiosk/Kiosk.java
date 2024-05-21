package kiosk;

import kiosk.controller.MenuListMaker;
import kiosk.controller.OrderManager;
import kiosk.model.*;
import kiosk.constant.constants;

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
            System.out.println(" _____    _    _____ _____  __  __ ____ ____");
            System.out.println("/ ___|   / \\  |  ___| ____| | |/ / ___/ ___|");
            System.out.println("| |     / _ \\ | |_  |  _|   | ' / |   \\___ \\ ");
            System.out.println("| |___ / ___ \\|  _| | |___  | . \\ |___ ___) |");
            System.out.println("\\____/_/   \\_\\_|    |_____| |_|\\_\\____|____/ ");
            System.out.println();
            System.out.println("안녕하세요 카페 KCS 입니다.");

            String userInput = getOrderOrCheck();
            if(userInput.equals(constants.INPUT_ONE.getMsg())) {
                getOrder();
            } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
                checkOrder();
            }

            if(askQuit()) {
                System.out.println();
                return;
            }
        }
    }

    String getOrderOrCheck() {
        System.out.println();
        System.out.println("무엇을 도와 드릴까요?");
        System.out.println("1. 주문하기");
        System.out.println("2. 주문확인");

        String userInput = sc.nextLine();

        if(userInput.equals(constants.INPUT_ONE.getMsg())
                || userInput.equals(constants.INPUT_TWO.getMsg())) {
            return userInput;
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
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
            System.out.println("3. 종료 / 처음으로");

            String userInput = sc.nextLine();
            if(userInput.equals(constants.INPUT_ONE.getMsg())) {
                getDrinkOrder();
            } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
                getFoodOrder();
            } else if(userInput.equals(constants.INPUT_THREE.getMsg())) {
                break;
            } else {
                System.out.println(constants.WRONG_INPUT_MSG);
            }
        }
    }

    void getDrinkOrder() {
        System.out.println();
        System.out.println(constants.DRINK.getMsg() + " 메뉴 입니다.");
        System.out.println("1. " + constants.COFFEE.getMsg());
        System.out.println("2. " + constants.TEA.getMsg());
        System.out.println("3. " + constants.JUICE.getMsg());

        String userInput = sc.nextLine();
        if(userInput.equals(constants.INPUT_ONE.getMsg())) {
            getCoffeeOrder();
        } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
            getTeaOrder();
        } else if(userInput.equals(constants.INPUT_THREE.getMsg())) {
            getJuiceOrder();
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
    }

    void printMenu(String select) {
        System.out.println();
        System.out.println("---------------");
        System.out.println();
        System.out.println(select + " 메뉴 입니다.");
        System.out.println("<" + select + " 메뉴>");
    }

    void printHowInput() {
        System.out.println();
        System.out.println("원하시는 메뉴의 번호와 개수를 입력해주세요.");
        System.out.println("* 메뉴 번호와 개수 사이에 공백을 넣어주시기 바랍니다.");
        System.out.println("예) 1 1");
    }

    void getCoffeeOrder() {
        printMenu(constants.COFFEE.getMsg());
        menuListMaker.printCoffeeMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Coffee(menuNumber, menuAmount));
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
        askMoreMenu();
    }

    void getTeaOrder() {
        printMenu(constants.TEA.getMsg());
        menuListMaker.printTeaMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Tea(menuNumber, menuAmount));
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
        askMoreMenu();
    }

    void getJuiceOrder() {
        printMenu(constants.JUICE.getMsg());
        menuListMaker.printJuiceMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Juice(menuNumber, menuAmount));
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
        askMoreMenu();
    }

    void getFoodOrder() {
        System.out.println();
        System.out.println(constants.FOOD.getMsg() + " 메뉴 입니다.");
        System.out.println("1. " + constants.CAKE.getMsg());
        System.out.println("2. " + constants.BREAD.getMsg());

        String userInput = sc.nextLine();
        if(userInput.equals(constants.INPUT_ONE.getMsg())) {
            getCakeOrder();
        } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
            getBreadOrder();
        } else {
            System.out.println(constants.WRONG_INPUT_MSG.getMsg());
        }
    }

    void getCakeOrder() {
        printMenu(constants.CAKE.getMsg());
        menuListMaker.printCakeMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Cake(menuNumber, menuAmount));
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
        askMoreMenu();
    }

    void getBreadOrder() {
        printMenu(constants.BREAD.getMsg());
        menuListMaker.printBreadMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Bread(menuNumber, menuAmount));
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
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

    void checkOrder() {
        System.out.println();
        System.out.println("주문 확인을 위한 주문 번호를 입력해주세요.");
        int userInput = sc.nextInt();
        sc.nextLine();

        Order order = orderManager.checkOrderByNumber(userInput);
        if(order != null) {
            if(order.getIsGetReady()) {
                System.out.println("모든 메뉴가 준비되었습니다. 픽업해주세요.");
            } else {
                System.out.println("메뉴가 아직 준비중입니다. 잠시만 기다려주세요.");
            }
        } else {
            System.out.println(constants.WRONG_INPUT_MSG);
        }
    }

    void askMoreMenu() {
        System.out.println();
        System.out.println("추가 주문을 하시겠습니까?");
        System.out.println("1. 추가");
        System.out.println("2. 결제");

        String userInput = sc.nextLine();
        if(userInput.equals(constants.INPUT_ONE.getMsg())) {
            getOrder();
        } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
            getCharge();
        }
    }

    void getCharge() {
        orderManager.charge();
        Order order = orderManager.getOrder();

        System.out.println();
        System.out.println("<주문 목록>");
        int price = 0;
        for(Menu menu : order.getMenuList()) {
            System.out.println(menu.getMenuName() + " " + menu.getAmount() + "개");
            price += menu.getPrice() * menu.getAmount();
        }
        System.out.println("총 결제 금액은 " + price + "원 입니다.");
        System.out.println();

        System.out.println("결제가 완료되었습니다.");
        System.out.println("주문번호는 " + orderManager.getOrder().getOrderNumber() + " 입니다.");
        System.out.println("주문번호로 부르면 픽업대로 와주세요.");
    }

    boolean askQuit() {
        System.out.println();
        System.out.println("키오스크 사용을 그만할까요?");
        System.out.println("종료를 원하시면 1, 계속 사용하고 싶으면 2 를 입력해주세요.");

        String userInput = sc.nextLine();
        if(userInput.equals(constants.INPUT_ONE.getMsg())) {
            System.out.println("사용해주셔서 감사합니다. 다음에 또 방문해주세요.");
            return true;
        } else if(userInput.equals(constants.INPUT_TWO.getMsg())) {
            System.out.println();
            return false;
        }
        return false;
    }
}
