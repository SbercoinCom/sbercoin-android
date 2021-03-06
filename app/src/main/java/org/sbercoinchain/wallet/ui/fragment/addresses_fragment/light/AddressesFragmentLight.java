package org.sbercoin.wallet.ui.fragment.addresses_fragment.light;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.addresses_fragment.AddressesFragment;

import java.util.List;

public class AddressesFragmentLight extends AddressesFragment
{
    @Override
    protected int getLayout()
    {
        return R.layout.fragment_addresses_light;
    }

    @Override
    public void updateAddressList(List<String> deterministicKeys)
    {
        mAddressAdapter = new AddressesAdapterLight(deterministicKeys, this);
        mRecyclerView.setAdapter(mAddressAdapter);
    }
}
