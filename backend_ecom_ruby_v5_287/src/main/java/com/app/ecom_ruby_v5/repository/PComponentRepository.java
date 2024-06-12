package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.PComponent;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class PComponentRepository extends SimpleJpaRepository<PComponent, String> {
    private final EntityManager em;
    public PComponentRepository(EntityManager em) {
        super(PComponent.class, em);
        this.em = em;
    }
    @Override
    public List<PComponent> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"PComponent\"", PComponent.class).getResultList();
    }
}