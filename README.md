![header](https://capsule-render.vercel.app/api?type=wave&color=auto&height=200&section=header&text=불좀꺼조&fontSize=80)
## 🎇 불좀꺼조
🏨 Spring_6기 A반 1조 호텔 예약 프로그램 🏨

## 📍 프로그램 요구사항
1. 호텔은 여러 객실, 보유 자산을 가짐
2. 객실은 객실 당 하루에 한 사람만 예약 가능
3. 객실은 크기, 숙박비를 가짐
4. 예약은 객실, 고객 이름, 고객 전화번호, 예약 날짜를 가지고 있음
   - 선택) 전화 번호 정규 표현식 (XXX - XXXX - XXXX)
   - 예약 날짜 - ISO 8601 형식으로 조합된 UTC 날씨 및 시간 (ex.2016-10-27T17:13:40+00:00)
5. 고객은 이름, 전화번호, 소지금을 가짐
   - 고객의 소지금보다 비싼 방의 경우 예약 불가
6. 호텔은 모든 예약 목록 조회 가능
7. 고객은 자신의 예약 목록 조회 가능
   - 예약 번호로 예약 내역 조회
8. 고개은 자신의 예약 취소 가능
9. 고객이 호텔 예약 시, 예약 번호(id)를 반환함(UUID 활용하기)
   - 고객이 호텔 예약에 성공하면 예약 번호(id)를 받음
   - 고객이 예약 목록 조회 시, 예약 번호도 함께 조회됨
   - 고객이 예약 취소 시, 예약 번호를 통해 자신의 특정 예약 취소


## 👩‍💻 팀원 역할
- 고푸름: 예약 완료, 호텔의 예약 목록 조회
- 김인서: 고객 정보 리턴
- 송병민: 방 정보 리턴
- 심형철: 예약 가능한 방 조회
- 이수연: 고객의 예약 목록 조회, 삭제


## 💻 출력 화면 구상
```
☆ 불좀꺼조 호텔에 오신 것을 환영합니다 ☆

-----메인 메뉴-----
1. 고객
2. 호텔
3. 종료
메뉴를 입력해주세요: 

------ 고객 페이지 ------
1. 예약하기
2. 예약 내역 확인하기 & 삭제하기
3. 메인 메뉴로 돌아가기
메뉴를 입력해주세요: 

------ 객실 목록 ------
오늘은 2023-06-05T17:13:40+00:00 입니다.
yyyy-MM-dd 형태로 원하시는 날짜를 입력해주세요. 예: 2023-06-05
2023-06-07

방 이름          | 가격 (만 원)
STANDARD_TWIN   | 9.0
STANDARD_DOUBLE | 9.0

------ 객실 정보 입력 ------
예약하실 객실을 입력해주세요 ex)FAMILY_SUITE
STANDARD_TWIN

------ 고객 정보 입력받기 ------
성함을 입력해주세요: 
전화번호를 입력해주세요 ex)000-0000-0000 :
소지금을 입력해주세요 ※1은 1만원을 의미합니다. :  

예약이 가능합니다.

------ 예약 완료 페이지 ------
예약이 완료되었습니다.
고객님의 예약 번호는 0000000-0000-0000-0000-00000000 입니다.

------ 예약 확인 페이지 ------
성함을 입력해주세요: 
전화번호를 입력해주세요 ex)000-0000-0000:

"000" 님의 예약 내역 (총 1건)을 출력합니다.
000 | STANDARD_TWIN | 9.0 | 2023-06-07 | 0000000-0000-0000-0000-00000000

예약 내역을 삭제하시겠습니까?(예/아니오): 

예약 번호를 입력해주세요: 0000000-0000-0000-0000-00000000

예약이 삭제되었습니다.

------ 호텔 페이지 ------
관리자 비밀번호를 입력해주세요: 
1234
1. 호텔 예약 리스트
2. 관리자 비밀번호 수정
메뉴를 입력해주세요: 

------ 예약 내역 관리자 페이지 ------
관리자 비밀번호를 입력해주세요: 
1234

000 | STANDARD_TWIN | 9.0 | 2023-06-07 | 0000000-0000-0000-0000-00000000

3초 후 메인 메뉴로 돌아갑니다.

------ 관리자 비밀번호 수정 페이지 ------
비밀번호를 수정하시겠습니까? (예/아니오): 예
비밀번호를 다시 한 번 입력해주세요: 1234
수정할 비밀번호를 입력해주세요: 12345
비밀번호가 변경되었습니다.
```

