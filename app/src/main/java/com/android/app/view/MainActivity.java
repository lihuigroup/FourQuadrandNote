package com.android.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.app.fourquadrantnote.R;
import com.android.app.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private View headView;
    private Intent intent;
    private Button btn_new;
    private TextView name;
    private TextView txt_userManage;
    private DrawerLayout drawerLayout;
    private ListView listView;

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
                            UserModel.Logout();
                            logout();
                            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
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

        //检查用户是否登陆过
        if(UserModel.checkUserOnline()==-1) {//初始化用户
            intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        headView= leftnavigation.inflateHeaderView(R.layout.head);
        name= headView.findViewById(R.id.head_name);

        setName();

        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserModel.checkUserOnline()==-1) {//初始化用户
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_new=findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,FourQuadrandActivity.class);
                startActivity(intent);
            }
        });

        txt_userManage=findViewById(R.id.txt_user_manager);
        drawerLayout=findViewById(R.id.drawerLayout);
        txt_userManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setName();
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        listView=findViewById(R.id.list);
    }

    public void setName(){
        if(UserModel.getUserEntry().getUser_id()!=-1) {
            name.setText(String.valueOf(UserModel.getUserEntry().getUser_id()));
        }
    }

    public void logout(){
        name.setText("尚未登陆");
    }
}
