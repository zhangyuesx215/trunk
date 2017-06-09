package com.uniware.driver.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.uniware.driver.AppApplication;

/**
 * Created by jian on 15/11/11.
 */
public class LoginConfig {
  private static LoginConfig loginConfig;
  private SharedPreferences mPref;
  private SharedPreferences.Editor mEditor;

  private LoginConfig() {
    mPref = AppApplication.getAppContext()
        .getSharedPreferences("userYJ", 0);
    mEditor = mPref.edit();
  }

  public static LoginConfig getInstance() {
    if (loginConfig == null) {
      synchronized (LoginConfig.class) {
        if (loginConfig == null) {
          loginConfig = new LoginConfig();
        }
      }
    }
    return loginConfig;
  }

  public boolean isRegister() {
    return mPref.getBoolean("register", false);
  }

  public boolean isFirstLogin() {
    return mPref.getBoolean("isLogin", false);
  }

  public void setFirstLogin(boolean isLogin) {
    mEditor.putBoolean("isLogin", isLogin).commit();
  }

  public String getUserName() {
    return mPref.getString("userName", "");
  }

  public String getUserPassword() {
    return mPref.getString("userPassword", "");
  }

  public void setUserName(String name) {
    mEditor.putString("userName", name).commit();
  }

  public void setUserPassword(String password) {
    mEditor.putString("userPassword", password).commit();
  }
  public void setSetting(int hobby ,int distance){
    mEditor.putInt("hobby", hobby).commit();
    mEditor.putInt("distance", distance).commit();
  }
  public int getHobby(){
    return mPref.getInt("hobby", 0);
  }
  public int getDistance(){
    return mPref.getInt("distance", 0);
  }
  public void setLocation(String lat,String lon){
    mEditor.putString("lat", lat).commit();
    mEditor.putString("lon", lon).commit();
  }
  public String getLat(){
    return  mPref.getString("lat","0");
  }
  public String getLon(){
    return  mPref.getString("lon","0");

    }
}