import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
    public class Stream{
    private Scanner productRepository;
    @Autowired
        // sem stream
      private ProductRepository;
        public List<String> findFeaturedProductedNamesImperative(){
            List<Product> allProducts = productRepository.findAll();
            List<String> productNames = new ArrayList<>();
             for(Product product : allProducts){
                 if(product.getPrice() > 500.0){
                     String upperCaseName = product.getName().toUpperCase();
                 }
             }
             return productNames;
        }
        //agora usando o stream
        public  List<String> findFeaturedProductedNamesFunctional(){
            List<String> allProducts = productRepository.findAll();
                return allProducts.stream()
                        .filter(product -> product.getPrice() > 500.0).map(product -> product.getName().toUpperCase())
                        .collect(Collectors.toList());
        }// bem menos role

    }

