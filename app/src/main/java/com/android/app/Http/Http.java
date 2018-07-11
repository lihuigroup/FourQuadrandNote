package com.android.app.Http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class Http {
    private static String ip="https://www.cjtellyou.xyz";

    public static void Login(String phoneNum,String password, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(ip+"/control/user/login");
        params.addBodyParameter("phoneNum",phoneNum);
        params.addBodyParameter("passwd",password);

        x.http().get(params,callback);
    }

    public static void upload(){

    }

    public static void download(){

    }

    public static void modifyPassword(int userId,String oldPassword,String newPassword, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(ip+"/control/user/resetPassword");
        params.addBodyParameter("userId",String.valueOf(userId));
        params.addBodyParameter("oldPassword",oldPassword);
        params.addBodyParameter("newPassword",newPassword);

        x.http().get(params,callback);
    }

    public static void register(String phoneNum,String password, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(ip+"/control/user/register");
        params.addBodyParameter("nickname","FourQuard");
        params.addBodyParameter("phoneNum",phoneNum);
        params.addBodyParameter("passwd",password);

        x.http().get(params,callback);
    }
}
