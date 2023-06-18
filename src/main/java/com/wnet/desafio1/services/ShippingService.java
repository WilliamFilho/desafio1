package com.wnet.desafio1.services;

import com.wnet.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private Double valuebasic;

    public Double shipment(Order order) {
        this.valuebasic = order.getBasic();
        if (this.valuebasic < 100.00) {
            return 20.00;
        } else if (this.valuebasic > 100.00 && this.valuebasic < 200.00) {
            return 12.00;
        }
        return 0.0;
    }
}

