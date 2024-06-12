package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.Order;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class OrderRepository extends SimpleJpaRepository<Order, String> {
    private final EntityManager em;
    public OrderRepository(EntityManager em) {
        super(Order.class, em);
        this.em = em;
    }
    @Override
    public List<Order> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"Order\"", Order.class).getResultList();
    }
}