## 🗂️ 파일 구성
1. Customer.java
   
고객의 정보를 저장한다.
고객의 이름, 전화번호, 소지금 정보를 가진다.
    
2. Room.java
    
객실 정보를 저장한다.
객실의 크기, 숙박비와, 객실에 예약된 날짜를 저장할 리스트를 가진다.
   
3. Reservation.java
   
예약 정보를 저장한다.
예약하는 객실, 고객 이름, 고객 전화번호, 예약일, 예약번호를 가진다.

4. Hotel.java

호텔의 정보를 저장한다.
객실 리스트, 예약 리스트, 고객 리스트와 호텔의 자산, 관리자 비밀번호를 가진다.
객실 초기화, 메인 메뉴, 고객 메뉴, 호텔 메뉴, 객실 내역, 객실 입력받기, 고객 정보 입력받기, 예약하기, 예약 내역 조회 및 삭제, 호텔에서 예약 내역 조회, 관리자 비밀번호 수정, 전화번호 정규식 판단 메소드를 가진다.

5. Main.java
   
main 메소드를 실행한다.
Hotel 인스턴스를 생성하고, showMain() 메소드를 호출한다.


## 🪄 코드 구성
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
그에 접근 가능한 getter 메소드, cash 필드를 설정 가능한 setter 메소드, Customer 생성자로 구성되어 있다.

2. Room.java
```java
public class Room {

    private String roomSize;                                  // 방 사이즈
    private Double roomCharge;                                // 방 요금
    private List<String> dateList = new ArrayList<>();        // 예약 날짜 리스트

    public String getRoomSize() { return roomSize; }

    public Double getRoomCharge() { return roomCharge; }

    public List<String> getDateList() { return dateList; }
    
    public void setDateList(String date) { this.dateList.add(date); }

    Room(String roomSize, Double roomCharge) {
        this.roomSize = roomSize;
        this.roomCharge = roomCharge;
    }

}
```
방의 사이즈와 방의 요금을 저장할 수 있는 필드와 예약 날짜를 리스트 형태로 저장한다.
각 필드와 리스트에 접근 가능한 getter 메소드가 있고, dateList에 예약 날짜를 추가할 수 있는 메소드, Room() 생성자가 있다.


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
Hotel 클래스 안에 코드가 길어, 끊어서 설명을 적고자 한다.
```java
public class Hotel {
}
```
아래의 코드는 해당 클래스 내에 적혀있다.

1) 필드 및 리스트
```java
private List<Room> roomList = new ArrayList<>();                 // 방 리스트
private List<Reservation> reservationList = new ArrayList<>();   // 예약 리스트
private List<Customer> customerList = new ArrayList<>();         // 고객 리스트
private String asset;                                            // 호텔 자산
private String password = "1234";                                // 호텔 관리자 비밀번호
```
클래스 내에 생성된 필드 및 리스트이다.
방, 예약, 고객을 저장하기 위한 리스트가 각각 존재하고, 호텔의 자산과 호텔 관리자 비밀번호를 저장하기 위한 필드가 있다.

2) init() 드메소드
```java
// 객실 리스트 - CHARGE 단위 1.0*10000
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
```
객실 리스트를 초기화하는 메소드이다.

