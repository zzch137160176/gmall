package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.pms.entity.ProductCategoryAttributeRelation;
import per.zzch.gmall.pms.mapper.ProductCategoryAttributeRelationMapper;
import per.zzch.gmall.pms.service.ProductCategoryAttributeRelationService;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class ProductCategoryAttributeRelationServiceImpl extends ServiceImpl<ProductCategoryAttributeRelationMapper, ProductCategoryAttributeRelation> implements ProductCategoryAttributeRelationService {

}
