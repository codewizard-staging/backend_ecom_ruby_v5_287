package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.OtherDetails;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class OtherDetailsRepository extends SimpleJpaRepository<OtherDetails, String> {
    private final EntityManager em;
    public OtherDetailsRepository(EntityManager em) {
        super(OtherDetails.class, em);
        this.em = em;
    }
    @Override
    public List<OtherDetails> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"OtherDetails\"", OtherDetails.class).getResultList();
    }
}