3) showMain() 메소드
```java
// 첫 화면에서 메뉴들을 출력하는 메소드
public void showMain() {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("\n-----메인 메뉴-----");
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
            System.out.println("★ 불좀꺼조 호텔 예약 프로그램을 종료합니다 ★");
            break;
        } else {
            System.out.println("잘못된 메뉴입니다.");
        }
    } // while()
} // showMain()
```
메인 메뉴를 출력해준다. 1번의 경우 showCustomerMenu() 메소드 호출, 2번의 경우 showHotelMenu() 메소드 호출, 3번의 경우 반복문을 종료한다.
잘못 입력했을 경우 잘못 입력했다는 메시지를 띄운 후 다시 입력받는다.

4) showCustomerMenu() 메소드
```java
// 고객 세부 메뉴를 출력하는 메소드
public void showCustomerMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n--------고객 페이지--------");
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
    } else {
        System.out.println("잘못된 메뉴입니다.");
    }
} // showCustomerMenu()
```
고객 세부 메뉴를 출력한다. 1번의 경우 showRoomList(), inputRoom(), inputCustomer(), reservationComplete() 메소드를 차례로 호출한다.
2번의 경우 reservationConfirm() 메소드를 호출하고 3번의 경우 메인 메뉴로 돌아간다.

5) showRoomList() 메소드
```java
// 객실 리스트 출력하는 메소드 - 예약하고 싶은 날짜를 입력 받기 & 예약 날짜를 리턴
public String showRoomList() {
    System.out.println("\n------ 객실 목록 ------");
    String resDate = null;
    LocalDate today = LocalDate.now(); 

    System.out.println("오늘은 " + LocalDate.now() + " 입니다.");        // 오늘 날짜 출력(iso 8601에 따라 표현된 날짜)
    Scanner scan = new Scanner(System.in);                              // 고객으로부터 원하는 날짜 입력받기
    String pattern = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])"; // yyyy년 MM월 dd일 타입으로 입력받기

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
```
입력받은 예약 가능한 객실의 리스트를 출력해준다.
오늘 날짜를 출력해주고, 고객에게 날짜를 입력받는다.
만약 날짜를 잘못 입력한 경우나 오늘 이전의 날을 입력받은 경우 날짜를 다시 입력받고, 제대로 된 날짜를 입력받은 경우 해당 날짜에 가능한 객실만 출력해준다.

6) inputRoom() 메소드
```java
// 객실 입력받는 메소드 - 입력받아서 다음 메소드인 고객 정보를 입력 받을 때 Room 타입의 필드를 넘겨줌
public Room inputRoom() {
    System.out.println("\n------ 객실 정보 입력 ------");
    Scanner scanner = new Scanner(System.in);
    System.out.println("예약하실 객실을 입력해주세요 ex)FAMILY_SUITE");
    String roomType = scanner.nextLine();                            // 고객으로부터 객실을 입력받는다
    boolean a = false;
    for (Room room : roomList) {
        a = room.getRoomSize().equals(roomType);                     // 올바른 객실 이름을 입력했다면
        if (a) {
            return room;                                             // 해당 객실을 리턴한다
        }
    }
    if (a == false) {
        System.out.println("잘못 입력하셨습니다");                     // 잘못 입력한 경우 메시지를 출력하고
        return inputRoom();                                          // 메소드를 다시 호출한다
    }
    return null;
} // inputRoom()
```
고객으로부터 원하는 객실을 입력받는다.
객실의 타입을 입력받아 존재하면 해당 Room 타입의 객실을 리턴하고, 잘못 입력한 경우 메소드를 리턴한다.

