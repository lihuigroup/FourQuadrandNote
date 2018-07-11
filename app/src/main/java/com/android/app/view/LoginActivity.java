package com.android.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.app.Entry.UserEntry;
import com.android.app.Http.Http;
import com.android.app.fourquadrantnote.R;
import com.android.app.jsonObject.HttpRequest;
import com.android.app.jsonObject.UserObject;
import com.android.app.model.UserModel;
import com.android.app.permission.ClientPermission;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;

import java.lang.reflect.Type;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_acc;
    private EditText edit_psw;
    private TextView err_msg;
    private TextView txt_back;
    private TextView txt_go;
    private Button login;
    private TextView txt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ClientPermission.permissionManagement(this);
        edit_acc=findViewById(R.id.edit_account);
        edit_psw=findViewById(R.id.edit_psw);
        err_msg=findViewById(R.id.err_msg);
        txt_back=findViewById(R.id.text_back);
        txt_go=findViewById(R.id.text_go);
        login=findViewById(R.id.login);
        txt_register=findViewById(R.id.register);

        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String acc=edit_acc.getText().toString();
                String psw=edit_psw.getText().toString();
                if(acc.equals("")||psw.equals(""))
                    return;
                else {
                    Http.Login(acc, psw, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            Type jsontype = new TypeToken<HttpRequest<UserObject>>() {
                            }.getType();
                            HttpRequest<UserObject> rootbean = new Gson().fromJson(result, jsontype);
                            if (rootbean.getStatus().equals("SUCCESS")) {
                                UserObject userObject = rootbean.getData();
                                UserEntry.getUserEntry().id=userObject.getUserId().intValue();
                                String _id = userObject.getPhoneNum();
                                int id = (new Integer(_id)).intValue();
                                UserModel.LoginSuccess(id);
                                finish();
                            } else {
                                err_msg.setVisibility(View.VISIBLE);
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
        });
    }

}
