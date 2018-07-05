package com.phoenixcontact.prototype.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = LoggerFactory.getLogger(SpringJpaBootstrap.class);

//    private ProductRepository productRepository;
//
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadData();
    }
    
    private void loadData() {
    }
    
//    private void loadProducts() {
//    	long cnt = productRepository.count();
//    	if (cnt > 0) {
//    		return;
//    	}
//    	
//        Product shirt = new Product();
//        shirt.setDescription("Spring Framework Guru Shirt");
//        shirt.setPrice(new BigDecimal("18.95"));
//        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
//        shirt.setProductId("23526884");
//        productRepository.save(shirt);
//
//        log.info("Saved Shirt - id: " + shirt.getId());
//
//        Product mug = new Product();
//        mug.setDescription("Spring Framework Guru Mug");
//        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
//        mug.setProductId("16863939");
//        mug.setPrice(new BigDecimal("11.95"));
//        productRepository.save(mug);
//
//        log.info("Saved Mug - id:" + mug.getId());
//    }


}



