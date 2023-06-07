public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        // 객실 리스트 생성하기
        hotel.init();
        // 메인 메뉴 출력하기
        System.out.println("☆ 불좀꺼조 호텔에 오신 것을 환영합니다 ☆");
        hotel.showMain();
    }
}