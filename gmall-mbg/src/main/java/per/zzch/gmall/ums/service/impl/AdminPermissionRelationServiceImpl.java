package per.zzch.gmall.ums.service.impl;

import per.zzch.gmall.ums.entity.AdminPermissionRelation;
import per.zzch.gmall.ums.mapper.AdminPermissionRelationMapper;
import per.zzch.gmall.ums.service.AdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper, AdminPermissionRelation> implements AdminPermissionRelationService {

}
