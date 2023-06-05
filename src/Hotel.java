import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Hotel {
    // 방 리스트
    private List<Room> roomList = new ArrayList<>();
    //예약 리스트
    private List<Reservation> reservationList = new ArrayList<>();
    // 고객 리스트
    private List<Customer> customerList = new ArrayList<>();
    private String asset;

    // 객실 리스트 출력하는 메소드
    // 예약하고 싶은 날짜를 입력 받기
    // 형철님
    public void showRoomList() {
        // 오늘 날짜 출력
        // 고객으로부터 원하는 날짜 입력받기
        // 그 다음에 해당하는 날짜에 - reservationList에 없는 객실들만 출력해야 함

    }

    // 객실 입력받는 메소드
    // 입력받아서 다음 메소드인 고객 정보를 입력 받을 때 Room 타입의 필드를 넘겨줌
    // 병민님
    public Room inputRoom() {
        Room room = null;

        return room;
    }

    // 고객 정보를 입력받는 메소드
    // 고객 정보를 입력 받아서 있으면 그냥 진행하고, 없으면 고객 리스트에 추가하기
    // 그 다음에 소지금 판단하기
    // 인서님
    public Customer inputCustomer() {
        Customer customer = null;

        return customer;
    }

    // 예약 완료 화면
    // 예약 번호를 반환 (uuid)
    // 예약 리스트 안에 Reservation (객실과 고객이름과 고객전화번호, 예약날짜, 예약번호) 저장하기
    // 푸름님
    public void reservationComplete() {

    }

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
        System.out.print("전화번호를 입력해주세요: ");
        String phoneNumber = sc.nextLine();
        // 고객이 리스트에 존재할 지 판단하는 boolean 타입의 필드 선언
        boolean custo = false;
        // 고객 리스트에 해당 고객이 존재하는지 판단
        for (Customer customer:customerList) {
            if (customer.getName().equals(name) && customer.getPhone().equals(phoneNumber)) {
                custo = true;
            }
        }
        // 고객이 존재한다면,
        if (custo) {
            System.out.println(name +"님의 예약 내역을 출력합니다.");
            // 예약 리스트에서 예약 내역 출력하기
            for (Reservation reservation:reservationList) {
                if (reservation.getCustomerName().equals(name) && reservation.getPhoneNumber().equals(phoneNumber)) {
                    System.out.printf("%-4s | %-10s | %s | %s", reservation.getCustomerName(), reservation.getRoom().getRoomSize(), reservation.getReservationDate(), reservation.getId() );
                } // if문 종료
            } // for문 종료

            deleteReservation();
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
        System.out.println("예약 내역을 삭제하시겠습니까?(예/아니오): ");
        String yesNo = sc.nextLine();
        if (yesNo.equals("예")) {
            System.out.print("예약 번호를 입력해주세요: ");
            String reservationNum = sc.nextLine();
            Boolean yesOrNo = false;

            for (Reservation reservation:reservationList) {
                if (reservation.getId().equals(reservationNum)) {
                    reservationList.remove(reservation);
                    yesOrNo = true;
                } // if문 종료
            } // for문 종료

            if (!yesOrNo) {
                System.out.println("잘못된 예약 번호입니다.");
            } else {
                System.out.println("예약이 삭제되었습니다.");
            }

        } else if (yesNo.equals("아니오")) {
            System.out.println("고객 메뉴로 돌아갑니다.");
            showCustomerMenu();
        } else {
            System.out.println("잘못 입력하셨습니다. 고객 메뉴로 돌아갑니다.");
            showCustomerMenu();
        }
    }

    // 호텔에서 모든 예약 목록 조회 기능
    // 푸름님
    public void showAllReservation() {

    }

    // 첫 화면에서 메뉴들을 출력하는 메소드
    public void showMain() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 고객");
            System.out.println("2. 호텔");

            System.out.print("메뉴를 입력해주세요: ");
            String menu = sc.nextLine();

            if (menu.equals("고객") || menu.equals("1")) {
                showCustomerMenu();
            } else if (menu.equals("호텔") || menu.equals("2")) {
                showAllReservation();
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

    } // showMain()

    // 고객 세부 메뉴 출력하기
    public void showCustomerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------고객 페이지--------");
        System.out.println("1. 예약하기");
        System.out.println("2. 예약 내역 확인하기 & 삭제하기");
        System.out.print("메뉴를 입력해주세요: ");
        String detailMenu = sc.nextLine();
        if (detailMenu.equals("1") || detailMenu.equals("예약하기")) {
            // 객실 리스트를 출력하는 메소드 호출
            showRoomList();
        } else if (detailMenu.equals("2") || "예약 내역 확인하기 & 삭제하기".contains(detailMenu)) {
            // 예약 내역 확인하기
            reservationConfirm();
        } else {
            System.out.println("잘못된 메뉴입니다.");
        }
    } // showCustomerMenu()

}
