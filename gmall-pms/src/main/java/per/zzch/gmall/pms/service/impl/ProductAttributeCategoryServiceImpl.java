package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.zzch.gmall.pms.entity.ProductAttributeCategory;
import per.zzch.gmall.pms.mapper.ProductAttributeCategoryMapper;
import per.zzch.gmall.pms.service.ProductAttributeCategoryService;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements ProductAttributeCategoryService {

    @Autowired
    ProductAttributeCategoryMapper mapper;

    @Override
    public PageInfoVo attributeCategoryPageInfo(Integer pageSize, Integer pageNum) {

        IPage<ProductAttributeCategory> iPage = mapper.selectPage(new Page<>(pageNum.longValue(), pageSize.longValue()), null);

        return new PageInfoVo(iPage.getTotal(), iPage.getPages(), pageSize.longValue(), iPage.getRecords(), pageNum.longValue());

    }

    @Override
    public List<PmsProductAttributeCategoryItem> listAttributeCategoryWithAttr() {

        return mapper.listAttributeCategoryWithAttr();

    }

    @Override
    public Integer updateAttributeCategory(Long id, String name) {

        ProductAttributeCategory productAttributeCategory = mapper.selectById(id);

        productAttributeCategory.setName(name);

        return mapper.updateById(productAttributeCategory);
    }
}
