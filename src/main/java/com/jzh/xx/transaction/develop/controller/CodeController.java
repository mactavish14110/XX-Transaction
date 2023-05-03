package com.jzh.xx.transaction.develop.controller;

import cn.hutool.core.date.DateUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jzh.xx.transaction.base.result.R;
import com.jzh.xx.transaction.develop.dev.support.XxCodeGenerator;
import com.jzh.xx.transaction.develop.entity.XxCode;
import com.jzh.xx.transaction.develop.service.XxCodeService;
import com.jzh.xx.transaction.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @description 代码生成控制器
 * @author jzh
 * @date 2021/5/8 17:12
 */
@RestController
@RequestMapping("/code")
@Api(value = "代码生成", tags = "代码生成")
public class CodeController {

    @Resource
    private XxCodeService xxCodeService;

    /**
     * 代码生成
     */
    @GetMapping("/gen-code")
    @ApiOperation(value = "代码生成", notes = "传入ids")
    public R genCode(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        Collection<XxCode> codes = xxCodeService.listByIds(Func.toLongList(ids));
        codes.forEach(code -> {
            XxCodeGenerator generator = new XxCodeGenerator();
            // 设置基础配置
            generator.setCodeName(code.getCodeName());
            generator.setServiceName(code.getServiceName());
            generator.setPackageName(code.getPackageName());
            generator.setPackageDir(code.getApiPath());
            generator.setTablePrefix(Func.toStrArray(code.getTablePrefix()));
            generator.setIncludeTables(Func.toStrArray(code.getTableName()));
            // 设置是否继承基础业务字段
            generator.setHasSuperEntity(code.getBaseMode() == 2);
            // 设置是否开启包装器模式
            generator.setHasWrapper(code.getWrapMode() == 2);
            generator.run();
        });
        return R.success("代码生成成功");
    }

}
