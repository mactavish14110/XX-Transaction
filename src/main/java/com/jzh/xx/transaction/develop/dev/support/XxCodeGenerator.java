package com.jzh.xx.transaction.develop.dev.support;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.jzh.xx.transaction.utils.Func;
import com.jzh.xx.transaction.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class XxCodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(XxCodeGenerator.class);
    private String codeName;
    private String serviceName = "xx-service";
    private String packageName = "com.jzh.xx.transaction.test";
    private String packageDir;
    private String[] tablePrefix = new String[]{"xx_"};
    private String[] includeTables = new String[]{"xx_test"};
    private String[] excludeTables = new String[0];
    private Boolean hasSuperEntity;
    private Boolean hasWrapper;
    private String[] superEntityColumns;
    private String tenantColumn;
    private Boolean isSwagger2;
    private String driverName;
    private String url;
    private String username;
    private String password;

    public void run() {
        Properties props = this.getProperties();
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String outputDir = this.getOutputDir();
        String author = props.getProperty("author");
        gc.setOutputDir(outputDir);
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setSwagger2(this.isSwagger2);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        String driverName = Func.toStr(this.driverName, props.getProperty("spring.datasource.driver-class-name"));
        if (StringUtil.containsAny(driverName, new CharSequence[]{DbType.MYSQL.getDb()})) {
            dsc.setDbType(DbType.MYSQL);
            dsc.setTypeConvert(new MySqlTypeConvert());
        } else if (StringUtil.containsAny(driverName, new CharSequence[]{DbType.POSTGRE_SQL.getDb()})) {
            dsc.setDbType(DbType.POSTGRE_SQL);
            dsc.setTypeConvert(new PostgreSqlTypeConvert());
        } else if (StringUtil.containsAny(driverName, new CharSequence[]{DbType.SQL_SERVER.getDb()})) {
            dsc.setDbType(DbType.SQL_SERVER);
            dsc.setTypeConvert(new SqlServerTypeConvert());
        } else {
            dsc.setDbType(DbType.ORACLE);
            dsc.setTypeConvert(new OracleTypeConvert());
        }

        dsc.setDriverName(driverName);
        dsc.setUrl(Func.toStr(this.url, props.getProperty("spring.datasource.url")));
        dsc.setUsername(Func.toStr(this.username, props.getProperty("spring.datasource.username")));
        dsc.setPassword(Func.toStr(this.password, props.getProperty("spring.datasource.password")));
        mpg.setDataSource(dsc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(this.tablePrefix);
        if (this.includeTables.length > 0) {
            strategy.setInclude(this.includeTables);
        }

        if (this.excludeTables.length > 0) {
            strategy.setExclude(this.excludeTables);
        }

        if (this.hasSuperEntity) {
            strategy.setSuperEntityClass("org.springblade.core.mp.base.BaseEntity");
            strategy.setSuperEntityColumns(this.superEntityColumns);
            strategy.setSuperServiceClass("org.springblade.core.mp.base.BaseService");
            strategy.setSuperServiceImplClass("org.springblade.core.mp.base.BaseServiceImpl");
        } else {
            strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
            strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        }

        //strategy.setSuperControllerClass("org.springblade.core.boot.ctrl.BladeController");
        strategy.setEntityBuilderModel(false);
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        PackageConfig pc = new PackageConfig();
        pc.setModuleName((String)null);
        pc.setParent(this.packageName);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        mpg.setCfg(this.getInjectionConfig());
        mpg.execute();
    }

    private InjectionConfig getInjectionConfig() {
        final String servicePackage = this.serviceName.split("-").length > 1 ? this.serviceName.split("-")[1] : this.serviceName;
        final Map<String, Object> map = new HashMap(16);
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {
                map.put("codeName", XxCodeGenerator.this.codeName);
                map.put("serviceName", XxCodeGenerator.this.serviceName);
                map.put("servicePackage", servicePackage);
                map.put("servicePackageLowerCase", servicePackage.toLowerCase());
                map.put("tenantColumn", XxCodeGenerator.this.tenantColumn);
                map.put("hasWrapper", XxCodeGenerator.this.hasWrapper);
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList();
        focList.add(new FileOutConfig("/templates/code/entityVO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return XxCodeGenerator.this.getOutputDir() + "/" + XxCodeGenerator.this.packageName.replace(".", "/") + "/vo/" + tableInfo.getEntityName() + "VO" + ".java";
            }
        });
        focList.add(new FileOutConfig("/templates/code/entityDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return XxCodeGenerator.this.getOutputDir() + "/" + XxCodeGenerator.this.packageName.replace(".", "/") + "/dto/" + tableInfo.getEntityName() + "DTO" + ".java";
            }
        });
        if (this.hasWrapper) {
            focList.add(new FileOutConfig("/templates/code/wrapper.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return XxCodeGenerator.this.getOutputDir() + "/" + XxCodeGenerator.this.packageName.replace(".", "/") + "/wrapper/" + tableInfo.getEntityName() + "Wrapper" + ".java";
                }
            });
        }

        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    private Properties getProperties() {
        Resource resource = new ClassPathResource("/templates/code/code.properties");
        Properties props = new Properties();

        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return props;
    }

    public String getOutputDir() {
        return (StringUtil.isBlank(this.packageDir) ? System.getProperty("user.dir") + "/blade-ops/blade-develop" : this.packageDir) + "/src/main/java";
    }

    private String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
        String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
        String path = viewOutputDir + "/" + name + "/" + name + suffixPath;
        File viewDir = (new File(path)).getParentFile();
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }

        return path;
    }

    public XxCodeGenerator() {
        this.hasSuperEntity = Boolean.FALSE;
        this.hasWrapper = Boolean.FALSE;
        this.superEntityColumns = new String[]{"id", "create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};
        this.tenantColumn = "tenant_id";
        this.isSwagger2 = Boolean.TRUE;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageDir() {
        return this.packageDir;
    }

    public String[] getTablePrefix() {
        return this.tablePrefix;
    }

    public String[] getIncludeTables() {
        return this.includeTables;
    }

    public String[] getExcludeTables() {
        return this.excludeTables;
    }

    public Boolean getHasSuperEntity() {
        return this.hasSuperEntity;
    }

    public Boolean getHasWrapper() {
        return this.hasWrapper;
    }

    public String[] getSuperEntityColumns() {
        return this.superEntityColumns;
    }

    public String getTenantColumn() {
        return this.tenantColumn;
    }

    public Boolean getIsSwagger2() {
        return this.isSwagger2;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCodeName(final String codeName) {
        this.codeName = codeName;
    }

    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }

    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

    public void setPackageDir(final String packageDir) {
        this.packageDir = packageDir;
    }

    public void setTablePrefix(final String[] tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void setIncludeTables(final String[] includeTables) {
        this.includeTables = includeTables;
    }

    public void setExcludeTables(final String[] excludeTables) {
        this.excludeTables = excludeTables;
    }

    public void setHasSuperEntity(final Boolean hasSuperEntity) {
        this.hasSuperEntity = hasSuperEntity;
    }

    public void setHasWrapper(final Boolean hasWrapper) {
        this.hasWrapper = hasWrapper;
    }

    public void setSuperEntityColumns(final String[] superEntityColumns) {
        this.superEntityColumns = superEntityColumns;
    }

    public void setTenantColumn(final String tenantColumn) {
        this.tenantColumn = tenantColumn;
    }

    public void setIsSwagger2(final Boolean isSwagger2) {
        this.isSwagger2 = isSwagger2;
    }

    public void setDriverName(final String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

}
