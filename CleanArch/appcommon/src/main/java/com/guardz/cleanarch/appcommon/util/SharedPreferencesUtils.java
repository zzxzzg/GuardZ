package com.guardz.cleanarch.appcommon.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

	public interface Key {
		String APP_VERSION="app_version";
		String UPGRADE_DOWNLOAD_ID="upgrade_download_id";
		String IGNORE_VERSION="ignore_version";
	}

	public interface FileName {
		String NORMAL_PREFERENCE="normal_preference";
	}

	private static Context mContext;
	/**
	 * we need initialize this util in application!!
 	 */
	public static void init(Context context){
		if(!(context instanceof Application)){
			//warning!!!
		}
		mContext = context;
	}

	public static SharedPreferences getSharedPreferences(String name,int mode){
		return mContext.getSharedPreferences(name,mode);
	}

}
