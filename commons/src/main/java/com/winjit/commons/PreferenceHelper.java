package com.winjit.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceHelper {

	private static SharedPreferences sharedPreferences;
	
	public PreferenceHelper(Context context, String preferenceName) {
		if (sharedPreferences == null)
			sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
	}
	
	public void putString(String preferenceKey, String preferenceValue)
	{
		Editor e = sharedPreferences.edit();
		e.putString(preferenceKey, preferenceValue);
		e.commit();
	}
	
	public String getString(String preferenceKey, String preferenceDefaultValue)
	{
		return sharedPreferences.getString(preferenceKey, preferenceDefaultValue);
	}
	
	public void putInt(String preferenceKey, int preferenceValue)
	{
		Editor e = sharedPreferences.edit();
		e.putInt(preferenceKey, preferenceValue);
		e.commit();
	}
	
	public int getInt(String preferenceKey, int preferenceDefaultValue)
	{
		return sharedPreferences.getInt(preferenceKey, preferenceDefaultValue);
	}
	
	public void putBoolean(String preferenceKey, boolean preferenceValue)
	{
		Editor e = sharedPreferences.edit();
		e.putBoolean(preferenceKey, preferenceValue);
		e.commit();
	}
	
	public boolean getBoolean(String preferenceKey, boolean preferenceDefaultValue)
	{
		return sharedPreferences.getBoolean(preferenceKey, preferenceDefaultValue);
	}
	
	public void putFloat(String preferenceKey, float preferenceValue)
	{
		Editor e = sharedPreferences.edit();
		e.putFloat(preferenceKey, preferenceValue);
		e.commit();
	}
	
	public Float getFloat(String preferenceKey, float preferenceDefaultValue)
	{
		return sharedPreferences.getFloat(preferenceKey, preferenceDefaultValue);
	}
}