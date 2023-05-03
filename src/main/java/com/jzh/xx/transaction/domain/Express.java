package com.jzh.xx.transaction.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName express
 */
@TableName(value ="express")
@Data
public class Express implements Serializable {
    /**
     * 快递ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 快递名称
     */
    private String expressName;

    /**
     * 快递价格
     */
    private Double expressPrice;

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
        Express other = (Express) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExpressName() == null ? other.getExpressName() == null : this.getExpressName().equals(other.getExpressName()))
            && (this.getExpressPrice() == null ? other.getExpressPrice() == null : this.getExpressPrice().equals(other.getExpressPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExpressName() == null) ? 0 : getExpressName().hashCode());
        result = prime * result + ((getExpressPrice() == null) ? 0 : getExpressPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", expressName=").append(expressName);
        sb.append(", expressPrice=").append(expressPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}