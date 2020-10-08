package org.sbercoin.wallet.ui.fragment.pin_fragment.light;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.pin_fragment.PinFragment;
import org.sbercoin.wallet.ui.wave_visualizer.WaveHelper;
import org.sbercoin.wallet.ui.wave_visualizer.WaveView;

import butterknife.BindView;

public class PinFragmentLight extends PinFragment
{

    @BindView(org.sbercoin.wallet.R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.fragment_pin_light;
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause()
    {
        mWaveHelper.cancel();
        super.onPause();
    }

    @Override
    public int getThemedStatusBarColor()
    {
        return R.color.title_color_light;
    }
}
