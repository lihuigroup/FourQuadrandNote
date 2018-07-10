package com.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.app.fourquadrantnote.R;

public class MainActivity extends AppCompatActivity {

    private View headView;
    private Intent intent;
    private Button btn_new;

    private NavigationView.OnNavigationItemSelectedListener leftNav=
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.upload:
                            //上传便签
                            return true;
                        case R.id.download:
                            //下载便签
                            return true;
                        case R.id.password:
                            //修改密码
                            intent=new Intent(MainActivity.this,ChangPasswordActivity.class);
                            startActivity(intent);
                            return true;
                        case R.id.logout:
                            //退出登录
                            return true;
                        case R.id.setting:
                            //设置
                            intent=new Intent(MainActivity.this,SetActivity.class);
                            startActivity(intent);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contain);
        NavigationView leftnavigation=(NavigationView) findViewById(R.id.nav);
        leftnavigation.setNavigationItemSelectedListener(leftNav);

        headView= leftnavigation.inflateHeaderView(R.layout.head);

        btn_new=findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,NewNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}
