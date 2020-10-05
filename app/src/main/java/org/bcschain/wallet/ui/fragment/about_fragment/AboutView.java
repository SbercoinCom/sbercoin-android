package org.sbercoin.wallet.ui.fragment.about_fragment;

import org.sbercoin.wallet.model.Version;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface AboutView extends BaseFragmentView {
    void updateVersion(Version version);
}
