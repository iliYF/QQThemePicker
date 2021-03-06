package cn.qqtheme.framework.picker.entity;

import androidx.annotation.Keep;

import cn.qqtheme.framework.wheelview.contract.LinkageTextProvider;
import cn.qqtheme.framework.wheelview.contract.TextProvider;

import java.util.List;


/**
 * 市级数据实体
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/6/17 11:47
 */
@Keep
public class CityEntity extends AreaEntity implements LinkageTextProvider {
    private List<CountyEntity> areaList;

    public List<CountyEntity> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<CountyEntity> areaList) {
        this.areaList = areaList;
    }

    @Override
    public List<? extends TextProvider> linkageData() {
        return areaList;
    }

}
