package cn.qqtheme.framework.wheelview.contract;

import cn.qqtheme.framework.wheelview.widget.WheelView;

/**
 *
 * 处理 当字体的宽度超过
 * 控件的宽度 展示省略号
 * @author terencezhan
 * @since 2020/09/21
 */
public interface TextTransformer {

    /**
     *  转换过长的文字 为省略号
     * @param originalText  原本的文字
     * @param view wheelView
     * @return 转换后的文字
     */
    String transformText(String originalText, WheelView view);
}
