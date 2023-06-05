import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    // 방 리스트
    private List<Room> roomList = new ArrayList<>();

    //Test Input용 메서드(삭제해야대)
    //CHARGE 단위 1.0*10000
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
    private String asset;

    // 객실 리스트 출력하는 메소드
    // 예약하고 싶은 날짜를 입력 받기
    // 형철님
    public void showRoomList() {
        // 오늘 날짜 출력(iso 8601에 따라 표현된 날짜)
        System.out.println("오늘은 " + LocalDate.now() + "입니다.");
        // 고객으로부터 원하는 날짜 입력받기
        Scanner scan = new Scanner(System.in);
        //yyyy년 MM월 dd일 타입으로 입력받기
        System.out.println("yyyy-MM-dd 형태로 원하시는 날짜를 입력해주세요. 예: 2023-06-05 ");
        String date = scan.nextLine();
        for(Room room:roomList){
            if(!room.getReservationList().contains(date)){
                System.out.println(room.toString());
            }
        }
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
    public void confirmDelete() {

    }

    // 호텔에서 모든 예약 목록 조회 기능
    // 푸름님
    public void showAllReservation() {

    }


}
