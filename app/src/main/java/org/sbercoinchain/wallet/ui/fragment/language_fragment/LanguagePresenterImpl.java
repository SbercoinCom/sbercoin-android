package org.sbercoin.wallet.ui.fragment.language_fragment;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;
import org.sbercoin.wallet.ui.fragment.language_fragment.LanguagePresenter;

public class LanguagePresenterImpl extends BaseFragmentPresenterImpl implements LanguagePresenter {

    private LanguageView mLanguageFragmentView;
    private LanguageInteractor mLanguageFragmentInteractor;
    private LanguageChangeListener mLanguageChangeListener;

    public LanguagePresenterImpl(LanguageView languageFragmentView, LanguageInteractor languageInteractor) {
        mLanguageFragmentView = languageFragmentView;
        mLanguageFragmentInteractor = languageInteractor;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getInteractor().removeLanguageListener(mLanguageChangeListener);
    }

    @Override
    public LanguageView getView() {
        return mLanguageFragmentView;
    }

    private LanguageInteractor getInteractor() {
        return mLanguageFragmentInteractor;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        getView().setUpLanguagesList(getInteractor().getLanguagesList());
        mLanguageChangeListener = new LanguageChangeListener() {
            @Override
            public void onLanguageChange() {
                getView().resetText();
            }
        };
        getInteractor().addLanguageListener(mLanguageChangeListener);
    }

    @Override
    public String getCurrentLanguage() {
        return getInteractor().getLanguage();
    }

    @Override
    public void setCurrentLanguage(String language) {
        getInteractor().setLanguage(language);
    }
}
