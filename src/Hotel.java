import java.util.ArrayList;
import java.util.List;

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
    public void showRoomList() {
        // 오늘 날짜 출력
        // 고객으로부터 원하는 날짜 입력받기
        // 그 다음에 해당하는 날짜에 - reservationList에 없는 객실들만 출력해야 함

        // Map으로 따로 저장된 key-날짜 / Room 으로 구분해서 없는 방들만 출력

    }

    // 객실 입력받는 메소드
    // 입력받아서 다음 메소드인 고객 정보를 입력 받을 때 Room 타입의 필드를 넘겨줌
    public Room inputRoom() {
        Room room = null;



        return room;
    }

    // 고객 정보를 입력받는 메소드
    // 고객 정보를 입력 받아서 있으면 그냥 진행하고, 없으면 고객 리스트에 추가하기
    // 그 다음에 소지금 판단하기
    public void inputCustomer() {

    }

    // 예약 완료 화면
    // 예약 번호를 반환 (uuid)
    // 예약 리스트 안에 Reservation (객실과 고객이름과 고객전화번호, 예약날짜, 예약번호) 저장하기
    public void reservationComplete() {

    }

    // 예약 확인 & 식제
    // 이름만 전화번호를 입력받고 고객 리스트에서 판별하기
    // 고객 리스트에 있으면 예약 목록에서 출력해줌
    // 삭제 여부를 입력받고, 예약 번호 입력받아서 맞으면 삭제

    public void confirmDelete() {

    }


}
