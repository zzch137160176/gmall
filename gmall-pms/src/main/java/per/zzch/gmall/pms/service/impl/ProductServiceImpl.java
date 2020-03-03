package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import per.zzch.gmall.pms.entity.Product;
import per.zzch.gmall.pms.mapper.ProductMapper;
import per.zzch.gmall.pms.service.ProductService;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
