package per.zzch.gmall.pms.mapper;

import per.zzch.gmall.pms.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface BrandMapper extends BaseMapper<Brand> {

    int updateShowStatus(List<Long> ids, Integer showStatus);

    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
