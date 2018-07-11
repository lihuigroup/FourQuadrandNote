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
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.app.Adapter.NoteListAdapter;
import com.android.app.Entry.NoteEntry;
import com.android.app.fourquadrantnote.R;
import com.android.app.model.NoteModel;
import com.android.app.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final int IMPORT=0;
    final int URGENT=1;

    private int sort_type;

    private View headView;
    private Intent intent;
    private Button btn_new;
    private TextView name;
    private TextView txt_userManage;
    private DrawerLayout drawerLayout;
    private ExpandableListView listView;

    private List<NoteEntry> u_i_list;     //四大便签分类
    private List<NoteEntry> u_ui_list;
    private List<NoteEntry> uu_i_list;
    private List<NoteEntry> uu_ui_list;

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

        sort_type=IMPORT;

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
        initList();
    }

    @Override
    protected void onResume() {
        initList();
        super.onResume();
    }

    public void setName(){
        if(UserModel.getUserEntry().getUser_id()!=-1) {
            name.setText(String.valueOf(UserModel.getUserEntry().getUser_id()));
        }
    }

    public void logout(){
        name.setText("尚未登陆");
    }

    public void initDate(){
        List<NoteEntry> entries= NoteModel.getEntries();
        u_i_list=new ArrayList<>();
        u_ui_list=new ArrayList<>();
        uu_i_list=new ArrayList<>();
        uu_ui_list=new ArrayList<>();

        for (int i=0;i<entries.size();i++){
            NoteEntry entry=entries.get(i);
            int type= entry.getType();
            switch (type){//0重要紧急  1重要不紧急 2不重要紧急 3不重要不紧急
                case 0:
                    u_i_list.add(entry);
                    break;
                case 1:
                    uu_i_list.add(entry);
                    break;
                case 2:
                    u_ui_list.add(entry);
                    break;
                case 3:
                    uu_ui_list.add(entry);
                    break;
            }
        }


    }

    public void initList(){
        initDate();
        /*Log.i("u_i_list",String.valueOf(u_i_list.size()));
        Log.i("u_ui_list",String.valueOf(u_ui_list.size()));
        Log.i("uu_i_list",String.valueOf(uu_i_list.size()));
        Log.i("uu_ui_list",String.valueOf(uu_ui_list.size()));*/
        listView.setAdapter(new NoteListAdapter(this,sort_type,u_i_list,u_ui_list,uu_i_list,uu_ui_list));
        int groupCount = listView.getCount();
        for (int i=0; i<groupCount; i++) {
            listView.expandGroup(i);
        };
    }
}
