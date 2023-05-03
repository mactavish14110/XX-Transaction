package com.jzh.xx.transaction.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description 代码生成器
 * @author jzh
 * @date 2021/5/4 17:23
 */
public class GeneratorUtils {

    //数据库配置信息
    public static final String dbUrl = "jdbc:mysql://localhost:3306/xx-shop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String username = "root";
    public static final String password = "root";

    //业务层基础路径
    public static final String parentPath = "com.jzh.xx.transaction";
    //实体类保存路径
    public static final String entityPath = "com.jzh.xx.transaction.domain";
    //mapper.xml文件保存路径
    public static final String xmlPath = "\\src\\main\\resources\\mapper";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("jzh");
        gc.setOpen(false);
        gc.setSwagger2(true);           //是否生成swagger注解 true：是
        gc.setFileOverride(true);       //是否覆盖
        gc.setMapperName("%sMapper");   //mapper 命名方式,默认值：null 例如：%sDao 生成 UserDao
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有I
        mpg.setGlobalConfig(gc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));   //包名
        pc.setParent(parentPath);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        mpg.execute();
    }


    //读取控制台内容
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
