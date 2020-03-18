package per.zzch.gmall.admin.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import per.zzch.gmall.pms.entity.ProductCategory;
import per.zzch.gmall.pms.service.ProductCategoryService;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductCategoryParam;
import per.zzch.gmall.vo.product.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类模块Controller
 */
@CrossOrigin
@RestController
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Reference
    private ProductCategoryService productCategoryService;

    @ApiOperation("添加产品分类")
    @PostMapping(value = "/create")
    public Object create(@Validated @RequestBody PmsProductCategoryParam productCategoryParam,
                         BindingResult result) {

        ProductCategory productCategory = productCategoryService.createProductCategory(productCategoryParam);

        return new CommonResult().success(productCategory);
    }

    @ApiOperation("修改商品分类")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable Long id,
                         @Validated
                         @RequestBody PmsProductCategoryParam productCategoryParam,
                         BindingResult result) {
        //TODO 修改商品分类
        return new CommonResult().success(null);
    }

    @ApiOperation("分页查询商品分类")
    @GetMapping(value = "/list/{parentId}")
    public Object getList(@PathVariable Long parentId,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        PageInfoVo pageInfoVo = productCategoryService.categoryPageInfo(parentId, pageSize, pageNum);

        return new CommonResult().success(pageInfoVo);
    }

    @ApiOperation("根据id获取商品分类")
    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable Long id) {

        ProductCategory productCategory = productCategoryService.getById(id);

        return new CommonResult().success(productCategory);
    }

    @ApiOperation("删除商品分类")
    @PostMapping(value = "/delete/{id}")
    public Object delete(@PathVariable Long id) {

        boolean result = productCategoryService.removeById(id);

        return new CommonResult().success(result);
    }

    @ApiOperation("修改导航栏显示状态")
    @PostMapping(value = "/update/navStatus")
    public Object updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus) {

        Boolean result = productCategoryService.updateNavStatus(ids, navStatus);

        return new CommonResult().success(result);
    }

    @ApiOperation("修改显示状态")
    @PostMapping(value = "/update/showStatus")
    public Object updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {

        Boolean result = productCategoryService.updateShowStatus(ids, showStatus);

        return new CommonResult().success(result);
    }

    @ApiOperation("查询所有一级分类及子分类[有难度]")
    @GetMapping(value = "/list/withChildren")
    public Object listWithChildren() {

        List<PmsProductCategoryWithChildrenItem> items = productCategoryService.listCatelogWithChildren(0);

        return new CommonResult().success(items);
    }
}
