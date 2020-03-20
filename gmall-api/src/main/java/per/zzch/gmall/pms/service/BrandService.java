package per.zzch.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.pms.entity.Brand;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsBrandParam;

import java.util.List;

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
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 添加品牌
     *
     * @param pmsBrandParam
     * @return
     */
    boolean createBrand(PmsBrandParam pmsBrandParam);

    /**
     * 批量更新显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    boolean updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 批量更新厂家制造商状态
     *
     * @param ids
     * @param factoryStatus
     * @return
     */
    boolean updateFactoryStatus(List<Long> ids, Integer factoryStatus);

    /**
     * 更新品牌
     *
     * @param id
     * @param pmsBrandParam
     * @return
     */
    boolean updateBrand(Long id, PmsBrandParam pmsBrandParam);
}
