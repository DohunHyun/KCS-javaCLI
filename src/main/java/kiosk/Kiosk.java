package kiosk;

import kiosk.controller.MenuListMaker;
import kiosk.controller.OrderManager;
import kiosk.model.*;
import kiosk.constant.Constants;

import java.util.Arrays;
import java.util.Scanner;

public class Kiosk {
    static Scanner sc;
    static OrderManager orderManager;
    static MenuListMaker menuListMaker;

    Kiosk() {
        sc = new Scanner(System.in);
        orderManager = new OrderManager();
        menuListMaker = MenuListMaker.getMenuListMaker();
    }

    // 키오스크 프로그램 실행
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
            if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
                getOrder();
            } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
                checkOrder();
            }

            if(askQuit()) {
                System.out.println();
                return;
            }
        }
    }

    // 주문하기, 확인하기
    String getOrderOrCheck() {
        System.out.println();
        System.out.println("무엇을 도와 드릴까요?");
        System.out.println("1. 주문하기");
        System.out.println("2. 주문확인");

        String userInput = sc.nextLine();

        if(userInput.equals(Constants.INPUT_ONE.getMsg())
                || userInput.equals(Constants.INPUT_TWO.getMsg())) {
            return userInput;
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG);
            System.out.println();
            return getOrderOrCheck();
        }
    }

    // 주문하기
    void getOrder() {
        System.out.println();
        System.out.println("주문하실 메뉴를 골라주세요.");
        System.out.println();
        System.out.println("1. 음료 (커피, 차, 주스, 에이드)");
        System.out.println("2. 음식 (케이크, 빵)");
        System.out.println("3. 종료 / 처음으로");

        String userInput = sc.nextLine();
        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            getDrinkOrder();
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            getFoodOrder();
        } else if(userInput.equals(Constants.INPUT_THREE.getMsg())) {

        } else {
            System.out.println(Constants.WRONG_INPUT_MSG);
        }

    }

    void getDrinkOrder() {
        System.out.println();
        System.out.println(Constants.DRINK.getMsg() + " 메뉴 입니다.");
        System.out.println("1. " + Constants.COFFEE.getMsg());
        System.out.println("2. " + Constants.TEA.getMsg());
        System.out.println("3. " + Constants.JUICE.getMsg());
        System.out.println("4. " + Constants.ADE.getMsg());

        String userInput = sc.nextLine();
        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            getCoffeeOrder();
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            getTeaOrder();
        } else if(userInput.equals(Constants.INPUT_THREE.getMsg())) {
            getJuiceOrder();
        } else if(userInput.equals(Constants.INPUT_FOUR.getMsg())) {
            getAdeOrder();
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG);
        }
    }

    void getFoodOrder() {
        System.out.println();
        System.out.println(Constants.FOOD.getMsg() + " 메뉴 입니다.");
        System.out.println("1. " + Constants.CAKE.getMsg());
        System.out.println("2. " + Constants.BREAD.getMsg());

        String userInput = sc.nextLine();
        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            getCakeOrder();
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            getBreadOrder();
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
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
        printMenu(Constants.COFFEE.getMsg());
        menuListMaker.printCoffeeMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            Coffee orderCoffee = new Coffee(menuNumber, menuAmount);

            int addShot = askAddShot();
            if(addShot > 0) {
                orderCoffee.addShot(addShot);
            }

            if(menuListMaker.isCoffeeLatte(menuNumber)) {
                String milkInput = askChangeMilk();
                if(!milkInput.equals("NO")) {
                    orderCoffee.setLatte(milkInput);
                }
            }

            orderManager.makeOrder(orderCoffee);
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    int askAddShot() {
        System.out.println("샷추가를 하시겠습니까? 커피는 기본 2샷 입니다.");
        System.out.println("1. 네 / 2. 아니요");
        String userInput = sc.nextLine();

        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            System.out.println("샷을 얼마나 추가 하시겠습니까? 숫자로 입력해주세요.");
            int shots = sc.nextInt();
            sc.nextLine();

            return shots;
        } else {
            return 0;
        }
    }

    String askChangeMilk() {
        System.out.println("우유를 바꾸시겠습니까?");
        System.out.println("1. 바꾼다.");
        System.out.println("2. 아니요.");

        String userInput = sc.nextLine();

        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            System.out.println("어떤 우유로 바꾸시겠습니까?");
            System.out.println("1. 저지방 우유");
            System.out.println("2. 두유");
            System.out.println("3. 귀리 우유");

            userInput = sc.nextLine();

            return userInput;
        } else {
            return "NO";
        }
    }

    void getTeaOrder() {
        printMenu(Constants.TEA.getMsg());
        menuListMaker.printTeaMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            Tea orderTea = new Tea(menuNumber, menuAmount);
            int addShot = askAddShot();
            if(addShot > 0) {
                orderTea.addShot(addShot);
            }
            orderManager.makeOrder(orderTea);
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    void getJuiceOrder() {
        printMenu(Constants.JUICE.getMsg());
        menuListMaker.printJuiceMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Juice(menuNumber, menuAmount));
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    void getAdeOrder() {
        printMenu(Constants.ADE.getMsg());
        menuListMaker.printAdeMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Ade(menuNumber, menuAmount));
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    void getCakeOrder() {
        printMenu(Constants.CAKE.getMsg());
        menuListMaker.printCakeMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            orderManager.makeOrder(new Cake(menuNumber, menuAmount));
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    void getBreadOrder() {
        printMenu(Constants.BREAD.getMsg());
        menuListMaker.printBreadMenu();
        printHowInput();

        String userInput = sc.nextLine();
        if(validateMenuInput(userInput)) {
            int menuNumber = Integer.parseInt(userInput.split(" ")[0]);
            int menuAmount = Integer.parseInt(userInput.split(" ")[1]);

            Bread orderBread = new Bread(menuNumber, menuAmount);

            if(askNeedCut()) {
                orderBread.setNeedCut();
            }
            if(askNeedWarmUp()) {
                orderBread.setNeedWarmUp();
            }
            orderManager.makeOrder(orderBread);
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
        askMoreMenu();
    }

    boolean askNeedCut() {
        System.out.println("컷팅 하시겠습니까?");
        System.out.println("1. 네");
        System.out.println("2. 아니요");
        String userInput = sc.nextLine();

        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            return true;
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            return false;
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
            return askNeedCut();
        }
    }

    boolean askNeedWarmUp() {
        System.out.println("빵을 데우시겠습니까?");
        System.out.println("1. 네");
        System.out.println("2. 아니요");
        String userInput = sc.nextLine();

        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            return true;
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            return false;
        } else {
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
            return askNeedWarmUp();
        }
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

    // 주문 확인하기
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
            System.out.println(Constants.WRONG_INPUT_MSG.getMsg());
        }
    }

    void askMoreMenu() {
        System.out.println();
        System.out.println("추가 주문을 하시겠습니까?");
        System.out.println("1. 추가");
        System.out.println("2. 결제");

        String userInput = sc.nextLine();
        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            getOrder();
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            getCharge();
        }
    }

    void getCharge() {
        Order order = orderManager.getOrder();
        orderManager.charge();

        System.out.println();
        System.out.println("<주문 목록>");
        int price = 0;
        for(Menu menu : order.getMenuList()) {
            System.out.println(menu);
            price += menu.getPrice() * menu.getAmount();
        }
        System.out.println("총 결제 금액은 " + String.format("%,d", price) + "원 입니다.");
        System.out.println();

        System.out.println("결제가 완료되었습니다.");
        System.out.println("주문번호는 " + order.getOrderNumber() + " 입니다.");
        System.out.println("주문번호로 부르면 픽업대로 와주세요.");
    }

    boolean askQuit() {
        System.out.println();
        System.out.println("키오스크 사용을 그만할까요?");
        System.out.println("종료를 원하시면 1, 계속 사용하고 싶으면 2 를 입력해주세요.");

        String userInput = sc.nextLine();
        if(userInput.equals(Constants.INPUT_ONE.getMsg())) {
            System.out.println("사용해주셔서 감사합니다. 다음에 또 방문해주세요.");
            return true;
        } else if(userInput.equals(Constants.INPUT_TWO.getMsg())) {
            System.out.println();
            return false;
        }
        return false;
    }
}
