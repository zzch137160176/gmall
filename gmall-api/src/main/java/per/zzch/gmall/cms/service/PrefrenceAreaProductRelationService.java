package per.zzch.gmall.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.cms.entity.PrefrenceAreaProductRelation;

import java.util.List;

/**
 * <p>
 * 优选专区和产品关系表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface PrefrenceAreaProductRelationService extends IService<PrefrenceAreaProductRelation> {

    /**
     * 根据产品id获取关系
     *
     * @param id
     * @return
     */
    List<PrefrenceAreaProductRelation> listByProductId(Long id);
}
