package per.zzch.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.pms.entity.ProductAttributeCategory;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    /**
     * 分页获取所有商品属性分类
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageInfoVo attributeCategoryPageInfo(Integer pageSize, Integer pageNum);

    /**
     * 获取所有商品属性分类及其下属性
     *
     * @return
     */
    List<PmsProductAttributeCategoryItem> listAttributeCategoryWithAttr();

    /**
     * 更新属性分类
     *
     * @param id
     * @param name
     * @return
     */
    Integer updateAttributeCategory(Long id, String name);
}
