package com.example.senseohgym_h;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//public class JoinRequest extends StringRequest{
//
//// 서버 URL 설정
//final static private String URL = "http://121.147.185.254:8081/Senseohgym/Login.do";
//    private Map<String, String> map;

//    public JoinRequest(String userID, String userPW, String userName, int userYear,
//                       int userMonth, int userDate, int userHeight, int userWeight, Response.Listener<String>){
//        super(Method.POST, URL, listener, null);
//
//        map = new HashMap<>();
//        map.put("userID", userID);
//        map.put("userPW", userPW);
//        map.put("userName", userName);
//        map.put("userYear", userYear + "");
//        map.put("userMonth", userMonth + "");
//        map.put("userDate", userDate+ "");
//        map.put("userHeight", userHeight+"");
//        map.put("userWeight", userWeight+"");
//
//    }
//
//    @Nullable
//    @Override
//    protected Map<String, String> getParams() throws AuthFailureError {
//        return map;
//    }
//}
