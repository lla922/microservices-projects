package zenith.codes.projects.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zenith.codes.projects.model.Product;
import zenith.codes.projects.model.ProductRequest;
import zenith.codes.projects.model.ProductResponse;
import zenith.codes.projects.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public record ProductService(ProductRepository productRepository) {


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
    }

    public void deleteProductById(int id){
          productRepository.deleteById(String.valueOf(id));
    }

    public ProductResponse getProductById(int id){

       Optional<Product> foundProduct = productRepository.findById(String.valueOf(id));

        ProductResponse productResponse = ProductResponse.builder()
                .name(foundProduct.get().getName())
                .description(foundProduct.get().getDescription())
                .price(foundProduct.get().getPrice())
                .build();

        return productResponse;
    }

    public List<ProductResponse> getAllProducts(){


            List<Product> allProducts = productRepository.findAll();
            return allProducts.stream().map(product -> toProductResponse(product)).collect(Collectors.toList());


    }

    private ProductResponse toProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
