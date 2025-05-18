package customers.events;

public class NewCustomerEvent {
    String customerInfo;

    public NewCustomerEvent(String customerInfo){
        this.customerInfo = customerInfo;
    }

    public String getCustomerInfo(){
        return customerInfo;
    }

    public String toString(){
        return customerInfo;
    }
}
