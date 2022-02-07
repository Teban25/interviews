package com.quickreview.interviews.rs;

import com.quickreview.interviews.persistence.Product;
import com.quickreview.interviews.service.AWSExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductWebServiceImpl {

    @Autowired
    private AWSExamples awsExamples;

    @GetMapping("hello/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(@PathVariable("name") String name) {
        return "Hello world: " + name;
    }

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getProductId(@PathVariable("productId") String productId) {
        Product product = new Product();
        product.setProductId(productId);

        return ResponseEntity.ok(product);
    }


    @GetMapping(value = "/instances", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getDescribeInstances() {

        return ResponseEntity.ok(awsExamples.describeInstances());
    }
}
