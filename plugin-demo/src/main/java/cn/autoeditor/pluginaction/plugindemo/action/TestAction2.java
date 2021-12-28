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

public class TestAction2 implements IAction {
    private static final String NAME = "测试动作2" ;

    private static final String ARG_1 = "动作2参数1" ;

    private static final List<String> ARGS = new ArrayList<String>(){
        {
            add(ARG_1) ;
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
        return null;
    }

    @Override
    public Map<String, List<String>> getOptions() {
        return null;
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

        return null ;
    }
}
