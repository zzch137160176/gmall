package per.zzch.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.pms.entity.Product;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductParam;
import per.zzch.gmall.vo.product.PmsProductQueryParam;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface ProductService extends IService<Product> {

    /**
     * 根据复杂查询条件返回分页数据
     *
     * @param productQueryParam
     * @return
     */
    PageInfoVo productPageInfo(PmsProductQueryParam productQueryParam);

    /**
     * 根据商品id获取商品编辑信息
     *
     * @param id
     * @return
     */
    PmsProductParam getUpdateInfoById(Long id);

    /**
     * 创建商品
     *
     * @param productParam
     * @return
     */
    boolean createProduct(PmsProductParam productParam);

    /**
     * 更新商品
     *
     * @param id
     * @param productParam
     * @return
     */
    boolean updateProduct(Long id, PmsProductParam productParam);

    /**
     * 根据商品名称或货号模糊查询
     *
     * @param keyword
     * @return
     */
    List<Product> getByKeyword(String keyword);

    /**
     * 批量修改审核状态
     *
     * @param ids
     * @param verifyStatus
     * @param detail
     * @return
     */
    boolean updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量设为新品
     *
     * @param ids
     * @param newStatus
     * @return
     */
    boolean updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量修改删除状态
     *
     * @param ids
     * @param deleteStatus
     * @return
     */
    boolean updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 批量推荐商品
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    boolean updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量上下架
     *
     * @param ids
     * @param publishStatus
     * @return
     */
    boolean updatePublishStatus(List<Long> ids, Integer publishStatus);
}
