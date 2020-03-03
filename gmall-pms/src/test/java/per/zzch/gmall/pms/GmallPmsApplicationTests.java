package per.zzch.gmall.pms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.zzch.gmall.pms.entity.Brand;
import per.zzch.gmall.pms.entity.Product;
import per.zzch.gmall.pms.service.BrandService;
import per.zzch.gmall.pms.service.ProductService;

@SpringBootTest
class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {

//        Product product = productService.getById(1);
//        System.out.println(product.getName());

//        Brand brand = new Brand();
//        brand.setName("哈哈哈");
//        brandService.save(brand);
//        System.out.println("保存成功");

        Brand brand = brandService.getById(52);
        System.out.println(brand.getName());
    }

}
