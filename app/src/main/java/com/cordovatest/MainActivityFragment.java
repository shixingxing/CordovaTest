package com.cordovatest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;

public class MainActivityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        SystemWebView systemWebView = (SystemWebView) view.findViewById(R.id.cordova_webview);
        ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(getActivity());//这里会解析res/xml/config.xml配置文件
        //创建一个cordovawebview
        CordovaWebView cordovaWebView = new CordovaWebViewImpl(
                new SystemWebViewEngine(systemWebView));
        cordovaWebView.init(new CordovaInterfaceImpl(getActivity()), parser.getPluginEntries(),
                parser.getPreferences());//初始化
        systemWebView.loadUrl("http://html5test.com/");

        return view;
    }
}
