import java.util.ArrayList;
import java.util.List;

public class Room {
    // 크기, 숙박비
    private String roomSize;
    private Double roomCharge;
    // 방마다 리스트를 만들어줌
    private List<String> dateList = new ArrayList<>();


    public String getRoomSize() {
        return roomSize;
    }

    public Double getRoomCharge() {
        return roomCharge;
    }

    public List<String> getDateList () {
        return dateList;
    }
    public void setDateList (String date) {
        this.dateList.add(date);
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