7) inputCustomer() 메소드
```java
// 고객 정보를 입력받는 메소드 - 고객 정보를 입력 받아서 있으면 그냥 진행하고, 없으면 고객 리스트에 추가하기. 그 다음에 소지금 판단하기
public Customer inputCustomer(Room room) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n------ 고객 정보 입력 ------");

    System.out.print("성함을 입력해주세요: ");
    String name = sc.nextLine();
    String phone = InputPhoneCheck();        // 전화번호 입력받기
    System.out.print("소지금을 입력해주세요 ※1은 1만원을 의미합니다. :  ");
    Double cash = sc.nextDouble();

    Customer customer = new Customer(name, phone, cash);    // 고객 생성자를 만든다
    boolean found = false;                                  // 고객 리스트에 입력받은 고객의 존재 여부를 판단하는 boolean 타입 필드 선언
    for (Customer c : customerList) {
        if (c.getName().equals(customer.getName()) && c.getPhone().equals(customer.getPhone())) {
            found = true;
            c.setCash(customer.getCash());
            break;
        }
    }
    if (!found) {                       // 고객 리스트에 고객이 없다면
        customerList.add(customer);     // 고객 리스트에 고객을 추가한다
    }

    if (customer.getCash() >= room.getRoomCharge()) {                     // 고객의 소지금이 객실의 가격보다 많다면
        customer.setCash(customer.getCash() - room.getRoomCharge());      // 소지금에서 객실 가격을 차감한 후
        System.out.println("예약이 가능합니다.");                          // 예약 가능함을 알려준다
    } else {
        System.out.println("소지금이 부족합니다. 예약이 불가합니다.");       // 소지금이 객실 가격보다 적다면 예약 불가를 알려주고
        customer = null;                                                  // 고객을 null로 리턴한다
    }
    return customer;
} // inputCustomer()
```
고객의 정보를 입력받는다.
이름과 전화번호, 소지금을 입력받고 Customer 타입의 인스턴스를 만든다.
만약 고객 리스트에 해당 고객이 존재할 경우, 소지금만 다시 설정해주고 고객 리스트에 고객이 없다면 고객 리스트에 새 고객을 추가한다.
고객의 소지금이 선택한 객실의 가격보다 많다면 소지금에서 객실의 가격을 차감하고 예약 가능함을 알려준다.
소지금이 객일 가격보다 적다면 예약 불가를 알려주고 고객을 null로 설정한다.

8) reservationComplete() - 메소드
```java
// 예약 완료 화면 - 예약 번호를 반환 (uuid), 예약 리스트 안에 Reservation (객실과 고객이름과 고객전화번호, 예약날짜, 예약번호) 저장하기
public void reservationComplete(Room room, Customer customer, String date) {
    System.out.println();
    System.out.println("------ 예약 완료 페이지 ------");
    Reservation reservation = null;
    if (customer != null) {                                                                  // 고객이 null이 아니라면 (소지금이 객실 가격보다 많은 고객의 경우)
        reservation = new Reservation(room, customer.getName(), customer.getPhone(), date);  // Reservation 를 만들어준다
        reservationList.add(reservation);                                                    // 예약 리스트에 예약을 추가해주고
        room.setDateList(date);                                                              // 해당 객실에 예약한 날짜를 추가한다
        System.out.println("예약이 완료되었습니다.");
        System.out.println("고객님의 예약 번호는 " + reservation.getId() + "입니다.");         // 예약 번호를 고객에게 출력한다
    } else {
        System.out.println("예약이 불가합니다. 메인 화면으로 돌아갑니다.");
    }
} // reservationComplete()
```
예약 완료됨을 알려주며 고객에게 예약 번호를 반환해주는 메소드이다.
만약 고객이 null이 아닌 경우, 즉 고객의 소지금이 객실의 가격보다 많아 예약이 가능한 경우에 Reservation 인스턴스를 만든다.
예약 리스트에 만든 예약을 추가하고, 객실에 예약 날짜(숙박일)을 추가한 후, 예약 번호를 고객에게 출력해준다.

