import java.util.ArrayList;
import java.util.List;

public class Room {
    // 크기, 숙박비
    private String roomSize;
    private Double roomCharge;
    // 방마다 리스트를 만들어줌
    private List<String> reservationList = new ArrayList<>();


    public String getRoomSize() {
        return roomSize;
    }

    public Double getRoomCharge() {
        return roomCharge;
    }

    public List<String> getReservationList () {
        return reservationList;
    }

    Room(String roomSize, Double roomCharge) {
        this.roomSize = roomSize;
        this.roomCharge = roomCharge;
    }

    @Override
    public String toString() {
        return "방 이름(크기):" + this.roomSize+" , 가격: "+this.roomCharge;
    }
}
