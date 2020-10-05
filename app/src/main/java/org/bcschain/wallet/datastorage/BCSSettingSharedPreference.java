package org.sbercoin.wallet.datastorage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BCSSettingSharedPreference {

    private final String BCS_SETTING = "bcs_setting";
    private final String SHOW_CONTRACTS_DELETE_UNSUBSCRIBE_WIZARD = "show_contracts_delete_unsubscribe_wizard";
    private final String MIGRATION_VERSION_STRING = "migration_version_string";
    private final String FEE_PER_KB = "fee_per_kb";
    private final String BCS_LANGUAGE = "bcs_language";

    private List<LanguageChangeListener> mLanguageChangeListeners;
    private static BCSSettingSharedPreference sInstance = null;

    public static BCSSettingSharedPreference getInstance() {
        if (sInstance == null) {
            sInstance = new BCSSettingSharedPreference();
        }
        return sInstance;
    }

    private BCSSettingSharedPreference(){
        mLanguageChangeListeners = new ArrayList<>();
    }

    public void setShowContractsDeleteUnsubscribeWizard(Context context, boolean isShow) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(SHOW_CONTRACTS_DELETE_UNSUBSCRIBE_WIZARD, isShow);
        mEditor.apply();
    }

    public boolean getShowContractsDeleteUnsubscribeWizard(Context context) {
        return context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE).getBoolean(SHOW_CONTRACTS_DELETE_UNSUBSCRIBE_WIZARD, true);
    }

    public void setMigrationCodeVersionString(Context context, int codeVersion){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt(MIGRATION_VERSION_STRING, codeVersion);
        mEditor.apply();
    }

    public int getCodeVersion(Context context){
        return context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE).getInt(MIGRATION_VERSION_STRING, 0);
    }

    public void setFeePerKb(Context context, String feePerKb) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(FEE_PER_KB, feePerKb);
        mEditor.apply();
    }

    public String getFeePerKb(Context context) {
        return context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE).getString(FEE_PER_KB, "0.00001");
    }

    public String getLanguage(Context context) {
		String lang = Locale.getDefault().getLanguage().equals("ru") ? "ru" : "en";
        return context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE).getString(BCS_LANGUAGE, lang);
    }

    public void saveLanguage(Context context, String language) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(BCS_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(BCS_LANGUAGE, language);
        mEditor.apply();
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        context.getResources().updateConfiguration(configuration, null);
        for (LanguageChangeListener languageChangeListener : mLanguageChangeListeners) {
            languageChangeListener.onLanguageChange();
        }
    }

    public void addLanguageListener(LanguageChangeListener languageChangeListener) {
        mLanguageChangeListeners.add(languageChangeListener);
    }

    public void removeLanguageListener(LanguageChangeListener languageChangeListener) {
        mLanguageChangeListeners.remove(languageChangeListener);
    }
}
