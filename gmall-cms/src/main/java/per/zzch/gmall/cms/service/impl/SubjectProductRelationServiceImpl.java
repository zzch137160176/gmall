package per.zzch.gmall.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.zzch.gmall.cms.entity.SubjectProductRelation;
import per.zzch.gmall.cms.mapper.SubjectProductRelationMapper;
import per.zzch.gmall.cms.service.SubjectProductRelationService;

import java.util.List;

/**
 * <p>
 * 专题商品关系表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class SubjectProductRelationServiceImpl extends ServiceImpl<SubjectProductRelationMapper, SubjectProductRelation> implements SubjectProductRelationService {

    @Autowired
    SubjectProductRelationMapper subjectProductRelationMapper;

    @Override
    public List<SubjectProductRelation> listByProductId(Long id) {
        return subjectProductRelationMapper.selectList(new QueryWrapper<SubjectProductRelation>().eq("product_id", id));
    }
}
