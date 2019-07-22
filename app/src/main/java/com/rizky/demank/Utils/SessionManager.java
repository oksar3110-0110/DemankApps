package com.rizky.demank.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String SESSION_MON = "sessionMON";
    public static final String SESSION_LOGIN = "sessionLOGIN";
    public static final String SESSION_EMAIL = "sessionEmail";
    public static final String SESSION_NOHP = "sessionHP";
    public static final String SESSION_ALAMAT = "sessionAlamat";
    public static final String SESSION_NAMA = "sessionNama";
    public static final String SESSION_USERNAME = "sessionUsername";
    public static final String SESSION_PASSWORD = "sessionPass";
    public static final String SESSION_IDUSER = "sessionIDUSer";

    SharedPreferences session;
    SharedPreferences.Editor sessionEditor;

    public SessionManager(Context context){
        session = context.getSharedPreferences(SESSION_MON, Context.MODE_PRIVATE);
        sessionEditor = session.edit();
    }

    public void saveSessionStr(String keySP, String value){
        sessionEditor.putString(keySP, value);
        sessionEditor.commit();
    }
    public void saveSessionInt(String keySp, int value){
        sessionEditor.putInt(keySp, value);
        sessionEditor.commit();
    }
    public void saveSessionBoolean(String keySp, boolean value){
        sessionEditor.putBoolean(keySp, value);
        sessionEditor.commit();
    }

    public Boolean getSessionLogin(){
        return session.getBoolean(SESSION_LOGIN, false);
    }
    public String getSessionEmail(){return session.getString(SESSION_EMAIL, "");}
    public String getSessionAlamat(){
        return session.getString(SESSION_ALAMAT,"");
    }
    public String getSessionNohp(){return session.getString(SESSION_NOHP, "");}
    public String getSessionNama(){return session.getString(SESSION_NAMA, "");}
    public String getSessionUsername(){return session.getString(SESSION_USERNAME, "");}
    public String getSessionPassword(){return session.getString(SESSION_PASSWORD, "");}
    public String getSessionIduser(){return session.getString(SESSION_IDUSER, "");}
}
