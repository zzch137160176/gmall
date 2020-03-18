package per.zzch.gmall.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.zzch.gmall.pms.entity.ProductCategory;
import per.zzch.gmall.vo.product.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listCatelogWithChildren(Integer id);

    Integer updateNavStatus(List<Long> ids, Integer navStatus);

    Integer updateShowStatus(List<Long> ids, Integer showStatus);
}
