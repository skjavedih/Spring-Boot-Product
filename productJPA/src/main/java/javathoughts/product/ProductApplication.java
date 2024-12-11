package javathoughts.product;

import javathoughts.product.model.Product;
import javathoughts.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		productRepository.save(new Product("Television", "Electronics"));
		productRepository.save(new Product("Air Conditioner", "Electronics"));
		productRepository.save(new Product("Sofa", "Furniture"));
		productRepository.save(new Product("Cushions", "Home Essentials"));
		productRepository.save(new Product("Wordrobe", "Furniture"));
	}

}
