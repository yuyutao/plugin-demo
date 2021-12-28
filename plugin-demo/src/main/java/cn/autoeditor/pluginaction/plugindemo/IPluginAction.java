package cn.autoeditor.pluginaction.plugindemo;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;
import java.util.Map;

public interface IPluginAction {

    //返回插件支持的事件列表
    public List<String> actionList() ;

    //返回指定事件需要的参数列表
    public List<String> actionArgs(String actionName) ;

    //指定事件参数对应的可选列表，如果可选列表为空将对应变量列表作为输入参数
    public Map<String, List<String>> argsOptions(String actionName) ;

    //返回指定事件的返回结果列表
    public List<String> results(String actionName) ;

    //初始化android context
    public void initContext(String actionName, Context context) ;

    /**执行具体事件
     * @param actionName 执行事件名称
     * @param args 输入参数
     * @param bitmap 当前循环截图
     * @return 返回执行结果
     * */
    public Map<String, String> onAction(String actionName, Map<String, String> args, Bitmap bitmap) ;


}