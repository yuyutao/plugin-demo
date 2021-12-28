package cn.autoeditor.pluginaction.plugindemo;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 插件动作接口代理
 * */
public class ActionProxy implements IPluginAction{

    private List<String> mActionList ;
    private Map<String, IAction> mActionObjects ;

    public ActionProxy(){
        mActionList = new ArrayList<>() ;
        mActionObjects = new HashMap<>() ;
    }

    public void addIAction(Class<? extends IAction> cls){
        try {
            IAction action = cls.newInstance() ;
            mActionObjects.put(action.getName(),  action) ;
            mActionList.add(action.getName()) ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initContext(String actionName, Context context) {
        mActionObjects.get(actionName).initContext(context);
    }

    @Override
    public List<String> actionList() {
        return mActionList;
    }

    @Override
    public List<String> actionArgs(String actionName) {
        return mActionObjects.get(actionName).getArgs() ;
    }

    @Override
    public Map<String, List<String>> argsOptions(String actionName) {
        return mActionObjects.get(actionName).getOptions();
    }

    @Override
    public List<String> results(String actionName) {
        return mActionObjects.get(actionName).getResults() ;
    }

    @Override
    public Map<String, String> onAction(String actionName, Map<String, String> args, Bitmap bitmap) {
        return mActionObjects.get(actionName).onAction(args,bitmap);
    }

}
