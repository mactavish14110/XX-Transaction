package com.jzh.xx.transaction.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName banner
 */
@TableName(value ="banner")
@Data
public class Banner implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * 名称
     */
    private String bannerName;

    /**
     * 价格
     */
    private Double bannerPrice;

    /**
     * 详情
     */
    private String bannerDetail;

    /**
     * 库存
     */
    private Integer bannerNumber;

    /**
     * 
     */
    private String img1;

    /**
     * 
     */
    private String img2;

    /**
     * 
     */
    private String img3;

    /**
     * 是否卖出
     */
    private Byte sellStatus;

    /**
     * 
     */
    private Date created;

    /**
     * 
     */
    private Date updated;

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
        Banner other = (Banner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getBannerName() == null ? other.getBannerName() == null : this.getBannerName().equals(other.getBannerName()))
            && (this.getBannerPrice() == null ? other.getBannerPrice() == null : this.getBannerPrice().equals(other.getBannerPrice()))
            && (this.getBannerDetail() == null ? other.getBannerDetail() == null : this.getBannerDetail().equals(other.getBannerDetail()))
            && (this.getBannerNumber() == null ? other.getBannerNumber() == null : this.getBannerNumber().equals(other.getBannerNumber()))
            && (this.getImg1() == null ? other.getImg1() == null : this.getImg1().equals(other.getImg1()))
            && (this.getImg2() == null ? other.getImg2() == null : this.getImg2().equals(other.getImg2()))
            && (this.getImg3() == null ? other.getImg3() == null : this.getImg3().equals(other.getImg3()))
            && (this.getSellStatus() == null ? other.getSellStatus() == null : this.getSellStatus().equals(other.getSellStatus()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getBannerName() == null) ? 0 : getBannerName().hashCode());
        result = prime * result + ((getBannerPrice() == null) ? 0 : getBannerPrice().hashCode());
        result = prime * result + ((getBannerDetail() == null) ? 0 : getBannerDetail().hashCode());
        result = prime * result + ((getBannerNumber() == null) ? 0 : getBannerNumber().hashCode());
        result = prime * result + ((getImg1() == null) ? 0 : getImg1().hashCode());
        result = prime * result + ((getImg2() == null) ? 0 : getImg2().hashCode());
        result = prime * result + ((getImg3() == null) ? 0 : getImg3().hashCode());
        result = prime * result + ((getSellStatus() == null) ? 0 : getSellStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", bannerName=").append(bannerName);
        sb.append(", bannerPrice=").append(bannerPrice);
        sb.append(", bannerDetail=").append(bannerDetail);
        sb.append(", bannerNumber=").append(bannerNumber);
        sb.append(", img1=").append(img1);
        sb.append(", img2=").append(img2);
        sb.append(", img3=").append(img3);
        sb.append(", sellStatus=").append(sellStatus);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}