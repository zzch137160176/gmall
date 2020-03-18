package per.zzch.gmall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import per.zzch.gmall.ums.entity.MemberLevel;
import per.zzch.gmall.ums.mapper.MemberLevelMapper;
import per.zzch.gmall.ums.service.MemberLevelService;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {

}
