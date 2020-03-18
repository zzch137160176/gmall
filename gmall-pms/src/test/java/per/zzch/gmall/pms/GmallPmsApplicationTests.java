package per.zzch.gmall.pms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import per.zzch.gmall.pms.entity.Brand;
import per.zzch.gmall.pms.service.BrandService;
import per.zzch.gmall.pms.service.ProductService;

@SpringBootTest
class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

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

    /**
     * redis测试
     */
    @Test
    void redisTest() {
        // redis中存对象，默认是序列化的流
        stringRedisTemplate.opsForValue().set("hello", "word");
        System.out.println("存值成功");
        String str = stringRedisTemplate.opsForValue().get("hello");
        System.out.println("保存的值为: " + str);
    }

    @Test
    void redisObjectTest() {
        Brand brand = new Brand();
        brand.setName("八点上发文");
        redisTemplate.opsForValue().set("brand", brand);
    }
}
