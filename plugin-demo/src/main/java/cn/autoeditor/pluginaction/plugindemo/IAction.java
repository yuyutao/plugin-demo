package cn.autoeditor.pluginaction.plugindemo;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;
import java.util.Map;

/**
 * 动作接口，插件的动作实现此接口
 * */
public interface IAction {
    /**
     *  初始化Context
     * */
    public void initContext(Context context) ;
    /**
     * 返回动作名称
     * */
    public String getName() ;
    /**
     * 返回动作参数列表
     * */
    public List<String> getArgs() ;
    /**
     * 返回动作可返回的结果列表
     * */
    public List<String> getResults() ;
    /**
     * 获取动作需要指定输入的参数
     * */
    public Map<String, List<String>> getOptions() ;
    /**
     * 执行动作
     * */
    public Map<String, String> onAction(Map<String, String> args, Bitmap bitmap) ;
}
