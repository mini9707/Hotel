import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Reservation {

    // 객실, 고객 이름, 고객 전화번호, 예약 날짜, uuid
    private Room room;
    private String customerName, phoneNumber, reservationDate, id;

    public Reservation(Room room, String customerName, String phoneNumber, String reservationDate) {
        this.room = room;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.reservationDate = reservationDate;
        this.id = UUID.randomUUID().toString();
    }


}
