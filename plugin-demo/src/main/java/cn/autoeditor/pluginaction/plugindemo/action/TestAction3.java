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

public class TestAction3 implements IAction {
    private static final String NAME = "测试动作3" ;
    private static final String RESULT_1 = "动作3返回结果1" ;
    private static final String RESULT_2 = "动作3返回结果2" ;
    private static final List<String> RESULTS = new ArrayList<String>(){
        {
            add(RESULT_1) ;
            add(RESULT_2) ;
        }
    };
    private Handler mHandler ;
    private int test3Result1 = 1;
    private int test3Result2 = 99 ;
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
        return null;
    }

    @Override
    public List<String> getResults() {
        return RESULTS;
    }

    @Override
    public Map<String, List<String>> getOptions() {
        return null;
    }

    @Override
    public Map<String, String> onAction(Map<String, String> args, Bitmap bitmap) {
        Message message = new Message();
        String toastMsg = NAME ;
        if(args != null && args.size() > 0){
            toastMsg += args.toString();
        }
        message.obj = toastMsg ;
        mHandler.sendMessage(message) ;

        Map<String,String> result = new HashMap<>() ;
        result.put(RESULT_1, String.valueOf(test3Result1++)) ;
        result.put(RESULT_2, String.valueOf(test3Result2--)) ;
        return result ;
    }
}
