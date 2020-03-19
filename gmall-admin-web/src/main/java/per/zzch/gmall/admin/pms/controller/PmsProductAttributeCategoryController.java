package per.zzch.gmall.admin.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import per.zzch.gmall.pms.entity.ProductAttributeCategory;
import per.zzch.gmall.pms.service.ProductAttributeCategoryService;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 商品属性分类Controller
 * Created by atguigu 4/26.
 */
@CrossOrigin
@RestController
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Reference
    private ProductAttributeCategoryService productAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @PostMapping(value = "/create")
    public Object create(@RequestParam String name) {

        ProductAttributeCategory productAttributeCategory = new ProductAttributeCategory();

        productAttributeCategory.setName(name);

        boolean result = productAttributeCategoryService.save(productAttributeCategory);

        return new CommonResult().success(result);
    }

    @ApiOperation("修改商品属性分类")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable Long id, @RequestParam String name) {

        Integer result = productAttributeCategoryService.updateAttributeCategory(id, name);

        return new CommonResult().success(result > 0);
    }

    @ApiOperation("删除单个商品属性分类")
    @GetMapping(value = "/delete/{id}")
    public Object delete(@PathVariable Long id) {

        boolean result = productAttributeCategoryService.removeById(id);

        return new CommonResult().success(result);

    }

    @ApiOperation("获取单个商品属性分类信息")
    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable Long id) {

        ProductAttributeCategory productAttributeCategory = productAttributeCategoryService.getById(id);

        return new CommonResult().success(productAttributeCategory);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {

        PageInfoVo pageInfo = productAttributeCategoryService.attributeCategoryPageInfo(pageSize, pageNum);

        return new CommonResult().success(pageInfo);

    }

    @ApiOperation("获取所有商品属性分类及其下属性【难度较高】")
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public Object getListWithAttr() {

        List<PmsProductAttributeCategoryItem> list = productAttributeCategoryService.listAttributeCategoryWithAttr();

        return new CommonResult().success(list);
    }
}
