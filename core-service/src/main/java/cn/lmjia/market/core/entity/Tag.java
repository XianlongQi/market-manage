package cn.lmjia.market.core.entity;

import cn.lmjia.market.core.entity.support.TagType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * 商品标签，商品与标签为多对多的关系，只可新增和删除，不可添加
 * Created by helloztt on 2017/9/12.
 */
@Entity
@Setter
@Getter
public class Tag {
    /**
     * 标签名称
     */
    @Id
    @Column(length = 60)
    private String name;
    /**
     * 标签展示方式
     */
    private TagType type;
    /**
     * 是否有子类目（用于业务拓展，暂时用不到）
     */
    private boolean parent;
    /**
     * 上级类目（用于业务拓展，暂时用不到）
     */
    @ManyToOne
    private Tag parentTag;
    /**
     * 标签图标
     */
    @Column(length = 60)
    private String icon;
    /**
     * 排序
     */
    private int weight;
    /**
     * 是否有效
     */
    private boolean disabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
