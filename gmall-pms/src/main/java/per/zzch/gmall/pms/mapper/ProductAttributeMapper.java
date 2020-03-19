package per.zzch.gmall.pms.mapper;

import per.zzch.gmall.pms.entity.ProductAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.zzch.gmall.vo.product.ProductAttrInfo;

/**
 * <p>
 * 商品属性参数表 Mapper 接口
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {

    ProductAttrInfo selectAttrInfo(Long productCategoryId);
}
