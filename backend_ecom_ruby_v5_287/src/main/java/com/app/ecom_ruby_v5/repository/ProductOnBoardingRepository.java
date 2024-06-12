package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.ProductOnBoarding;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ProductOnBoardingRepository extends SimpleJpaRepository<ProductOnBoarding, String> {
    private final EntityManager em;
    public ProductOnBoardingRepository(EntityManager em) {
        super(ProductOnBoarding.class, em);
        this.em = em;
    }
    @Override
    public List<ProductOnBoarding> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"ProductOnBoarding\"", ProductOnBoarding.class).getResultList();
    }
}