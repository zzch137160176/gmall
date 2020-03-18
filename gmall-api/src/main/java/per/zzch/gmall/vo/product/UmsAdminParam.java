package per.zzch.gmall.vo.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 用户登录参数
 * Created by atguigu 4/26.
 */
@Getter
@Setter
public class UmsAdminParam implements Serializable {

    @ApiModelProperty(value = "用户名", required = true)
    @Length(min = 6, max = 18, message = "用户名长度为 6-18 位")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @Length(min = 6, max = 18, message = "密码长度为 6-18 位")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式不合法")
    private String email;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "备注")
    private String note;
}
