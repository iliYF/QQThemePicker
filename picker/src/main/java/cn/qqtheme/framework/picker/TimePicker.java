package cn.qqtheme.framework.picker;

import androidx.fragment.app.FragmentActivity;

import cn.qqtheme.framework.wheelview.annotation.DateMode;
import cn.qqtheme.framework.wheelview.annotation.TimeMode;


/**
 * 时间选择器
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/5/15 17:44
 */
public class TimePicker extends DateTimePicker {

    public TimePicker(FragmentActivity activity, @TimeMode int timeMode) {
        super(activity, DateMode.NONE, timeMode);
    }

}
