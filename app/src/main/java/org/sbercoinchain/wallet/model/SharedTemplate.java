package org.sbercoin.wallet.model;

public class SharedTemplate
{
    private String mUuid;
    private String mTemplateName;

    public SharedTemplate(String uuid, String templateName)
    {
        this.mUuid = uuid;
        this.mTemplateName = templateName;
    }

    public String getUuid()
    {
        return mUuid;
    }

    public void setUuid(String uuid)
    {
        this.mUuid = uuid;
    }

    public String getTemplateName()
    {
        return mTemplateName;
    }

    public void setTemplateName(String templateName)
    {
        this.mTemplateName = templateName;
    }
}
