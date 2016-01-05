package com.cordovatest;

import org.apache.cordova.CordovaPlugin;

/**
 * Created by mikeshi on 2016/1/5.
 */
public class MyCordovaPlugin extends CordovaPlugin {
    @Override
    public Boolean shouldAllowRequest(String url) {
        return true;
    }

    @Override
    public boolean onOverrideUrlLoading(String url) {
        return true;
    }

}
