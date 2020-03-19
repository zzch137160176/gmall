package per.zzch.gmall.admin.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import per.zzch.gmall.pms.entity.ProductAttribute;
import per.zzch.gmall.pms.service.ProductAttributeService;
import per.zzch.gmall.to.CommonResult;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsProductAttributeParam;
import per.zzch.gmall.vo.product.ProductAttrInfo;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品属性管理Controller
 */
@CrossOrigin
@RestController
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    @Reference
    private ProductAttributeService productAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @GetMapping(value = "/list/{cid}")
    public Object getList(@PathVariable Long cid,
                          @RequestParam(value = "type") Integer type,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        PageInfoVo pageInfoVo = productAttributeService.productAttributePageInfo(cid, type, pageSize, pageNum);

        return new CommonResult().success(pageInfoVo);
    }

    @ApiOperation("添加商品属性信息")
    @PostMapping(value = "/create")
    public Object create(@Valid @RequestBody PmsProductAttributeParam productAttributeParam, BindingResult bindingResult) {

        boolean result = productAttributeService.createProductAttribute(productAttributeParam);

        return new CommonResult().success(result);
    }

    @ApiOperation("修改商品属性信息")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable Long id, @Valid @RequestBody PmsProductAttributeParam productAttributeParam, BindingResult bindingResult) {

        boolean result = productAttributeService.updateProductAttribute(id, productAttributeParam);

        return new CommonResult().success(result);
    }

    @ApiOperation("查询单个商品属性")
    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable Long id) {

        ProductAttribute productAttribute = productAttributeService.getById(id);

        return new CommonResult().success(productAttribute);
    }

    @ApiOperation("批量删除商品属性")
    @PostMapping(value = "/delete")
    public Object delete(@RequestParam("ids") List<Long> ids) {

        boolean result = productAttributeService.removeByIds(ids);

        return new CommonResult().success(result);
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @GetMapping(value = "/attrInfo/{productCategoryId}")
    public Object getAttrInfo(@PathVariable Long productCategoryId) {

        ProductAttrInfo productAttrInfo = productAttributeService.selectAttrInfo(productCategoryId);

        return new CommonResult().success(productAttrInfo);
    }
}
