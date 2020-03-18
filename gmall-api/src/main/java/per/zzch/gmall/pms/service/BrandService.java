package per.zzch.gmall.pms.service;

import per.zzch.gmall.pms.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.vo.PageInfoVo;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface BrandService extends IService<Brand> {

    /**
     * 返回品牌分页数据
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