9) reservationConfirm() 메소드
```java
// 예약 확인 - 이름과 전화번호를 입력받고 고객 리스트에서 판별하기, 고객 리스트에 있으면 예약 목록에서 출력
public void reservationConfirm() {
    Scanner sc = new Scanner(System.in);
    System.out.print("성함을 입력해주세요: ");          // 고객의 성함과 전화번호를 우선 입력받는다.
    String name = sc.nextLine();
    String phoneNumber = InputPhoneCheck();
    boolean custo = false;                            // 고객이 리스트에 존재할 지 판단하는 boolean 타입의 필드 선언
    
    for (Customer customer : customerList) {          // 고객 리스트에 해당 고객이 존재하는지 판단
        if (customer.getName().equals(name) && customer.getPhone().equals(phoneNumber)) {
            custo = true;
        }
    }
    if (custo) {           // 고객이 존재한다면
        Integer count = 0; // 해당 고객의 예약 건수 count
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(name) && reservation.getPhoneNumber().equals(phoneNumber)) {
                count += 1;
            } // if문 종료
        } // for문 종료

        if (count > 0) { // 예약 건수가 하나 이상이라면
            System.out.println("\n" +name + "님의 예약 내역 (총 "+count+"건)을 출력합니다.");
            for (Reservation reservation : reservationList) {     // 예약 리스트에서 예약 내역 출력하기
                if (reservation.getCustomerName().equals(name) && reservation.getPhoneNumber().equals(phoneNumber)) {
                    System.out.printf("%-4s | %-10s | %s | %s\n", reservation.getCustomerName(), reservation.getRoom().getRoomSize(), reservation.getReservationDate(), reservation.getId());
                } // if문 종료
            } // for문 종료
            deleteReservation(); // 예약 삭제 여부를 물어보는 메소드 호출
        } else { // 예약 건수가 없다면
            System.out.println("\n고객님의 예약 내역이 존재하지 않습니다.");
            System.out.println("3초 후 고객 메뉴로 돌아갑니다.");
            try {
                Thread.sleep(3000);
                showCustomerMenu();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    } else {   // 고객이 존재하지 않는다면
        System.out.println("\n고객님의 정보가 존재하지 않습니다.");
        System.out.println("고객 메뉴로 돌아갑니다");
        showCustomerMenu();
    }
}
```
고객의 예약 내역을 조회해준다.
고객의 이름과 전화번호를 입력받고, 고객리스트에 존재하면 예약 건수를 count 한다.
count한 고객의 예약 건수가 하나 이상이라면 예약 내역을 출력해주고, 예약 건수가 없다면 예약 내역이 존재하지 않는다고 알려준 후 고객 메뉴를 출력한다.
고객이 존재하지 않으면 고객 정보가 존재하지 않다고 알려준 후, 고객 메뉴로 돌아간다.


10) deleteReservation() 메소드
```java
// 예약을 삭제하는 메소드
public void deleteReservation() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n예약 내역을 삭제하시겠습니까?(예/아니오): ");
    String yesNo = sc.nextLine();
    if (yesNo.equals("예")) {
        System.out.print("예약 번호를 입력해주세요: ");
        String reservationNum = sc.nextLine();                     // 예약 번호를 입력받는다
        Boolean yesOrNo = false;                                   // 입력받은 예약 번호에 해당하는 예약이 있는지 판별하는 boolean 타입의 필드 선언
        Reservation r = null;                                      
        for (Reservation reservation : reservationList) {
            if (reservation.getId().equals(reservationNum)) {      // 예약 번호에 해당하는 예약이 존재한다면
                r = reservation;                                   // Reservation 타입의 필드 안에 해당 예약을 넣어준다
                yesOrNo = true;                                    // yesOrNo를 true로 변경한다
            } // if문 종료
        } // for문 종료

        if (!yesOrNo) {                                              // 예약 번호에 해당하는 예약이 없는 경우
            System.out.println("잘못된 예약 번호입니다.");
        } else {                                                     // 예약이 존재하는 경우
            reservationList.remove(r);                               // 예약 리스트에서 해당 예약 삭제
            Room removeroom = r.getRoom();                           // 객실 정보를 가져와서
            removeroom.getDateList().remove(r.getReservationDate()); // 객실에 해당 날짜도 삭제하기
            System.out.println("예약이 삭제되었습니다.");
        }

    } else if (yesNo.equals("아니오")) {                              // 예약 내역 삭제를 원하지 않는 경우
        System.out.println("고객 메뉴로 돌아갑니다.");                 // 다시 고객 메뉴로 돌아감
        showCustomerMenu();
    } else {
        System.out.println("잘못 입력하셨습니다. 고객 메뉴로 돌아갑니다.");
        showCustomerMenu();
    }
} // deleteReservation()
```
예약을 삭제하는 메소드이다.
삭제 여부를 입력받고 삭제를 원하는 경우, 예약 번호를 입력받는다.
입력받은 예약 번호에 해당하는 예약이 존재하는 경우, 예약 리스트에서 해당 예약을 삭제하고, 해당 객실의 날짜 리스트 안에서 해당 날짜도 함께 지워준다.
삭제를 원하지 않는 경우 다시 고객 메뉴로 돌아간다.


