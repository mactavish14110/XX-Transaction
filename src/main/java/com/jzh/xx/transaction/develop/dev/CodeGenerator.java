package com.jzh.xx.transaction.develop.dev;

import com.jzh.xx.transaction.develop.dev.support.XxCodeGenerator;

public class CodeGenerator {
    public static String CODE_NAME = "应用管理";
    public static String SERVICE_NAME = "xx-system";
    public static String PACKAGE_NAME = "com.jzh.xx.transaction";
    public static String[] TABLE_PREFIX = new String[]{"xx_"};
    public static String[] INCLUDE_TABLES = new String[]{"xx_client"};
    public static String[] EXCLUDE_TABLES = new String[0];
    public static Boolean HAS_SUPER_ENTITY;
    public static String[] SUPER_ENTITY_COLUMNS;

    public CodeGenerator() {
    }

    public static void run() {
        XxCodeGenerator generator = new XxCodeGenerator();
        generator.setCodeName(CODE_NAME);
        generator.setServiceName(SERVICE_NAME);
        generator.setPackageName(PACKAGE_NAME);
        generator.setTablePrefix(TABLE_PREFIX);
        generator.setIncludeTables(INCLUDE_TABLES);
        generator.setExcludeTables(EXCLUDE_TABLES);
        generator.setHasSuperEntity(HAS_SUPER_ENTITY);
        generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        generator.run();
    }

    static {
        HAS_SUPER_ENTITY = Boolean.TRUE;
        SUPER_ENTITY_COLUMNS = new String[]{"id", "create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};
    }
}
