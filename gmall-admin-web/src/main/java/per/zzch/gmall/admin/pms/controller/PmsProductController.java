package per.zzch.gmall.admin.pms.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import per.zzch.gmall.cms.entity.PrefrenceAreaProductRelation;
import per.zzch.gmall.cms.entity.SubjectProductRelation;
import per.zzch.gmall.cms.service.PrefrenceAreaProductRelationService;
import per.zzch.gmall.cms.service.SubjectProductRelationService;
import per.zzch.gmall.pms.entity.Product;
import per.zzch.gmall.pms.service.ProductService;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductParam;
import per.zzch.gmall.vo.product.PmsProductQueryParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品管理Controller
 */
@CrossOrigin    // 跨域
@RestController
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {

    @Reference
    private ProductService productService;

    @Reference
    private SubjectProductRelationService subjectProductRelationService;

    @Reference
    private PrefrenceAreaProductRelationService prefrenceAreaProductRelationService;

    @ApiOperation("创建商品")
    @PostMapping(value = "/create")
    public Object create(@Valid @RequestBody PmsProductParam productParam,
                         BindingResult bindingResult) {

        boolean result = productService.createProduct(productParam);

        return new CommonResult().success(result);
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @GetMapping(value = "/updateInfo/{id}")
    public Object getUpdateInfo(@PathVariable Long id) {

        PmsProductParam param = productService.getUpdateInfoById(id);

        List<SubjectProductRelation> subjectProductRelations = subjectProductRelationService.listByProductId(id);

        List<PrefrenceAreaProductRelation> prefrenceAreaProductRelations = prefrenceAreaProductRelationService.listByProductId(id);

        param.setSubjectProductRelationList(subjectProductRelations);
        param.setPrefrenceAreaProductRelationList(prefrenceAreaProductRelations);

        return new CommonResult().success(param);
    }

    @ApiOperation("更新商品")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {

        boolean result = productService.updateProduct(id, productParam);

        return new CommonResult().success(result);
    }

    @ApiOperation("查询商品")
    @GetMapping(value = "/list")
    public Object getList(PmsProductQueryParam productQueryParam,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        PageInfoVo pageInfoVo = productService.productPageInfo(productQueryParam);

        return new CommonResult().success(pageInfoVo);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @GetMapping(value = "/simpleList")
    public Object getList(String keyword) {
        //TODO 根据商品名称或货号模糊查询

        List<Product> products = productService.getByKeyword(keyword);

        return new CommonResult().success(products);
    }

    @ApiOperation("批量修改审核状态")
    @PostMapping(value = "/update/verifyStatus")
    public Object updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("verifyStatus") Integer verifyStatus,
                                     @RequestParam("detail") String detail) {

        boolean result = productService.updateVerifyStatus(ids, verifyStatus, detail);

        return new CommonResult().success(result);
    }

    @ApiOperation("批量上下架")
    @PostMapping(value = "/update/publishStatus")
    public Object updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("publishStatus") Integer publishStatus) {

        boolean result = productService.updatePublishStatus(ids, publishStatus);

        return new CommonResult().success(result);
    }

    @ApiOperation("批量推荐商品")
    @PostMapping(value = "/update/recommendStatus")
    public Object updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("recommendStatus") Integer recommendStatus) {

        boolean result = productService.updateRecommendStatus(ids, recommendStatus);

        return new CommonResult().success(result);
    }

    @ApiOperation("批量设为新品")
    @PostMapping(value = "/update/newStatus")
    public Object updateNewStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("newStatus") Integer newStatus) {

        boolean result = productService.updateNewStatus(ids, newStatus);

        return new CommonResult().success(result);
    }

    @ApiOperation("批量修改删除状态")
    @PostMapping(value = "/update/deleteStatus")
    public Object updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("deleteStatus") Integer deleteStatus) {

        boolean result = productService.updateDeleteStatus(ids, deleteStatus);

        return new CommonResult().success(result);
    }
}
