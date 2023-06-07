## ⌨️ 코드 구성
Customer.java, Room.java, Reservation.java, Hotel.java, Main.java 총 5개의 클래스로 구성되어 있다.

1. Customer.java
```java
public class Customer {

    private String name, phone;    // 이름, 전화번호
    private Double cash;           // 소지금

    public String getName() { return name; }

    public String getPhone() { return phone; }

    public Double getCash() { return cash; }

    public void setCash(Double cash) { this.cash = cash; }

    public Customer(String name, String phone, Double cash) {
        this.name = name;
        this.phone = phone;
        this.cash = cash;
    }
}
```
고객의 이름과 전화번호, 소지금을 저장할 수 있는 필드와
그에 접근 가능한 getter 메소드, Customer 생성자로 구성되어 있다.

2. Room.java
```java
public class Room {

    private String roomSize;                                  // 방 사이즈
    private Double roomCharge;                                // 방 요금
    private List<String> reservationList = new ArrayList<>(); // 예약 날짜 리스트

    public String getRoomSize() { return roomSize; }

    public Double getRoomCharge() { return roomCharge; }

    public List<String> getReservationList () { return reservationList; }

    Room(String roomSize, Double roomCharge) {
        this.roomSize = roomSize;
        this.roomCharge = roomCharge;
    }

    @Override
    public String toString() {
        return "방 이름(크기):" + this.roomSize+" , 가격: "+this.roomCharge;
    }
}
```
방의 사이즈와 방의 요금을 저장할 수 있는 필드와 예약 날짜를 리스트 형태로 저장한다.
각 필드와 리스트에 접근 가능한 getter 메소드가 있고, Room() 생성자가 있다.
toString() 메소드를 오버라이드 하여 방 이름과 가격을 출력해주는 메소드로 사용한다.

3. Reservation.java
```java
public class Reservation {

    // 객실, 고객 이름, 고객 전화번호, 숙박일, 예약 번호
    private Room room; 
    private String customerName, phoneNumber, reservationDate, id;

    public Room getRoom() { return room; }

    public String getCustomerName() { return customerName; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getReservationDate() { return reservationDate; }

    public String getId() { return id; }

    public Reservation(Room room, String customerName, String phoneNumber, String reservationDate) {
        this.room = room;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.reservationDate = reservationDate;
        this.id = UUID.randomUUID().toString();
    }

}
```
객실과 고객 이름, 고객 전화번호, 숙박일, 예약 번호를 저장할 수 있는 필드를 생성하고,
각 필드에 접근 가능한 getter 메소드를 만들었고, Reservation() 생성자가 존재한다.

4. Hotel.java
```java
```

5. Main.java
```java
public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        // 메인 메뉴 출력하기
        hotel.showMain();
    }
}
```
Hotel 인스턴스를 생성한다. 그리고 메인 메뉴 메소드인 showMain()을 호출하여 실행한다.
