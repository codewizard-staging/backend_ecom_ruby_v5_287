package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.ShipmentItem;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ShipmentItemRepository extends SimpleJpaRepository<ShipmentItem, String> {
    private final EntityManager em;
    public ShipmentItemRepository(EntityManager em) {
        super(ShipmentItem.class, em);
        this.em = em;
    }
    @Override
    public List<ShipmentItem> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"ShipmentItem\"", ShipmentItem.class).getResultList();
    }
}