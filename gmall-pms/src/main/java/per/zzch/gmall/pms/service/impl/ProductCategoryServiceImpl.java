package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import per.zzch.gmall.constant.SysCacheConstant;
import per.zzch.gmall.pms.entity.ProductCategory;
import per.zzch.gmall.pms.mapper.ProductCategoryMapper;
import per.zzch.gmall.pms.service.ProductCategoryService;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductCategoryParam;
import per.zzch.gmall.vo.product.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
@Component
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper categoryMapper;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public PageInfoVo categoryPageInfo(Long parentId, Integer pageSize, Integer pageNum) {

        QueryWrapper<ProductCategory> wapper = new QueryWrapper<>();

        if (parentId != null) {
            wapper.eq("parent_id", parentId);
        }

        IPage<ProductCategory> iPage = categoryMapper.selectPage(new Page<>(pageNum.longValue(), pageSize.longValue()), wapper);

        return new PageInfoVo(iPage.getTotal(), iPage.getPages(), pageSize.longValue(), iPage.getRecords(), pageNum.longValue());
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChildren(Integer id) {

        List<PmsProductCategoryWithChildrenItem> items = null;

        Object cacheMenu = redisTemplate.opsForValue().get(SysCacheConstant.CATEGORY_MENU_CACHE_KEY);
        // 加入缓存逻辑
        if (cacheMenu != null) {
            items = (List<PmsProductCategoryWithChildrenItem>) cacheMenu;
        } else {
            items = categoryMapper.listCatelogWithChildren(id);
            // 放在缓存中，redis
            redisTemplate.opsForValue().set(SysCacheConstant.CATEGORY_MENU_CACHE_KEY, items);
        }
        return items;
    }

    @Override
    public ProductCategory createProductCategory(PmsProductCategoryParam productCategoryParam) {

        ProductCategory productCategory = new ProductCategory();

        productCategory.setDescription(productCategoryParam.getDescription());
        productCategory.setIcon(productCategoryParam.getIcon());
        productCategory.setKeywords(productCategoryParam.getKeywords());
        productCategory.setName(productCategoryParam.getName());
        productCategory.setNavStatus(productCategoryParam.getNavStatus());
        productCategory.setParentId(productCategoryParam.getParentId());
        productCategory.setProductUnit(productCategoryParam.getProductUnit());
        productCategory.setSort(productCategoryParam.getSort());
        productCategory.setShowStatus(productCategoryParam.getShowStatus());

        List<Long> productAttributeIdList = productCategoryParam.getProductAttributeIdList();
        // TODO 添加分类，attribute 未解决

        return null;
    }

    @Override
    public Boolean updateNavStatus(List<Long> ids, Integer navStatus) {

        Integer result = categoryMapper.updateNavStatus(ids, navStatus);

        return result > 0;
    }

    @Override
    public Boolean updateShowStatus(List<Long> ids, Integer showStatus) {

        Integer result = categoryMapper.updateShowStatus(ids, showStatus);

        return result > 0;
    }
}
