package hu.helixlab.ms.webshop.controller;

import hu.helixlab.ms.entity.domain.Product;
import hu.helixlab.ms.webshop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "productsController findAll", notes = "Find all available product")
    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @ApiOperation(value = "productsController findOne", notes = "Find a product by Id")
    @GetMapping(value = "products/{id}")
    public Product findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @ApiOperation(value = "productsController create", notes = "Create a product")
    @PostMapping(value = "products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @ApiOperation(value = "productsController delete", notes = "Delete a product by id")
    @DeleteMapping(value = "products/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PutMapping(value = "products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void upldate(@RequestBody Product product) {
        productService.update(product);
    }
}
