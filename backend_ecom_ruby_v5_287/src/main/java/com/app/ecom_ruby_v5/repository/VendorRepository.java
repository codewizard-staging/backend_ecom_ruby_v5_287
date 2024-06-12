package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.Vendor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class VendorRepository extends SimpleJpaRepository<Vendor, String> {
    private final EntityManager em;
    public VendorRepository(EntityManager em) {
        super(Vendor.class, em);
        this.em = em;
    }
    @Override
    public List<Vendor> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"Vendor\"", Vendor.class).getResultList();
    }
}