11) showHotelMenu() 메소드
``` java
// 호텔의 메뉴를 출력하는 메소드
public void showHotelMenu() {
    System.out.println();
    System.out.println("------ 호텔 페이지 ------");
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
```
관리자 비밀번호를 입력받고, 일치하는 경우 호텔 메뉴를 출력하고 일치하지 않으면 다시 메인 메뉴로 돌아간다.
호텔 메뉴에서 1번을 누르면 showAllReservation() 메소드를 호출하고, 2번을 누르면 setPassword() 메소드를 호출한다.

12) showAllReservation() 메소드
```java
// 호텔에서 모든 예약 목록 조회 기능
public void showAllReservation() {
    System.out.println();
    System.out.println("------ 예약 내역 관리자 페이지 ------");
    System.out.println("관리자 비밀번호를 입력해주세요: ");
    Scanner sc = new Scanner(System.in);
    while (true) {
        String inputPassword = sc.nextLine();                      // 비밀번호를 입력받아
        if (inputPassword.equals(password)) {                      // 관리자 비밀번호와 일치하는 경우
            if (reservationList.isEmpty()) {                       // 예약 내역이 비어있는 경우
                System.out.println("예약 내역이 존재하지 않습니다.");
            } else {                                               // 예약 내역이 존재하는 경우
                for (Reservation r : reservationList) {
                    System.out.printf("%s | %-4.1f | %-5s | %12s | %10s | %s\n", r.getRoom().getRoomSize(), r.getRoom().getRoomCharge(), r.getCustomerName(), r.getPhoneNumber(), r.getReservationDate(), r.getId());
                }
            }
            break;
        } else {
            System.out.println("다시 입력해주세요.");
        }
    } // while()
    System.out.println("\n3초 후 메인 메뉴로 돌아갑니다.");
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        System.out.println(e.getMessage());
    }
} // showAllReservation()
```
호텔에서 모든 예약 목록을 조회한다.
비밀번호를 입력받아 일치하면, 예약 내역을 조회하는데 예약 내역이 비어있으면 존재하지 않는다고 알려주고, 예약 내역이 있다면 출력해준다.
그 다음 3초 후에 메인 메뉴로 돌아간다.

13) setPassword() 메소드
```java
// 호텔의 관리자 비밀번호를 수정하는 메소드
public void setPassword() {
    System.out.println("\n------ 관리자 비밀번호 수정 페이지 ------");
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
```
호텔 관리자 비밀번호를 수정한다.
비밀번호 수정 여부를 입력받고, 수정하겠다고 입력받으면 비밀번호를 한 번 더 입력받고, 수정할 비밀번호를 입력받는다.
수정할 비밀번호로 비밀번호를 변경한 후 메인 메뉴로 돌아간다.


14) InputPhoneCheck() 메소드
```java
// 전화번호 정규식 판별하는 메소드
private String InputPhoneCheck() { // 전화번호 정규표현식
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
```
전화번호를 입력받을 때, 정규 표현식에 맞는지 판단한다.
전화번호 형식에 일치하면 입력받은 전화번호를 리턴하고, 일치하지 않으면 다시 입력받도록 한다.


5. Main.java
```java
public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.init();              // 객실 리스트 생성하기
        System.out.println("☆ 불좀꺼조 호텔에 오신 것을 환영합니다 ☆");
        hotel.showMain();          // 메인 메뉴 출력하기
    }
}
```
Hotel 인스턴스를 생성한다.
init()메소드로 객실 리스트를 초기화 한 다 메인 메뉴 메소드인 showMain()을 호출하여 실행한다.
