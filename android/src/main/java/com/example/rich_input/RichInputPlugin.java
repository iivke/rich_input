package com.example.rich_input;

import androidx.annotation.NonNull;

import com.example.rich_input.editview.MyEditViewFactory;

import io.flutter.embedding.engine.plugins.FlutterPlugin;

/**
 * RichInputPlugin
 */
public class RichInputPlugin implements FlutterPlugin {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    public static final String VIEW_TYPE_ID = "com.fanbook.rich_input";

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
//        flutterPluginBinding
//                .getPlatformViewRegistry()
//                .registerViewFactory(VIEW_TYPE_ID, new NativeViewFactory(flutterPluginBinding.getBinaryMessenger()));
        flutterPluginBinding
                .getPlatformViewRegistry()
                .registerViewFactory(VIEW_TYPE_ID, new MyEditViewFactory(flutterPluginBinding.getBinaryMessenger()));
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }
}