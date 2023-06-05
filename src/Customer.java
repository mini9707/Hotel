public class Customer {

    private String Name, Phone;
    private Double Cash;

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public Double getCash() {
        return Cash;
    }

    public void setCash(Double cash) {
        Cash = cash;
    }

    public Customer(String Name, String Phone, Double Cash) {
        this.Name = Name;
        this.Phone = Phone;
        this.Cash = Cash;
    }
}
