package hu.helixlab.ms.webshop.service;

import hu.helixlab.ms.dao.repository.ProductRepository;
import hu.helixlab.ms.entity.domain.Product;
import hu.helixlab.ms.webshop.exception.NoResourceException;
import hu.helixlab.ms.webshop.exception.OrderException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new NoResourceException("Resource not found!");
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(Product product) {

        if (product.getId() == null) {
            throw new OrderException("Id can not be null!");
        }

        Product existingProduct = this.findOne(product.getId());

        if (existingProduct == null) {
            throw new NoResourceException("Resource not found!");
        }

        return productRepository.saveAndFlush(product);
    }
}
