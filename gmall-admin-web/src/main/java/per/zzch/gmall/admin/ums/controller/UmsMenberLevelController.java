package per.zzch.gmall.admin.ums.controller;

import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.ums.entity.MemberLevel;
import per.zzch.gmall.ums.service.MemberLevelService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/memberLevel")
@Api(tags = "UmsMenberLevelController")
public class UmsMenberLevelController {

    @Reference
    MemberLevelService service;

    /**
     * 查出所有会员等级
     * @return
     */
    @GetMapping(value = "/list")
    public Object memberLevelList() {
        List<MemberLevel> list = service.list();
        return new CommonResult().success(list);
    }

}
