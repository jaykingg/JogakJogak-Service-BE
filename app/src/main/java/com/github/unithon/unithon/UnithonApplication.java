package com.github.unithon.unithon;

import android.app.Application;

public class UnithonApplication extends Application {

    private static Application globalApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        globalApplication = this;
    }

    public static Application getGlobalApplication() {
        return globalApplication;
    }
}
