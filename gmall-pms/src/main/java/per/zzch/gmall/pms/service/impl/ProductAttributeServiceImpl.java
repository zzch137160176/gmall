package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.zzch.gmall.pms.entity.ProductAttribute;
import per.zzch.gmall.pms.mapper.ProductAttributeMapper;
import per.zzch.gmall.pms.service.ProductAttributeService;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeParam;
import per.zzch.gmall.vo.product.ProductAttrInfo;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {

    @Autowired
    ProductAttributeMapper mapper;

    @Override
    public PageInfoVo productAttributePageInfo(Long cid, Integer type, Integer pageSize, Integer pageNum) {

        QueryWrapper<ProductAttribute> wrapper = new QueryWrapper<ProductAttribute>().eq("product_attribute_category_id", cid).eq("type", type);

        Page<ProductAttribute> page = mapper.selectPage(new Page<>(pageNum.longValue(), pageSize.longValue()), wrapper);

        return new PageInfoVo(page.getTotal(), page.getPages(), pageSize.longValue(), page.getRecords(), pageNum.longValue());

    }

    @Override
    public boolean createProductAttribute(PmsProductAttributeParam productAttributeParam) {

        ProductAttribute productAttribute = new ProductAttribute();

        productAttribute.setFilterType(productAttributeParam.getFilterType());
        productAttribute.setHandAddStatus(productAttributeParam.getHandAddStatus());
        productAttribute.setInputList(productAttributeParam.getInputList());
        productAttribute.setInputType(productAttributeParam.getInputType());
        productAttribute.setName(productAttributeParam.getName());
        productAttribute.setProductAttributeCategoryId(productAttributeParam.getProductAttributeCategoryId());
        productAttribute.setRelatedStatus(productAttributeParam.getRelatedStatus());
        productAttribute.setSearchType(productAttributeParam.getSearchType());
        productAttribute.setSelectType(productAttributeParam.getSelectType());
        productAttribute.setSort(productAttributeParam.getSort());
        productAttribute.setType(productAttributeParam.getType());

        return mapper.insert(productAttribute) > 0;
    }

    @Override
    public boolean updateProductAttribute(Long id, PmsProductAttributeParam productAttributeParam) {

        ProductAttribute productAttribute = mapper.selectById(id);

        if (productAttribute == null) {
            return false;
        }

        productAttribute.setFilterType(productAttributeParam.getFilterType());
        productAttribute.setHandAddStatus(productAttributeParam.getHandAddStatus());
        productAttribute.setInputList(productAttributeParam.getInputList());
        productAttribute.setInputType(productAttributeParam.getInputType());
        productAttribute.setName(productAttributeParam.getName());
        productAttribute.setProductAttributeCategoryId(productAttributeParam.getProductAttributeCategoryId());
        productAttribute.setRelatedStatus(productAttributeParam.getRelatedStatus());
        productAttribute.setSearchType(productAttributeParam.getSearchType());
        productAttribute.setSelectType(productAttributeParam.getSelectType());
        productAttribute.setSort(productAttributeParam.getSort());
        productAttribute.setType(productAttributeParam.getType());

        return mapper.updateById(productAttribute) > 0;
    }

    @Override
    public ProductAttrInfo selectAttrInfo(Long productCategoryId) {

        return mapper.selectAttrInfo(productCategoryId);

    }
}
