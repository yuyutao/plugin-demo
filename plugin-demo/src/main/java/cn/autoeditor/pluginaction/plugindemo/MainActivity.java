package cn.autoeditor.pluginaction.plugindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.autoeditor.pluginaction.plugindemo.action.TestAction1;
import cn.autoeditor.pluginaction.plugindemo.action.TestAction2;
import cn.autoeditor.pluginaction.plugindemo.action.TestAction3;

public class MainActivity extends AppCompatActivity implements  IPluginAction{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ActionProxy actionProxy ;
    public MainActivity(){

        actionProxy = new ActionProxy() ;
        actionProxy.addIAction(TestAction1.class);
        actionProxy.addIAction(TestAction2.class);
        actionProxy.addIAction(TestAction3.class);
    }

    @Override
    public List<String> actionList() {
        return actionProxy.actionList() ;
    }

    @Override
    public List<String> actionArgs(String actionName) {
        return actionProxy.actionArgs(actionName);
    }

    @Override
    public Map<String, List<String>> argsOptions(String actionName) {
        return actionProxy.argsOptions(actionName);
    }
    @Override
    public void initContext(String actionName, Context context) {
        actionProxy.initContext(actionName,context);
    }
    @Override
    public List<String> results(String actionName) {
        return actionProxy.results(actionName);
    }
    @Override
    public Map<String, String> onAction(String actionName, Map<String, String> args, Bitmap bitmap) {
        return actionProxy.onAction(actionName,args, bitmap);
    }

}