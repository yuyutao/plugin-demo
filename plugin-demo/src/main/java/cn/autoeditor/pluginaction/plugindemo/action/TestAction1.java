package cn.autoeditor.pluginaction.plugindemo.action;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.autoeditor.pluginaction.plugindemo.IAction;

public class TestAction1 implements IAction {
    private static final String NAME = "测试动作1" ;
    private static final String ARG_1 = "动作1参数1" ;
    private static final String ARG_2 = "动作1参数2" ;
    private static final String RESULT_1 = "动作1返回结果" ;

    private static final List<String> PLAT_OPTIONS = new ArrayList<String>(){
        {
            add("动作1参数1只能选择这些内容--1") ;
            add("动作1参数1只能选择这些内容--2") ;
            add("动作1参数1只能选择这些内容--3") ;
        }
    };

    private static final List<String> ARGS = new ArrayList<String>(){
        {
            add(ARG_1) ;
            add(ARG_2) ;
        }
    } ;
    private static final List<String> RESULTS = new ArrayList<String>(){
        {
            add(RESULT_1) ;
        }
    };
    private static final Map<String,List<String>> OPTION_INPUT = new HashMap<String,List<String>>(){
        {
            put(ARG_1, PLAT_OPTIONS) ;
        }
    } ;

    private Handler mHandler ;
    @Override
    public void initContext(Context context) {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Toast.makeText(context, msg.obj.toString(),Toast.LENGTH_SHORT).show();
                return false;
            }
        }) ;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public List<String> getArgs() {
        return ARGS;
    }

    @Override
    public List<String> getResults() {
        return RESULTS;
    }

    @Override
    public Map<String, List<String>> getOptions() {
        return OPTION_INPUT;
    }

    @Override
    public Map<String, String> onAction(Map<String, String> args, Bitmap bitmap) {
        Message message = new Message();
        String toastMsg = NAME ;
        if(args != null){
            toastMsg += args.toString();
        }
        message.obj = toastMsg ;
        mHandler.sendMessage(message) ;

        Map<String,String> result = new HashMap<>() ;
        result.put(RESULT_1, "123") ; //这里测试返回固定值
        return result ;
    }
}
