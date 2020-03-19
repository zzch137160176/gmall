package per.zzch.gmall.pms.mapper;

import per.zzch.gmall.pms.entity.ProductAttribute;
import per.zzch.gmall.pms.entity.ProductAttributeCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.zzch.gmall.vo.product.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 Mapper 接口
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductAttributeCategoryMapper extends BaseMapper<ProductAttributeCategory> {

    List<PmsProductAttributeCategoryItem> listAttributeCategoryWithAttr();

    List<ProductAttribute> listAttr(Integer id);
}
