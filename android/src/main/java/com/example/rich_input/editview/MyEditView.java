package com.example.rich_input.editview;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class MyEditView implements PlatformView, MethodChannel.MethodCallHandler {
    private final EditText mEditText;
    private final MethodChannel methodChannel;
    private static final String TAG = "MyEditView";

    public MyEditView(Context context, int id, Map<String, Object> creationParams, BinaryMessenger
            messenger) {
        mEditText = new EditText(context);
        mEditText.setTextSize(16);
        mEditText.setHeight(44);
        mEditText.setMaxLines(1);
        mEditText.setBackgroundColor(Color.rgb(255, 200, 200));
        String content = (String) creationParams.get("content");
        mEditText.setText(content);

        methodChannel = new MethodChannel(messenger, "rich_input");
        methodChannel.setMethodCallHandler(this);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: " + s.toString());
            }
        });
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d(TAG, "onEditorAction: " + actionId + "   event: " + event);
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                } else if (actionId == EditorInfo.IME_ACTION_PREVIOUS) {

                }
                return false;
            }
        });

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if (call.method.equals("setText")) {
            result.success(null);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public View getView() {
        return mEditText;
    }

    @Override
    public void dispose() {
        methodChannel.setMethodCallHandler(null);
    }
}
