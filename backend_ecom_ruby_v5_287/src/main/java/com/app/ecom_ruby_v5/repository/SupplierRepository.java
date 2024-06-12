package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.Supplier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SupplierRepository extends SimpleJpaRepository<Supplier, String> {
    private final EntityManager em;
    public SupplierRepository(EntityManager em) {
        super(Supplier.class, em);
        this.em = em;
    }
    @Override
    public List<Supplier> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"Supplier\"", Supplier.class).getResultList();
    }
}