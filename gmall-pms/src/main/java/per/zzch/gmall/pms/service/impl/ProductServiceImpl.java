package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import per.zzch.gmall.cms.entity.PrefrenceAreaProductRelation;
import per.zzch.gmall.cms.entity.SubjectProductRelation;
import per.zzch.gmall.cms.service.PrefrenceAreaProductRelationService;
import per.zzch.gmall.cms.service.SubjectProductRelationService;
import per.zzch.gmall.pms.entity.*;
import per.zzch.gmall.pms.mapper.*;
import per.zzch.gmall.pms.service.ProductService;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductParam;
import per.zzch.gmall.vo.product.PmsProductQueryParam;

import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductFullReductionMapper productFullReductionMapper;

    @Autowired
    MemberPriceMapper memberPriceMapper;

    @Autowired
    SkuStockMapper skuStockMapper;

    @Autowired
    ProductAttributeValueMapper productAttributeValueMapper;

    @Autowired
    ProductLadderMapper productLadderMapper;


    @Override
    public PageInfoVo productPageInfo(PmsProductQueryParam param) {

        QueryWrapper<Product> wrapper = new QueryWrapper<>();

        if (param.getBrandId() != null) {
            wrapper.eq("brand_id", param.getBrandId());
        }

        if (!StringUtils.isEmpty(param.getKeyword())) {
            wrapper.like("name", param.getKeyword());
        }

        if (param.getProductCategoryId() != null) {
            wrapper.eq("product_category_id", param.getProductCategoryId());
        }

        if (!StringUtils.isEmpty(param.getProductSn())) {
            wrapper.like("product_sn", param.getProductSn());
        }

        if (param.getPublishStatus() != null) {
            wrapper.eq("publish_status", param.getPublishStatus());
        }

        if (param.getVerifyStatus() != null) {
            wrapper.eq("verify_status", param.getVerifyStatus());
        }

        IPage<Product> page = productMapper.selectPage(new Page<Product>(param.getPageNum(), param.getPageSize()), wrapper);

        return new PageInfoVo(page.getTotal(), page.getPages(), param.getPageSize(), page.getRecords(), page.getCurrent());

    }

    @Override
    public PmsProductParam getUpdateInfoById(Long id) {

        PmsProductParam param = productMapper.selectPmsProductParamById(id);

        List<ProductFullReduction> fullReductions = productFullReductionMapper.selectList(new QueryWrapper<ProductFullReduction>().eq("product_id", id));
        List<MemberPrice> memberPrices = memberPriceMapper.selectList(new QueryWrapper<MemberPrice>().eq("product_id", id));
        List<SkuStock> skuStocks = skuStockMapper.selectList(new QueryWrapper<SkuStock>().eq("product_id", id));
        List<ProductAttributeValue> attributeValues = productAttributeValueMapper.selectList(new QueryWrapper<ProductAttributeValue>().eq("product_id", id));
        List<ProductLadder> ladders = productLadderMapper.selectList(new QueryWrapper<ProductLadder>().eq("product_id", id));

        param.setMemberPriceList(memberPrices);
        param.setProductFullReductionList(fullReductions);
        param.setProductAttributeValueList(attributeValues);
        param.setSkuStockList(skuStocks);
        param.setProductLadderList(ladders);

        return param;
    }

    @Override
    public boolean createProduct(PmsProductParam productParam) {
        return false;
    }

    @Override
    public boolean updateProduct(Long id, PmsProductParam productParam) {
        return false;
    }

    @Override
    public List<Product> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public boolean updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return false;
    }

    @Override
    public boolean updateNewStatus(List<Long> ids, Integer newStatus) {
        return false;
    }

    @Override
    public boolean updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return false;
    }

    @Override
    public boolean updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return false;
    }

    @Override
    public boolean updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return false;
    }
}
