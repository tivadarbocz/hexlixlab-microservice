package hu.helixlab.ms.mainapp.config;

import com.thedeanda.lorem.LoremIpsum;
import hu.helixlab.ms.dao.repository.ProductRepository;
import hu.helixlab.ms.entity.domain.Product;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public Bootstrap(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Product p1 = new Product();
        p1.setName(LoremIpsum.getInstance().getName());
        p1.setDescription(LoremIpsum.getInstance().getWords(2, 10));
        p1.setImgPath("/img/img-01.png");

        Product p2 = new Product();
        p2.setName(LoremIpsum.getInstance().getName());
        p2.setDescription(LoremIpsum.getInstance().getWords(4, 6));
        p2.setImgPath("/img/img-03.png");

        Product p3 = new Product();
        p3.setName(LoremIpsum.getInstance().getName());
        p3.setDescription(LoremIpsum.getInstance().getWords(1, 5));
        p3.setImgPath("/img/img-03.png");

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        /*Set<TmpCategory> categories = new HashSet<>();
        TmpCategory c1 = new TmpCategory();
        c1.setName(LoremIpsum.getInstance().getWords(1));

        TmpCategory c2 = new TmpCategory();
        c2.setName(LoremIpsum.getInstance().getWords(1));
        categories.add(c1);
        categories.add(c2);

        tmpCategoryRepository.saveAll(categories);

        TmpProduct p1 = new TmpProduct();
        p1.setName("Piros labda");
        p1.setImgPath("/img/red-ball");
        p1.setDescription(LoremIpsum.getInstance().getWords(2, 7));
        p1.setCategories(categories);

        TmpProduct p2 = new TmpProduct();
        p2.setName("Table");
        p2.setImgPath("/img/table");
        p2.setDescription(LoremIpsum.getInstance().getWords(2, 7));
        p2.setCategories(new HashSet<TmpCategory>(){{add(c2);}});

        TmpProduct p3 = new TmpProduct();
        p3.setName("Big shoe");
        p3.setImgPath("/img/shoe");
        p3.setDescription(LoremIpsum.getInstance().getWords(2, 7));



        tmpProductRepository.save(p1);
        tmpProductRepository.save(p2);
        tmpProductRepository.save(p3);*/
    }
}
