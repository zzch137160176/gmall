package per.zzch.gmall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.ums.entity.Permission;
import per.zzch.gmall.ums.mapper.PermissionMapper;
import per.zzch.gmall.ums.service.PermissionService;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
