package com.wnet.desafio1;

import com.wnet.desafio1.entities.Order;
import com.wnet.desafio1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Desafio1Application{

    public static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired OrderService orderService) {
        return args -> {
            System.out.println(String.format("DESAFIO: Componentes e injeção de dependência %n--------------------------------------------------------------------------------------------------"));

            Order order = new Order(1034, 150.00, 20.00);
            System.out.println(String.format("Dados de Entrada 1: código do pedido: %s - valor básico: %.2f - porcentagem de desconto: %.2f %n",order.getCode(), order.getBasic(), order.getDiscount() ));
            System.out.println(String.format("Pedido código: %s  %nValor Total: R$ %.2f", order.getCode(), orderService.total(order)));

            Order order1 = new Order(2282, 800.00, 10.00);
            System.out.println(String.format("%n--------------------------------------------------------------------------------------------------"));
            System.out.println(String.format("Dados de Entrada 2: código do pedido: %s - valor básico: %.2f - porcentagem de desconto: %.2f %n",order1.getCode(), order1.getBasic(), order1.getDiscount() ));
            System.out.println(String.format("Pedido código: %s  %nValor Total: R$ %.2f %n", order1.getCode(), orderService.total(order1)));

            Order order2 = new Order(1309, 95.90, 0.0);
            System.out.println(String.format("%n--------------------------------------------------------------------------------------------------"));
            System.out.println(String.format("Dados de Entrada 3: código do pedido: %s - valor básico: %.2f - porcentagem de desconto: %.2f %n",order2.getCode(), order2.getBasic(), order2.getDiscount() ));
            System.out.println(String.format("Pedido código: %s  %nValor Total: R$ %.2f ", order2.getCode(), orderService.total(order2)));
        };
    }
}
