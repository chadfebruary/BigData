package com.bigdata.app.C4_5;


/**
 * Created by cfebruary on 2017/03/19.
 */
public class Val {
    public String valueName = "";
    public String inClass = "";

    public Val(String name, String inClass)
    {
        this.valueName = new String(name);
        this.inClass = new String(inClass);
    }

    public  boolean isNameEqual(Val inValue)
    {
        if(this.valueName.equals(inValue.valueName))
            return true;
        return false;
    }
}
