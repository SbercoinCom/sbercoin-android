package org.sbercoin.wallet.ui.fragment.addresses_fragment.dark;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.addresses_fragment.AddressesFragment;

import java.util.List;

public class AddressesFragmentDark extends AddressesFragment
{
    @Override
    protected int getLayout()
    {
        return R.layout.fragment_addresses;
    }

    @Override
    public void updateAddressList(List<String> deterministicKeys)
    {
        mAddressAdapter = new AddressesAdapterDark(deterministicKeys, this);
        mRecyclerView.setAdapter(mAddressAdapter);
    }
}
