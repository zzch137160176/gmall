package per.zzch.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.pms.entity.ProductCategory;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductCategoryParam;
import per.zzch.gmall.vo.product.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    /**
     * 分页查询产品分类信息
     *
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageInfoVo categoryPageInfo(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 查询所有分类
     *
     * @param id
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listCatelogWithChildren(Integer id);


    /**
     * 添加产品分类
     *
     * @param productCategoryParam
     * @return
     */
    ProductCategory createProductCategory(PmsProductCategoryParam productCategoryParam);

    /**
     * 批量更新导航栏显示状态
     *
     * @param ids
     * @param navStatus
     * @return
     */
    Boolean updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量更新显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    Boolean updateShowStatus(List<Long> ids, Integer showStatus);
}
