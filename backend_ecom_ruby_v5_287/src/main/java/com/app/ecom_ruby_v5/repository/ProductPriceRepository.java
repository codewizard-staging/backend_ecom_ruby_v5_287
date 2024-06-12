package com.app.ecom_ruby_v5.repository;

import com.app.ecom_ruby_v5.model.ProductPrice;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ProductPriceRepository extends SimpleJpaRepository<ProductPrice, String> {
    private final EntityManager em;
    public ProductPriceRepository(EntityManager em) {
        super(ProductPrice.class, em);
        this.em = em;
    }
    @Override
    public List<ProductPrice> findAll() {
        return em.createNativeQuery("Select * from \"ecom_ruby_v5\".\"ProductPrice\"", ProductPrice.class).getResultList();
    }
}