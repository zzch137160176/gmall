package per.zzch.gmall.admin.oms.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.zzch.gmall.admin.oms.compent.OssCompent;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.to.OssPolicyResult;

/**
 * Oss相关操作接口
 */
//@CrossOrigin
//@RestController
//@Api(tags = "OssController", description = "Oss管理")
//@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssCompent ossCompent;

    @ApiOperation(value = "oss上传签名生成")
    @GetMapping(value = "/policy")
    public Object policy() {
        OssPolicyResult result = ossCompent.policy();
        return new CommonResult().success(result);
    }

}
