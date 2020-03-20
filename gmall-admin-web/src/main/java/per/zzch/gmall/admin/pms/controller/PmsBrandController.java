package per.zzch.gmall.admin.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import per.zzch.gmall.pms.entity.Brand;
import per.zzch.gmall.vo.PageInfoVo;
import per.zzch.gmall.vo.product.PmsBrandParam;
import per.zzch.gmall.pms.service.BrandService;
import per.zzch.gmall.to.CommonResult;

import javax.validation.Valid;
import java.util.List;

/**
 * 品牌功能Controller
 */
@CrossOrigin
@RestController
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {
    @Reference
    private BrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @GetMapping(value = "/listAll")
    public Object getList() {

        List<Brand> list = brandService.list();

        return new CommonResult().success(list);
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping(value = "/create")
    public Object create(@Valid @RequestBody PmsBrandParam pmsBrandParam, BindingResult bindingResult) {

        boolean result =  brandService.createBrand(pmsBrandParam);

        return new CommonResult().success(result);
    }

    @ApiOperation(value = "更新品牌")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable("id") Long id,
                              @Validated @RequestBody PmsBrandParam pmsBrandParam,
                              BindingResult bindingResult) {

        boolean result =  brandService.updateBrand(id, pmsBrandParam);

        return new CommonResult().success(result);
    }

    @ApiOperation(value = "删除品牌")
    @GetMapping(value = "/delete/{id}")
    public Object delete(@PathVariable("id") Long id) {

        boolean result = brandService.removeById(id);

        return new CommonResult().success(result);
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @GetMapping(value = "/list")
    public Object getList(@RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult commonResult = new CommonResult();

        PageInfoVo pageInfoVo = brandService.brandPageInfo(keyword, pageNum, pageSize);

        return commonResult.success(pageInfoVo);
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable("id") Long id) {
        CommonResult commonResult = new CommonResult();

        Brand brand = brandService.getById(id);

        return commonResult.success(brand);
    }

    @ApiOperation(value = "批量删除品牌")
    @PostMapping(value = "/delete/batch")
    public Object deleteBatch(@RequestParam("ids") List<Long> ids) {
        CommonResult commonResult = new CommonResult();

        boolean result = brandService.removeByIds(ids);

        return commonResult.success(result);
    }

    @ApiOperation(value = "批量更新显示状态")
    @PostMapping(value = "/update/showStatus")
    public Object updateShowStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("showStatus") Integer showStatus) {
        CommonResult commonResult = new CommonResult();

        boolean result = brandService.updateShowStatus(ids, showStatus);

        return commonResult.success(result);
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @PostMapping(value = "/update/factoryStatus")
    public Object updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("factoryStatus") Integer factoryStatus) {
        CommonResult commonResult = new CommonResult();

        boolean result = brandService.updateFactoryStatus(ids, factoryStatus);

        return commonResult.success(result);
    }
}
