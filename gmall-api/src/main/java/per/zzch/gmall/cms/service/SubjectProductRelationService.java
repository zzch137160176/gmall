package per.zzch.gmall.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.cms.entity.SubjectProductRelation;

import java.util.List;

/**
 * <p>
 * 专题商品关系表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface SubjectProductRelationService extends IService<SubjectProductRelation> {

    /**
     * 根据产品id获取关系
     *
     * @param id
     * @return
     */
    List<SubjectProductRelation> listByProductId(Long id);
}
