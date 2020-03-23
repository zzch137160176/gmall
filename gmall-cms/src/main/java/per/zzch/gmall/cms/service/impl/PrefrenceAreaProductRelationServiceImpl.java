package per.zzch.gmall.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.zzch.gmall.cms.entity.PrefrenceAreaProductRelation;
import per.zzch.gmall.cms.mapper.PrefrenceAreaProductRelationMapper;
import per.zzch.gmall.cms.service.PrefrenceAreaProductRelationService;

import java.util.List;

/**
 * <p>
 * 优选专区和产品关系表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class PrefrenceAreaProductRelationServiceImpl extends ServiceImpl<PrefrenceAreaProductRelationMapper, PrefrenceAreaProductRelation> implements PrefrenceAreaProductRelationService {

    @Autowired
    PrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;

    @Override
    public List<PrefrenceAreaProductRelation> listByProductId(Long id) {
        return prefrenceAreaProductRelationMapper.selectList(new QueryWrapper<PrefrenceAreaProductRelation>().eq("product_id", id));
    }
}
