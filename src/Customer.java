public class Customer {

    private String name, phone;
    private Double cash;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Double getCash() {
        return cash;
    }

    public Customer(String name, String phone, Double cash) {
        this.name = name;
        this.phone = phone;
        this.cash = cash;
    }

}
