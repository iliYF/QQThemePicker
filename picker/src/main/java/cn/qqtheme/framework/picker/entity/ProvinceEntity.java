package cn.qqtheme.framework.picker.entity;

import androidx.annotation.Keep;

import cn.qqtheme.framework.wheelview.contract.LinkageTextProvider;
import cn.qqtheme.framework.wheelview.contract.TextProvider;

import java.util.List;


/**
 * 省级数据实体
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/6/17 11:47
 */
@Keep
public class ProvinceEntity extends AreaEntity implements LinkageTextProvider {
    private List<CityEntity> cityList;

    public List<CityEntity> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityEntity> cityList) {
        this.cityList = cityList;
    }

    @Override
    public List<? extends TextProvider> linkageData() {
        return cityList;
    }

}
