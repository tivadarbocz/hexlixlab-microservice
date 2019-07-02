//package hu.helixlab.ms.webshop.controller;
//
//import domain.Product;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.List;
//
//@Api
//@RestController
//public class ProductRestController {
//
//    @ApiOperation(value = "productsController findAll", notes = "Find all available product")
//    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Product> findAll() {
//        return Collections.emptyList();
//    }
//
//    @ApiOperation(value = "productsController findOne", notes = "Find a product by Id")
//    @GetMapping(value = "products/{id}")
//    public Product findOne(@PathVariable("id") Long id) {
//        return null;
//    }
//
//    @ApiOperation(value = "productsController create", notes = "Create a product")
//    @PostMapping(value = "products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Product create(@RequestBody Product product) {
//        return null;
//    }
//
//    @ApiOperation(value = "productsController delete", notes = "Delete a product by id")
//    @DeleteMapping(value = "products/{id}")
//    public void delete(@PathVariable Long id) {
//
//    }
//}
