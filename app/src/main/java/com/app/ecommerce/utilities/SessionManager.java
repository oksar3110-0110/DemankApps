package com.app.ecommerce.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String SESSION_MON = "sessiondEMANK";
    public static final String SESSION_LOGIN = "sessionLOGIN";
    public static final String SESSION_EMAIL = "sessionEmail";
    public static final String SESSION_TYPE = "sessionType";
    public static final String SESSION_ALAMAT = "sessionAlamat";
    public static final String SESSION_PASSWORD = "sessionPassword";
    public static final String SESSION_FOTO = "sessionFoto";
    public static final String SESSION_NAMA = "sessionNama";

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
    public int getSessionType(){
        return session.getInt(SESSION_TYPE,0);
    }

    public String getSessionAlamat(){
        return session.getString(SESSION_ALAMAT,"");
    }
    public String getSessionNama(){return session.getString(SESSION_NAMA, "");}

    public String getSessionMon(){return session.getString(SESSION_MON, "");}
    public String getSessionPassword(){return session.getString(SESSION_PASSWORD, "");}
    public String getSessionFoto(){return session.getString(SESSION_FOTO, "");}

}
