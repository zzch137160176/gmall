package per.zzch.gmall.pms.service.impl;

import per.zzch.gmall.pms.entity.Product;
import per.zzch.gmall.pms.mapper.ProductMapper;
import per.zzch.gmall.pms.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
