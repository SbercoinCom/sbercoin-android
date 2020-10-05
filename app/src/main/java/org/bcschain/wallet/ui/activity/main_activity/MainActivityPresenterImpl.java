package org.sbercoin.wallet.ui.activity.main_activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.sbercoin.wallet.model.gson.DGPInfo;
import org.sbercoin.wallet.model.gson.FeePerKb;
import org.sbercoin.wallet.ui.base.base_activity.BasePresenterImpl;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.sbercoin.wallet.ui.fragment.pin_fragment.PinAction.AUTHENTICATION_AND_SEND;
import static org.sbercoin.wallet.ui.fragment.pin_fragment.PinAction.CHECK_AUTHENTICATION;

public class MainActivityPresenterImpl extends BasePresenterImpl implements MainActivityPresenter {

    private MainActivityView mMainActivityView;
    private MainActivityInteractor mMainActivityInteractor;

    private boolean mAuthenticationFlag = false;
    private boolean mCheckAuthenticationFlag = false;
    private boolean mCheckAuthenticationShowFlag = false;
    private boolean mSendFromIntent = false;

    private LanguageChangeListener mLanguageChangeListener;

    public MainActivityPresenterImpl(MainActivityView mainActivityView, MainActivityInteractor mainActivityInteractor) {
        mMainActivityView = mainActivityView;
        mMainActivityInteractor = mainActivityInteractor;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthenticationFlag && !mCheckAuthenticationShowFlag) {
            mCheckAuthenticationFlag = true;
        }
    }

    @Override
    public void resetAuthFlags() {
        mCheckAuthenticationFlag = true;
        mCheckAuthenticationShowFlag = false;
    }

    @Override
    public void onPostResume() {
        super.onPostResume();
        if (mAuthenticationFlag && mCheckAuthenticationFlag && !mCheckAuthenticationShowFlag) {
            getView().openPinFragment(CHECK_AUTHENTICATION);
            mCheckAuthenticationFlag = false;
            mCheckAuthenticationShowFlag = true;
        }
    }

    public void setCheckAuthenticationFlag(boolean check) {
        this.mCheckAuthenticationFlag = check;
    }

    public boolean isCheckAuthenticationShowFlag() {
        return mCheckAuthenticationShowFlag;
    }

    public void setCheckAuthenticationShowFlag(boolean checkAuthenticationShowFlag) {
        mCheckAuthenticationShowFlag = checkAuthenticationShowFlag;
    }

    @Override
    public boolean shouldShowPin(){
        return !mCheckAuthenticationFlag && mCheckAuthenticationShowFlag;
    }

    @Override
    public MainActivityView getView() {
        return mMainActivityView;
    }

    private MainActivityInteractor getInteractor() {
        return mMainActivityInteractor;
    }

    @Override
    public void onLogin() {
        mAuthenticationFlag = true;
    }

    @Override
    public void onLogout() {
        mAuthenticationFlag = false;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();

        mLanguageChangeListener = new LanguageChangeListener() {
            @Override
            public void onLanguageChange() {
                getView().resetMenuText();

//                Activity current = mMainActivityView.getActivity();
//                current.finish();
//                current.startActivity(new Intent(mMainActivityView.getContext().getApplicationContext(),current.getClass()));

                triggerRebirth(mMainActivityView.getContext(), mMainActivityView.getActivity());
            }
        };

        getInteractor().addLanguageChangeListener(mLanguageChangeListener);

        openStartFragment();
    }

    public static void triggerRebirth(Context context, Activity activity) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
//        activity.finish();
    }

    private void openStartFragment() {
        if (getInteractor().getKeyGeneratedInstance()) {
            if (mSendFromIntent) {
                getView().openPinFragmentRoot(AUTHENTICATION_AND_SEND);
            } else if (!mAuthenticationFlag) {
                getView().openStartPageFragment(true);
            }
        } else {
            getView().openStartPageFragment(false);
        }
    }

    @Override
    public void updateNetworkSate(boolean networkConnectedFlag) {
        if (networkConnectedFlag) {
            if (!getInteractor().isDGPInfoLoaded()) {
                getInteractor().getDGPInfo()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<DGPInfo>() {
                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(DGPInfo dgpInfo) {
                                getInteractor().setDGPInfo(dgpInfo);
                            }
                        });
            }
            if (!getInteractor().isFeePerkbLoaded()) {
                getInteractor().getFeePerKb()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<FeePerKb>() {
                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(FeePerKb feePerKb) {
                                getInteractor().setFeePerKb(feePerKb);
                            }
                        });
            }
        }
    }

    @Override
    public boolean getAuthenticationFlag() {
        return mAuthenticationFlag;
    }

    @Override
    public void setSendFromIntent(boolean sendFromIntent) {
        mSendFromIntent = sendFromIntent;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getInteractor().clearStatic();
        getView().clearService();
        getInteractor().removeLanguageChangeListener(mLanguageChangeListener);
    }
}