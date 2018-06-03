package server.electronics.product.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import server.electronics.product.dto.ProductDto;
import server.electronics.product.dto.ProductNotFoundException;
import server.electronics.user.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Transactional
@AllArgsConstructor
public class ProductFacade {

    private ProductRepository productRepository;
    private ProductCreator productCreator;
    private ImageUploader imageUploader;

    public ProductDto add(ProductDto productDto){
        requireNonNull(productDto);
        Product product = productCreator.from(productDto);
        productRepository.save(product);
        return product.dto();
    }

    public List<ProductDto> findAll(){
       return productRepository.findAll().stream()
               .map(e -> e.dto())
               .collect(Collectors.toList());
    }

    public void delete(Long id){
        requireNonNull(id);
        productRepository.deleteById(id);
    }

    public ProductDto show(Long id){
        requireNonNull(id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return product.dto();
    }

    public void uploadImage(Long id, HttpServletRequest request) throws Exception{
        requireNonNull(id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        imageUploader.upload(id, request);
    }
}
