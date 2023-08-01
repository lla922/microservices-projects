package zenith.codes.projects.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zenith.codes.projects.model.ProductRequest;
import zenith.codes.projects.model.ProductResponse;
import zenith.codes.projects.service.ProductService;

import java.util.List;

@Tag(name = "Product APIs - v1", description = "Product APIs")
@RestController
@RequestMapping("/products")
public record ProductController(ProductService productService) {


    @Operation(
            summary = "create a product",
            description = "using product request , creates a new product in db."
    )
    @PostMapping("/product")
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @Operation(
            summary = "Get product by id",
            description = "providing the id of a product in order to get the product from db."
    )
    @GetMapping ("/{id}")// id ile islem yapabilmek icin bir tane daha dto objesi lazim search?id=1
    public ProductResponse getProductById(@PathVariable int id){
        ProductResponse foundProduct = productService.getProductById(id);
        return foundProduct;
    }

    @Operation(
            summary = "delete a product",
            description = "providing the id of a product in order to delete the product from db."
    )
    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable int id){
         productService.deleteProductById(id);
    }

    @Operation(
            summary = "get all the products",
            description = "get all the products saved in db."
    )
    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
