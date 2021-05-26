package com.example.rich_input.nativeview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.reflect.Method;
import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class NativeView implements PlatformView, MethodChannel.MethodCallHandler {
    private final TextView textView;
    private final MethodChannel methodChannel;

    public NativeView(Context context, int id, Map<String, Object> creationParams, BinaryMessenger messenger) {
        textView = new TextView(context);
        textView.setTextSize(16);
        textView.setHeight(44);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        String content = (String) creationParams.get("content");
        textView.setText(content);

        methodChannel = new MethodChannel(messenger, "rich_input");
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void dispose() {
        methodChannel.setMethodCallHandler(null);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if (call.method.equals("setText")) {
            String content = (String) call.arguments;
            textView.setText(content);
            result.success(null);
        } else {
            result.notImplemented();
        }
    }
}
