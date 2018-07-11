package com.android.app.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.app.Http.Http;
import com.android.app.fourquadrantnote.R;
import com.android.app.jsonObject.HttpRequest;
import com.android.app.jsonObject.UserObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;

import java.lang.reflect.Type;

public class RegisterActivity extends AppCompatActivity {

    private TextView text_back;
    private EditText edit_acc;
    private EditText edit_psw;
    private EditText edit_psw_again;
    private TextView psw_err;
    private TextView acc_err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        text_back=findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edit_acc=findViewById(R.id.edit_account);
        edit_psw=findViewById(R.id.edit_psw);
        edit_psw_again=findViewById(R.id.edit_psw_again);
        psw_err =findViewById(R.id.txt_psw_err);
        acc_err=findViewById(R.id.txt_acc_err);
    }

    public void submit(View view){
        String s_acc=edit_acc.getText().toString();
        String s_psw=edit_psw.getText().toString();
        String s_psw_again=edit_psw_again.getText().toString();

        if (s_acc.equals("")||s_psw.equals("")||s_psw_again.equals("")){
            return;
        }

        if (!s_psw.equals(s_psw_again)){
            psw_err.setVisibility(View.VISIBLE);
            acc_err.setVisibility(View.INVISIBLE);
        }

        Http.register(s_acc, s_psw, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Type type=new TypeToken<HttpRequest<UserObject>>(){}.getType();
                HttpRequest<UserObject> rootbean=new Gson().fromJson(result,type);
                if(rootbean.getStatus().equals("SUCCESS")) {
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setMessage("注册成功！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .create().show();
                }else {
                    psw_err.setVisibility(View.INVISIBLE);
                    acc_err.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
