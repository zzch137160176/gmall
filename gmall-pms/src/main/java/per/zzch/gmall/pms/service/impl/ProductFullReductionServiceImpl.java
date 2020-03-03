package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.pms.entity.ProductFullReduction;
import per.zzch.gmall.pms.mapper.ProductFullReductionMapper;
import per.zzch.gmall.pms.service.ProductFullReductionService;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class ProductFullReductionServiceImpl extends ServiceImpl<ProductFullReductionMapper, ProductFullReduction> implements ProductFullReductionService {

}
