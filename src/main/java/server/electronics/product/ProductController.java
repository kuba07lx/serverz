package server.electronics.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import server.electronics.product.domain.ProductFacade;
import server.electronics.product.dto.ProductDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/admin")
class ProductController {
    private ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @RequestMapping("/products")
    List<ProductDto> getFilms(){
        return productFacade.findAll();
    }

    @GetMapping("/product/{id}")
    ProductDto getProduct(@PathVariable String id){
        return productFacade.show(Long.valueOf(id));
    }

    @PostMapping("/product/add")
    ProductDto createNewProduct(@RequestBody ProductDto productDto){
          return  productFacade.add(productDto);
    }

    @DeleteMapping("/product/remove/{id}")
    ResponseEntity deleteProduct(@PathVariable String id){
        productFacade.delete(Long.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/product/add/image")
    public ResponseEntity uploadImage(
            @RequestParam("id") Long id, HttpServletRequest request) {

        try {
            productFacade.uploadImage(id, request);
            return new ResponseEntity("Uploaded succecfully", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("Upload failed", HttpStatus.BAD_REQUEST);
        }
    }
}
