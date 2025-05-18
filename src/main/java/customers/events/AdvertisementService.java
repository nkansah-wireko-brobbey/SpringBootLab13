package customers.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    @EventListener
    void printNewCustomerInfo(NewCustomerEvent event){
        System.out.println(this.getClass().getName()+": "+event.getCustomerInfo());
    }
    
}
