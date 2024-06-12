package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.OrderItem;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class OrderItemRepository extends SimpleJpaRepository<OrderItem, String> {
    private final EntityManager em;
    public OrderItemRepository(EntityManager em) {
        super(OrderItem.class, em);
        this.em = em;
    }
    @Override
    public List<OrderItem> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"OrderItem\"", OrderItem.class).getResultList();
    }
}