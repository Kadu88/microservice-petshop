package com.ceobarros.product.product.controller;

import com.ceobarros.product.product.model.Image;
import com.ceobarros.product.product.model.Product;
import com.ceobarros.product.product.service.ImageService;
import com.ceobarros.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Blob;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProductControler {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/product");
    }

    @RequestMapping(value = "get-all-product", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Product> findAllProduct() { return productService.findAllProduct();
    }

    @RequestMapping(value = "get-product-by-id", method = RequestMethod.GET)
    @ResponseBody
    public Product findProductById(@RequestParam("id-product") Integer idProduct) {
        return productService.findProductById(idProduct);
    }

    @RequestMapping(value = "add-product-name-description", method = RequestMethod.POST)
    public void addProductNameDescription(@RequestParam("name") String name, @RequestParam("description") String description) {
        productService.addProductNameDescription(name, description);
    }
    @RequestMapping(value = "add-product", method = RequestMethod.POST)
    public void addProduct(@RequestBody(required = false) Product product) {
        productService.addProduct(product);
    }


//    @RequestMapping(value = "add-product", method = RequestMethod.POST)
//    public void addProduct(@RequestParam("name") String name,
//                           @RequestParam("description") String description,
//                           @RequestParam("category") String category,
//                           @RequestParam("amount") Integer amount,
//                           @RequestParam("value") BigDecimal value) {
//        productService.addProduct(name, description, category, amount, value);
//    }

    @RequestMapping(value = "update-product", method = RequestMethod.POST)
    public void updateProduct(@RequestParam("id-product") Integer idProduct,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("category") String category,
                           @RequestParam("amount") Integer amount,
                           @RequestParam("value") BigDecimal value,
                           @RequestParam("id-image") Integer idImage) {
        productService.updateProduct(idProduct, name, description, category, amount, value, idImage);
    }

    @RequestMapping(value = "get-image-by-id", method = RequestMethod.GET)
    @ResponseBody
    public Image findImageById(@RequestParam("id-image") Integer idImage) {
        return imageService.findImageById(idImage);
    }

    @RequestMapping(value = "add-image-medium", method = RequestMethod.POST)
    public void addImageMedium(@RequestParam("id-product") Integer idProduct, @RequestParam("image-medium") Blob imageMedium) {
        imageService.addImageMedium(idProduct, imageMedium);
    }
}
