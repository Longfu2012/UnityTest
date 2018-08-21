package com.unityapplication;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    private Context mContext;
    private static final String ANDROID_STR = "Android Platform";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button btn1 = new Button(this);
        btn1.setText("调用Unity无参函数");
        btn1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                UnityPlayer.UnitySendMessage("ButtonUnity","ChangeObj1","");
            }
        });
        Button btn2 = new Button(this);
        btn2.setText("调用Unity有参函数");
        btn2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                UnityPlayer.UnitySendMessage("ButtonUnity","ChangeObj2","param");
            }
        });
        linearLayout.addView(btn1,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(btn2,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mUnityPlayer.addView(linearLayout,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

    }

    public void showToast(){
        Toast.makeText(mContext,ANDROID_STR,Toast.LENGTH_LONG).show();
    }

    public void showToast(String unityStr){
        Toast.makeText(mContext, TextUtils.isEmpty(unityStr) ? "null":unityStr,Toast.LENGTH_LONG).show();
    }

    public String getAndroidStr(){
        return ANDROID_STR;
    }



}
