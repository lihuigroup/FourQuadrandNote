package com.android.app.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.app.Entry.UserEntry;
import com.android.app.Http.Http;
import com.android.app.fourquadrantnote.R;
import com.android.app.jsonObject.HttpRequest;
import com.google.gson.Gson;

import org.xutils.common.Callback;

public class ChangPasswordActivity extends AppCompatActivity {

    private TextView text_back;
    private EditText old_psw;
    private EditText new_psw;
    private EditText new_psw_again;
    private EditText acc;
    private TextView psw_err;
    private TextView psw_again_err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_password);

        text_back=findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        old_psw=findViewById(R.id.edit_old_psw);
        new_psw=findViewById(R.id.edit_new_psw);
        new_psw_again=findViewById(R.id.edit_new_pse_again);
        acc=findViewById(R.id.edit_account);
        psw_err=findViewById(R.id.old_psw_err);
        psw_again_err=findViewById(R.id.psw_not_one_err);
    }

    public void submit(View view){
        String s_acc=acc.getText().toString();
        String s_old_psw=old_psw.getText().toString();
        String s_new_psw=new_psw.getText().toString();
        String s_new_psw_again=new_psw_again.getText().toString();

        if (s_acc.equals("")||s_old_psw.equals("")||s_new_psw.equals("")||s_new_psw_again.equals("")){
            return;
        }
        if (!s_new_psw.equals(s_new_psw_again)){
            psw_again_err.setVisibility(View.VISIBLE);
            psw_err.setVisibility(View.INVISIBLE);
        }

        Http.modifyPassword(UserEntry.getUserEntry().id, s_old_psw, s_new_psw, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                HttpRequest rootbean= new Gson().fromJson(result, HttpRequest.class);
                if(rootbean.getStatus().equals("SUCCESS")){
                    new AlertDialog.Builder(ChangPasswordActivity.this)
                            .setMessage("修改密码成功！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .create().show();
                }else {
                     psw_again_err.setVisibility(View.INVISIBLE);
                     psw_err.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                cex.printStackTrace();
            }

            @Override
            public void onFinished() {

            }
        });

    }
}
