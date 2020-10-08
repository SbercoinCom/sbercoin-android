package org.sbercoin.wallet.ui.fragment.profile_fragment;

public class SettingObject
{

    private int mTitleRes;
    private int mImageRes;
    private int mSectionNumber;
    public SettingObject(int title, int image, int section)
    {
        mTitleRes = title;
        mImageRes = image;
        mSectionNumber = section;
    }

    public int getTitleRes()
    {
        return mTitleRes;
    }

    public void setTitleRes(int titleRes)
    {
        mTitleRes = titleRes;
    }

    public int getImageRes()
    {
        return mImageRes;
    }

    public void setImageRes(int imageRes)
    {
        mImageRes = imageRes;
    }

    public int getSectionNumber()
    {
        return mSectionNumber;
    }

    public void setSectionNumber(int sectionNumber)
    {
        mSectionNumber = sectionNumber;
    }
}
