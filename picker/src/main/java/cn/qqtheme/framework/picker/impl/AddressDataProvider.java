package cn.qqtheme.framework.picker.impl;

import androidx.annotation.NonNull;

import cn.qqtheme.framework.picker.entity.CityEntity;
import cn.qqtheme.framework.picker.entity.CountyEntity;
import cn.qqtheme.framework.picker.entity.ProvinceEntity;
import cn.qqtheme.framework.wheelview.contract.LinkageDataProvider;

import java.util.List;

/**
 * 地址数据提供者
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/6/17 16:27
 */
public class AddressDataProvider implements LinkageDataProvider<ProvinceEntity, CityEntity,
    CountyEntity> {
    private boolean onlyTwoLevel;
    private List<ProvinceEntity> data;

    public AddressDataProvider(boolean onlyTwoLevel, List<ProvinceEntity> data) {
        this.onlyTwoLevel = onlyTwoLevel;
        this.data = data;
    }

    @Override
    public boolean isOnlyTwoLevel() {
        return onlyTwoLevel;
    }

    @NonNull
    @Override
    public List<ProvinceEntity> provideFirstData() {
        return data;
    }

    @NonNull
    @Override
    public List<CityEntity> linkageSecondData(int firstIndex) {
        return data.get(firstIndex).getCityList();
    }

    @NonNull
    @Override
    public List<CountyEntity> linkageThirdData(int firstIndex, int secondIndex) {
        return data.get(firstIndex).getCityList().get(secondIndex).getAreaList();
    }

}
