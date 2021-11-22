package com.wizard.phonelock;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;

public class LockScreen extends AccessibilityService {
    public LockScreen() {
    }



    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onServiceConnected(){
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = 32;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                Build.VERSION.SDK_INT < 23 ? 2006 : 2032,
                256, -3);
        params.x = 0;
        params.y = 0;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(displayMetrics);
        params.width = displayMetrics.widthPixels;
        params.height = displayMetrics.heightPixels;
        FrameLayout layout = new FrameLayout(getApplicationContext(), null);
        layout.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        View v = View.inflate(this, R.layout.lock_screen, null);
        v.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        EditText input = v.findViewById(R.id.lock_input);
        input.setText("Edited");
        layout.addView(v);
        manager.addView(layout, params);
    }
}