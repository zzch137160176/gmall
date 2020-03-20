package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import per.zzch.gmall.pms.entity.Brand;
import per.zzch.gmall.pms.mapper.BrandMapper;
import per.zzch.gmall.pms.service.BrandService;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsBrandParam;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
@Component
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        QueryWrapper<Brand> name = null;
        if (!StringUtils.isEmpty(keyword)) {
            name = new QueryWrapper<Brand>().like("name", keyword);
        }

        IPage<Brand> page = brandMapper.selectPage(new Page<Brand>(pageNum.longValue(), pageSize.longValue()), name);

        return new PageInfoVo(page.getTotal(), page.getPages(), pageSize.longValue(), page.getRecords(), pageNum.longValue());

    }

    @Override
    public boolean createBrand(PmsBrandParam pmsBrandParam) {

        Brand brand = new Brand();

        brand.setName(pmsBrandParam.getName());
        brand.setBigPic(pmsBrandParam.getBigPic());
        brand.setBrandStory(pmsBrandParam.getBrandStory());
        brand.setFactoryStatus(pmsBrandParam.getFactoryStatus());
        brand.setFirstLetter(pmsBrandParam.getFirstLetter());
        brand.setLogo(pmsBrandParam.getLogo());
        brand.setShowStatus(pmsBrandParam.getShowStatus());
        brand.setSort(pmsBrandParam.getSort());

        int insert = brandMapper.insert(brand);

        return insert > 0;
    }

    @Override
    public boolean updateShowStatus(List<Long> ids, Integer showStatus) {

        int update = brandMapper.updateShowStatus(ids, showStatus);

        return update > 0;
    }

    @Override
    public boolean updateFactoryStatus(List<Long> ids, Integer factoryStatus) {

        int update = brandMapper.updateFactoryStatus(ids, factoryStatus);

        return update > 0;
    }

    @Override
    public boolean updateBrand(Long id, PmsBrandParam pmsBrandParam) {

        Brand brand = brandMapper.selectById(id);

        brand.setName(pmsBrandParam.getName());
        brand.setBigPic(pmsBrandParam.getBigPic());
        brand.setBrandStory(pmsBrandParam.getBrandStory());
        brand.setFactoryStatus(pmsBrandParam.getFactoryStatus());
        brand.setFirstLetter(pmsBrandParam.getFirstLetter());
        brand.setLogo(pmsBrandParam.getLogo());
        brand.setShowStatus(pmsBrandParam.getShowStatus());
        brand.setSort(pmsBrandParam.getSort());

        int update = brandMapper.updateById(brand);

        return update > 0;
    }
}
