package org.sbercoin.wallet.ui.fragment.backup_contracts_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface BackupContractsPresenter extends BaseFragmentPresenter
{
    void permissionGrantedForChooseShareMethod();

    void permissionGrantedForCreateAndBackUpFile();

    void permissionGrantedForCreateBackUpFile();

    void onBackUpClick();
}
