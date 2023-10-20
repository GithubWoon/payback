package payback.ive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/shopping")
public class AddQuantityController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/AddQuantity")
    @Transactional
    public String addQuantity(@RequestParam String productName, 
                              @RequestParam(required = false) Integer quantity, 
                              @RequestParam(required = false) Integer productId) {
        Optional<Product> productOptional = productRepository.findByName(productName);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            int existingQuantity = product.getQuantity();
            quantity += existingQuantity;

            product.setQuantity(quantity);
            return "success";
        } else {
            if (productId != null && !productRepository.existsById(productId)) {
                Product newProduct = new Product();
                newProduct.setName(productName);
                newProduct.setProductId(productId);
                newProduct.setQuantity(quantity);

                productRepository.save(newProduct);
                return "success";
            } else {
                return "이미 존재하는 제품 ID입니다.";
            }
        }
    }

    @GetMapping("/CheckProductName")
    public String checkProductName(@RequestParam String productName) {
        Optional<Product> productOptional = productRepository.findByName(productName);

        if (productOptional.isPresent()) {
            return "existing";
        } else {
            return "not_existing";
        }
    }
}
