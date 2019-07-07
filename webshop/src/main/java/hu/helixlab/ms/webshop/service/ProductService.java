package hu.helixlab.ms.webshop.service;

import hu.helixlab.ms.entity.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * TODO
     *
     * @return
     */
    List<Product> findAll();

    /**
     * TODO
     *
     * @param id
     * @return
     */
    Product findOne(long id);

    /**
     * TODO
     *
     * @param product
     */
    void delete(Product product);

    /**
     * TODO
     *
     * @param id
     */
    void deleteById(long id);

    /**
     * TODO
     *
     * @param product
     * @return
     */
    Product save(Product product);

    /**
     * TODO
     *
     * @param product
     * @return
     */
    Product update(Product product);
}
