package cn.qqtheme.framework.picker.entity;

import androidx.annotation.Keep;

import cn.qqtheme.framework.wheelview.contract.TextProvider;

import java.io.Serializable;


/**
 * 地址数据实体
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/6/17 11:47
 */
@Keep
class AreaEntity implements TextProvider, Serializable {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String provideItemText() {
        return name;
    }

}
