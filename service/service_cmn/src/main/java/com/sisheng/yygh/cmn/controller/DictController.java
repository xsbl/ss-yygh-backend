package com.sisheng.yygh.cmn.controller;

import com.sisheng.yygh.cmn.service.DictService;
import com.sisheng.yygh.common.result.Result;
import com.sisheng.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "数据字典管理")
@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @ApiOperation(value = "根据id查询子元素列表")
    @GetMapping("/findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> dictList = dictService.findChildData(id);
        return Result.ok(dictList);
    }

    /**
     * 导出数据字典表
     *
     * @param response
     * @return
     */
    @ApiOperation(value = "导出数据字典表")
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) {
        dictService.exportDictData(response);
    }

    /**
     * 导入数据字典表
     *
     * @param file
     */
    @ApiOperation(value = "导入数据字典表")
    @PostMapping("/importData")
    public void importData(MultipartFile file) {
        dictService.importDictData(file);
    }

    @ApiOperation(value = "查询医院等级名称(含字典编号)")
    @GetMapping("/getName/{dictCode}/{value}")
    public String getName(@PathVariable String dictCode,
                          @PathVariable String value) {
        String level = dictService.getName(dictCode, value);
        return level;
    }

    @ApiOperation(value = "查询医院等级名称(不含字典编号)")
    @GetMapping("/getName/{value}")
    public String getName(@PathVariable String value) {
        String level = dictService.getName("", value);
        return level;
    }


    @ApiOperation(value = "根据dictCode获取下级节点")
    @GetMapping("/findByDictCode/{dictCode}")
    public Result findByDictCode(@PathVariable String dictCode) {
        List<Dict> list = dictService.findByDictCode(dictCode);
        return Result.ok(list);
    }
}
