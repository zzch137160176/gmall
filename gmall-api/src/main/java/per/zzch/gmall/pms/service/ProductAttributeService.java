package per.zzch.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.pms.entity.ProductAttribute;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeParam;
import per.zzch.gmall.vo.product.ProductAttrInfo;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductAttributeService extends IService<ProductAttribute> {

    /**
     * 根据分类查询属性列表或参数列表
     *
     * @param cid
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageInfoVo productAttributePageInfo(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 添加商品属性信息
     *
     * @param productAttributeParam
     * @return
     */
    boolean createProductAttribute(PmsProductAttributeParam productAttributeParam);

    /**
     * 修改商品属性信息
     *
     * @param id
     * @param productAttributeParam
     * @return
     */
    boolean updateProductAttribute(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * 根据商品分类的id获取商品属性及属性分类
     *
     * @param productCategoryId
     * @return
     */
    ProductAttrInfo selectAttrInfo(Long productCategoryId);
}
