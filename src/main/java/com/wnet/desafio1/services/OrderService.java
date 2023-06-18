package com.wnet.desafio1.services;

import com.wnet.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public Double total(Order order){
        return (order.getBasic() - ((order.getBasic() * order.getDiscount())/100)) + shippingService.shipment(order);
    }

}
