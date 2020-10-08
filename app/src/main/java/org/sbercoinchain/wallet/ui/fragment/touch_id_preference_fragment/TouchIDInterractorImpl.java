package org.sbercoin.wallet.ui.fragment.touch_id_preference_fragment;

import android.content.Context;

import org.sbercoin.wallet.datastorage.SBERSharedPreference;

import java.lang.ref.WeakReference;

public class TouchIDInterractorImpl implements TouchIDInterractor
{
    private WeakReference<Context> mContext;

    public TouchIDInterractorImpl(Context context)
    {
        this.mContext = new WeakReference<>(context);
    }

    @Override
    public void saveTouchIDEnabled()
    {
        SBERSharedPreference.getInstance().saveTouchIdEnable(mContext.get(), true);
    }
}
