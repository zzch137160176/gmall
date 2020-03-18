package per.zzch.gmall.ums.service;

import per.zzch.gmall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import per.zzch.gmall.vo.product.UmsAdminParam;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
public interface AdminService extends IService<Admin> {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Admin login(String username, String password);

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    Admin getUserInfo(String userName);

    /**
     * 用户注册
     * @param umsAdminParam
     * @return
     */
    Admin register(UmsAdminParam umsAdminParam);
}
