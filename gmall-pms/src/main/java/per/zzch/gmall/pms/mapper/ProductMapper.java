package per.zzch.gmall.pms.mapper;

import per.zzch.gmall.pms.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.zzch.gmall.vo.product.PmsProductParam;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductMapper extends BaseMapper<Product> {

    PmsProductParam selectPmsProductParamById(Long id);
}
