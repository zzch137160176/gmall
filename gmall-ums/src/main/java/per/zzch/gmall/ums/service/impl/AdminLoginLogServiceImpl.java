package per.zzch.gmall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.ums.entity.AdminLoginLog;
import per.zzch.gmall.ums.mapper.AdminLoginLogMapper;
import per.zzch.gmall.ums.service.AdminLoginLogService;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements AdminLoginLogService {

}
