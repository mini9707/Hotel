import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Hotel {
    // 방 리스트
    private List<Room> roomList = new ArrayList<>();
    private String password = "1234";

    // 객실 리스트
    // CHARGE 단위 1.0*10000
    public void init() {
        roomList = Arrays.asList(
                new Room("STANDARD_TWIN", 9.0),
                new Room("STANDARD_DOUBLE", 9.0),
                new Room("STANDARD_ONDOL", 9.0),
                new Room("DELUX_TWIN", 10.0),
                new Room("DELUX_KIDSROOM", 11.0),
                new Room("DELUX_TRIPLE", 11.5),
                new Room("DELUX_FAMILY_TWIN", 13.0),
                new Room("JUNIOR_SUITE", 15.0),
                new Room("FAMILY_SUITE", 24.0)
        );
    }

    //예약 리스트
    private List<Reservation> reservationList = new ArrayList<>();
    // 고객 리스트
    private List<Customer> customerList = new ArrayList<>();
    // 호텔 자산
    private String asset;

    // 객실 리스트 출력하는 메소드
    // 예약하고 싶은 날짜를 입력 받기
    // 예약 날짜를 리턴
    // 형철님
    public String showRoomList() {
        String resDate = null;
        LocalDate today = LocalDate.now();
        // 오늘 날짜 출력(iso 8601에 따라 표현된 날짜)
        System.out.println("오늘은 " + LocalDate.now() + "입니다.");
        // 고객으로부터 원하는 날짜 입력받기
        Scanner scan = new Scanner(System.in);
        //yyyy년 MM월 dd일 타입으로 입력받기
        String pattern = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
        while (true) {
            System.out.println("yyyy-MM-dd 형태로 원하시는 날짜를 입력해주세요. 예: 2023-06-05 ");
            resDate = scan.nextLine();
            if (Pattern.matches(pattern, resDate)) { //날짜 형식 체크
                LocalDate reservationDate = LocalDate.parse(resDate);
                int compare = reservationDate.compareTo(today);
                if (compare < 0) {
                    System.out.println("오늘 이전의 날은 입력하실 수 없습니다.");
                    continue;
                }
                System.out.printf("%-13s | %s\n", "방 이름", "가격(만원)");
                for (Room room : roomList) {
                    if (!room.getDateList().contains(resDate)) {
                        System.out.printf("%-15s | %.1f\n", room.getRoomSize(), room.getRoomCharge());
                    }
                }
                break;
            }
            System.out.println("날짜 형식이 올바르지 않습니다.");
        }
        return resDate;
    }

    // 객실 입력받는 메소드
    // 입력받아서 다음 메소드인 고객 정보를 입력 받을 때 Room 타입의 필드를 넘겨줌
    // 병민님
    public Room inputRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약하실 객실을 입력해주세요 ex)FAMILY_SUITE");
        String roomType = scanner.nextLine();
        boolean a = false;
        for (Room room : roomList) {
            a = room.getRoomSize().equals(roomType);
            if (a) {
                return room;
            }
        }
        if (a == false) {
            System.out.println("잘못 입력하셨습니다");
            return inputRoom();
        }
        return null;
    } // inputRoom()

    // 고객 정보를 입력받는 메소드
    // 고객 정보를 입력 받아서 있으면 그냥 진행하고, 없으면 고객 리스트에 추가하기
    // 그 다음에 소지금 판단하기
    // 인서님
    public Customer inputCustomer(Room room) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------ 고객 정보 입력받기 ------");

        System.out.print("성함을 입력해주세요: ");
        String name = sc.nextLine();

        //System.out.print("전화번호를 입력해주세요: ");
        //String phone = sc.nextLine();
        String phone = InputPhoneCheck();

        System.out.print("소지금을 입력해주세요 ※1은 1만원을 의미합니다. :  ");
        Double cash = sc.nextDouble();

        Customer customer = new Customer(name, phone, cash);
        boolean found = false;
        for (Customer c : customerList) {
            if (c.getName().equals(customer.getName()) && c.getPhone().equals(customer.getPhone())) {
                found = true;
                c.setCash(customer.getCash());
                break;
            }
        }
        if (!found) {
            customerList.add(customer);
        }

        if (customer.getCash() >= room.getRoomCharge()) {
            customer.setCash(customer.getCash() - room.getRoomCharge());
            System.out.println("예약이 가능합니다.");
        } else {
            System.out.println("소지금이 부족합니다. 예약이 불가합니다.");
            customer = null;
        }

        // return type을 Customer로 설정했기 때문에 customer를 return하는 것으로 고정하되,
        // 예약 불가능할 경우 customer = null로 코드를 작성했습니다.
        // 즉 다음 메서드인 reservationComplete()에서 (Memo 때 했던 것처럼)customer!=null로 확인 후 메서드 실행 여부를 결정해야 합니다.
        return customer;
    }

    // 예약 완료 화면
    // 예약 번호를 반환 (uuid)
    // 예약 리스트 안에 Reservation (객실과 고객이름과 고객전화번호, 예약날짜, 예약번호) 저장하기
    // 푸름님
    public void reservationComplete(Room room, Customer customer, String date) {
        System.out.println();
        System.out.println("------ 예약 완료 페이지 ------");
        Reservation reservation = null;
        if (customer != null) {
            reservation = new Reservation(room, customer.getName(), customer.getPhone(), date);
            reservationList.add(reservation);
            room.setDateList(date);
            System.out.println("예약이 완료되었습니다.");
            System.out.println("고객님의 예약 번호는 " + reservation.getId() + "입니다.");
        } else {
            System.out.println("예약이 완료되지 않았습니다. 메인 화면으로 돌아갑니다.");
        }
    } // reservationComplete()

    // 예약 확인 & 식제
    // 이름만 전화번호를 입력받고 고객 리스트에서 판별하기
    // 고객 리스트에 있으면 예약 목록에서 출력해줌
    // 삭제 여부를 입력받고, 예약 번호 입력받아서 맞으면 삭제
    // 수연
    public void reservationConfirm() {
        Scanner sc = new Scanner(System.in);
        // 고객의 성함과 전화번호를 우선 입력받는다.
        System.out.print("성함을 입력해주세요: ");
        String name = sc.nextLine();
        //System.out.print("전화번호를 입력해주세요: ");
        //String phoneNumber = sc.nextLine();
        String phoneNumber = InputPhoneCheck();
        // 고객이 리스트에 존재할 지 판단하는 boolean 타입의 필드 선언
        boolean custo = false;
        // 고객 리스트에 해당 고객이 존재하는지 판단
        for (Customer customer : customerList) {
            if (customer.getName().equals(name) && customer.getPhone().equals(phoneNumber)) {
                custo = true;
            }
        }
        // 고객이 존재한다면,
        if (custo) {
            Integer count = 0;
            for (Reservation reservation : reservationList) {
                if (reservation.getCustomerName().equals(name) && reservation.getPhoneNumber().equals(phoneNumber)) {
                    count += 1;
                } // if문 종료
            } // for문 종료

            if (count > 0) {
                System.out.println(name + "님의 예약 내역을 출력합니다.");
                // 예약 리스트에서 예약 내역 출력하기
                for (Reservation reservation : reservationList) {
                    if (reservation.getCustomerName().equals(name) && reservation.getPhoneNumber().equals(phoneNumber)) {
                        System.out.printf("%-4s | %-10s | %s | %s\n", reservation.getCustomerName(), reservation.getRoom().getRoomSize(), reservation.getReservationDate(), reservation.getId());
                    } // if문 종료
                } // for문 종료

                deleteReservation();
            } else {
                System.out.println("고객님의 예약 내역이 존재하지 않습니다.");
                System.out.println("3초 후 고객 메뉴로 돌아갑니다.");
                try {
                    Thread.sleep(3000);
                    showCustomerMenu();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }

            // 고객이 존재하지 않는다면,
        } else {
            System.out.println("고객님의 정보가 존재하지 않습니다.");
            System.out.println("고객 메뉴로 돌아갑니다\n");
            showCustomerMenu();
        }
    }

    // 예약을 삭제하는 메소드
    public void deleteReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n예약 내역을 삭제하시겠습니까?(예/아니오): ");
        String yesNo = sc.nextLine();
        if (yesNo.equals("예")) {
            System.out.print("예약 번호를 입력해주세요: ");
            String reservationNum = sc.nextLine();
            Boolean yesOrNo = false;
            Reservation r = null;
            for (Reservation reservation : reservationList) {
                if (reservation.getId().equals(reservationNum)) {
                    r = reservation;
                    yesOrNo = true;
                } // if문 종료
            } // for문 종료

            if (!yesOrNo) {
                System.out.println("잘못된 예약 번호입니다.");
            } else {
                reservationList.remove(r);
                Room removeroom = r.getRoom();
                removeroom.getDateList().remove(r.getReservationDate());
                System.out.println("예약이 삭제되었습니다.");
            }

        } else if (yesNo.equals("아니오")) {
            System.out.println("고객 메뉴로 돌아갑니다.");
            showCustomerMenu();
        } else {
            System.out.println("잘못 입력하셨습니다. 고객 메뉴로 돌아갑니다.");
            showCustomerMenu();
        }
    } // deleteReservation()

    // 호텔에서 모든 예약 목록 조회 기능
    // 푸름님
    public void showAllReservation() {
        System.out.println();
        System.out.println("------ 호텔 페이지 ------\n");
        System.out.println("관리자 비밀번호를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String inputPassword = sc.nextLine();

            if (inputPassword.equals(password)) {
                for (Reservation r : reservationList) {
                    System.out.printf("%s | %-4.1f | %-5s | %12s | %10s | %s\n", r.getRoom().getRoomSize(), r.getRoom().getRoomCharge(), r.getCustomerName(), r.getPhoneNumber(), r.getReservationDate(), r.getId());
//                    System.out.println(r.getRoom().getRoomSize()+r.getRoom().getRoomCharge()+r.getCustomerName()+r.getPhoneNumber()+r.getReservationDate()+r.getId());
                }
                break;
                }
            System.out.println("예약 내역이 존재하지 않습니다.");
            System.out.println("메인 메뉴로 돌아갑니다.");
            showMain();
            } else {
                System.out.println("다시 입력해주세요.");
            }
        } // while()
        System.out.println("메인 메뉴로 돌아갑니다.");
        showMain();
    } // showAllReservation()

    public void showHotelMenu() {
        System.out.println();
        System.out.println("------ 호텔 페이지 ------\n");
        System.out.println("관리자 비밀번호를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String inputPassword = sc.nextLine();

        if (inputPassword.equals(password)) {
            System.out.println("1. 호텔 예약 리스트");
            System.out.println("2. 관리자 비밀번호 수정");
            System.out.print("메뉴를 입력해주세요: ");
            String inputMenu = sc.nextLine();

            if (inputMenu.equals("1") || "호텔 예약 리스트".contains(inputMenu)) {
                showAllReservation();
            } else if (inputMenu.equals("2") || "관리자 비밀번호 수정".contains(inputMenu)) {
                setPassword();
            }
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
            System.out.println("3초 후 메인 메뉴로 돌아갑니다.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    } // showHotelMenu()

    public void setPassword() {
        System.out.print("비밀번호를 수정하시겠습니까? (예/아니오): ");
        Scanner sc = new Scanner(System.in);

        String yesno = sc.nextLine();

        if (yesno.equals("예")) {
            System.out.print("비밀번호를 다시 한 번 입력해주세요: ");
            String newPW = sc.nextLine();

            if (newPW.equals(password)) {
                System.out.print("수정할 비밀번호를 입력해주세요: ");
                String newsetPW = sc.nextLine();
                this.password = newsetPW;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }

            System.out.println("비밀번호가 변경되었습니다.");
        } else {
            System.out.println("3초 후 메인 메뉴로 돌아갑니다.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    } // setPassword()

    // 첫 화면에서 메뉴들을 출력하는 메소드
    public void showMain() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----메인 메뉴-----");
            System.out.println("1. 고객");
            System.out.println("2. 호텔");
            System.out.println("3. 종료");

            System.out.print("메뉴를 입력해주세요: ");
            String menu = sc.nextLine();

            if (menu.equals("고객") || menu.equals("1")) {
                showCustomerMenu();
            } else if (menu.equals("호텔") || menu.equals("2")) {
                showHotelMenu();
            } else if (menu.equals("종료") || menu.equals("3")) {
                System.out.println("불좀꺼조 호텔 예약 프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        } // while()
    } // showMain()

    // 고객 세부 메뉴 출력하기
    public void showCustomerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------고객 페이지--------");
        System.out.println("1. 예약하기");
        System.out.println("2. 예약 내역 확인하기 & 삭제하기");
        System.out.println("3. 메인 메뉴로 돌아가기");
        System.out.print("메뉴를 입력해주세요: ");
        String detailMenu = sc.nextLine();
        if (detailMenu.equals("1") || detailMenu.equals("예약하기")) {
            // 객실 리스트를 출력하는 메소드 호출
            String date1 = showRoomList();
            Room room1 = inputRoom();
            Customer customer1 = inputCustomer(room1);
            reservationComplete(room1, customer1, date1);
        } else if (detailMenu.equals("2") || "예약 내역 확인하기 & 삭제하기".contains(detailMenu)) {
            // 예약 내역 확인하기
            reservationConfirm();
        } else if ((detailMenu.equals("3") || "메인 메뉴로 돌아가기".contains(detailMenu))) {
            showMain();
        } else {
            System.out.println("잘못된 메뉴입니다.");
        }
    } // showCustomerMenu()

    // 전화번호
    private String InputPhoneCheck() { //전화번호 정규표현식
        Scanner scan = new Scanner(System.in);
        String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"; // 숫자만 등장하는지
        while (true) {
            System.out.print("전화번호를 입력해주세요 ex)000-0000-0000 : ");
            String inputPhone = scan.nextLine();
            if (Pattern.matches(pattern, inputPhone))
                return inputPhone;
            System.out.println("올바른 전화번호 형식이 아닙니다. 다시 입력해주세요");
        }
    } // InputPhoneCheck()
}
