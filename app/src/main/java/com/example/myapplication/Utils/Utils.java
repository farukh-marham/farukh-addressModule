package com.example.myapplication.Utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

public class Utils {

    private static Utils ourInstance;

    public static Utils getInstance() {

        if (ourInstance == null) {
            return ourInstance = new Utils();
        } else {
            return ourInstance;
        }
    }

    private Utils() {
    }

    public void startActivityAndPassBundleAndFinish(Activity activity, Class c, Bundle bundle) {
        Intent intent = new Intent(activity, c);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
    public void startActivityAndFinish(Activity activity, Class c) {
        Intent intent = new Intent(activity, c);
        activity.startActivity(intent);
        activity.finish();
    }

    public void startActivity(Activity activity, Class c) {
        Intent intent = new Intent(activity, c);
        activity.startActivity(intent);
    }
}
