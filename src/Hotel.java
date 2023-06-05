import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public Customer inputCustomer(Room room) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------ 고객 정보 입력받기 ------");

        System.out.print("성함을 입력해주세요: ");
        String name = sc.nextLine();

        System.out.print("전화번호를 입력해주세요: ");
        String phone = sc.nextLine();

        System.out.print("소지금를 입력해주세요: ");
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
    public void reservationComplete() {

    }

    // 예약 확인 & 식제
    // 이름만 전화번호를 입력받고 고객 리스트에서 판별하기
    // 고객 리스트에 있으면 예약 목록에서 출력해줌
    // 삭제 여부를 입력받고, 예약 번호 입력받아서 맞으면 삭제
    // 수연
    public void confirmDelete() {

    }

    // 호텔에서 모든 예약 목록 조회 기능
    // 푸름님
    public void showAllReservation() {

    }


}
