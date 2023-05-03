package com.jzh.xx.transaction.develop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 代码生成表
 * @TableName xx_code
 */
@TableName(value ="xx_code")
@Data
public class XxCode implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 服务名称
     */
    @TableField(value = "service_name")
    private String serviceName;

    /**
     * 模块名称
     */
    @TableField(value = "code_name")
    private String codeName;

    /**
     * 表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * 表前缀
     */
    @TableField(value = "table_prefix")
    private String tablePrefix;

    /**
     * 主键名
     */
    @TableField(value = "pk_name")
    private String pkName;

    /**
     * 后端包名
     */
    @TableField(value = "package_name")
    private String packageName;

    /**
     * 基础业务模式
     */
    @TableField(value = "base_mode")
    private Integer baseMode;

    /**
     * 包装器模式
     */
    @TableField(value = "wrap_mode")
    private Integer wrapMode;

    /**
     * 后端路径
     */
    @TableField(value = "api_path")
    private String apiPath;

    /**
     * 前端路径
     */
    @TableField(value = "web_path")
    private String webPath;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        XxCode other = (XxCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getCodeName() == null ? other.getCodeName() == null : this.getCodeName().equals(other.getCodeName()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getTablePrefix() == null ? other.getTablePrefix() == null : this.getTablePrefix().equals(other.getTablePrefix()))
            && (this.getPkName() == null ? other.getPkName() == null : this.getPkName().equals(other.getPkName()))
            && (this.getPackageName() == null ? other.getPackageName() == null : this.getPackageName().equals(other.getPackageName()))
            && (this.getBaseMode() == null ? other.getBaseMode() == null : this.getBaseMode().equals(other.getBaseMode()))
            && (this.getWrapMode() == null ? other.getWrapMode() == null : this.getWrapMode().equals(other.getWrapMode()))
            && (this.getApiPath() == null ? other.getApiPath() == null : this.getApiPath().equals(other.getApiPath()))
            && (this.getWebPath() == null ? other.getWebPath() == null : this.getWebPath().equals(other.getWebPath()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getCodeName() == null) ? 0 : getCodeName().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getTablePrefix() == null) ? 0 : getTablePrefix().hashCode());
        result = prime * result + ((getPkName() == null) ? 0 : getPkName().hashCode());
        result = prime * result + ((getPackageName() == null) ? 0 : getPackageName().hashCode());
        result = prime * result + ((getBaseMode() == null) ? 0 : getBaseMode().hashCode());
        result = prime * result + ((getWrapMode() == null) ? 0 : getWrapMode().hashCode());
        result = prime * result + ((getApiPath() == null) ? 0 : getApiPath().hashCode());
        result = prime * result + ((getWebPath() == null) ? 0 : getWebPath().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", codeName=").append(codeName);
        sb.append(", tableName=").append(tableName);
        sb.append(", tablePrefix=").append(tablePrefix);
        sb.append(", pkName=").append(pkName);
        sb.append(", packageName=").append(packageName);
        sb.append(", baseMode=").append(baseMode);
        sb.append(", wrapMode=").append(wrapMode);
        sb.append(", apiPath=").append(apiPath);
        sb.append(", webPath=").append(webPath);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}