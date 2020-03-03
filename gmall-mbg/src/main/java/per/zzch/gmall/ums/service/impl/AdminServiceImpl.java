package per.zzch.gmall.ums.service.impl;

import per.zzch.gmall.ums.entity.Admin;
import per.zzch.gmall.ums.mapper.AdminMapper;
import per.zzch.gmall.ums.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
