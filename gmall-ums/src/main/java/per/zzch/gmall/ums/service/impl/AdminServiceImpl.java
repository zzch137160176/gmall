package per.zzch.gmall.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import per.zzch.gmall.ums.entity.Admin;
import per.zzch.gmall.ums.mapper.AdminMapper;
import per.zzch.gmall.ums.service.AdminService;
import per.zzch.gmall.vo.product.UmsAdminParam;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>().eq("username", username).eq("password", md5Password);

        return adminMapper.selectOne(wrapper);

    }

    @Override
    public Admin getUserInfo(String userName) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", userName));
    }

    @Override
    public Admin register(UmsAdminParam umsAdminParam) {

        if (adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", umsAdminParam.getUsername())) != null) {
            return null;
        }

        Admin admin = new Admin();

        admin.setUsername(umsAdminParam.getUsername());
        admin.setNickName(umsAdminParam.getNickName());
        admin.setEmail(umsAdminParam.getEmail());
        admin.setIcon(umsAdminParam.getIcon());
        admin.setNote(umsAdminParam.getNote());
        admin.setPassword(umsAdminParam.getPassword());

        adminMapper.insert(admin);

        return admin;
    }
}
