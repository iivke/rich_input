package com.example.rich_input;

import androidx.annotation.NonNull;

import com.example.rich_input.editview.MyEditViewFactory;
import com.example.rich_input.nativeview.NativeViewFactory;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * RichInputPlugin
 */
//public class RichInputPlugin implements FlutterPlugin, MethodCallHandler {
//    /// The MethodChannel that will the communication between Flutter and native Android
//    ///
//    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
//    /// when the Flutter Engine is detached from the Activity
//    private MethodChannel channel;
//    public static final String VIEW_TYPE_ID = "com.fanbook.rich_input";
//
//    @Override
//    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
//        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "rich_input");
//        channel.setMethodCallHandler(this);
//        BinaryMessenger messenger = flutterPluginBinding.getBinaryMessenger();
//
//        flutterPluginBinding
//                .getPlatformViewRegistry()
//                .registerViewFactory(VIEW_TYPE_ID, new NativeViewFactory(flutterPluginBinding.getBinaryMessenger()));
//    }
//
//    @Override
//    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
//        if (call.method.equals("getPlatformVersion")) {
//            result.success("Android " + android.os.Build.VERSION.RELEASE);
//        } else if (call.method.equals("sayHi")) {
//            String name = (String) call.arguments;
//            result.success("Welcome, " + name);
//        } else {
//            result.notImplemented();
//        }
//    }
//
//    @Override
//    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
//        channel.setMethodCallHandler(null);
//    }
//}

public class RichInputPlugin implements FlutterPlugin {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;
    public static final String VIEW_TYPE_ID = "com.fanbook.rich_input";

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
//        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "rich_input");
//        channel.setMethodCallHandler(this);
        BinaryMessenger messenger = flutterPluginBinding.getBinaryMessenger();

//        flutterPluginBinding
//                .getPlatformViewRegistry()
//                .registerViewFactory(VIEW_TYPE_ID, new NativeViewFactory(flutterPluginBinding.getBinaryMessenger()));
        flutterPluginBinding
                .getPlatformViewRegistry()
                .registerViewFactory(VIEW_TYPE_ID, new MyEditViewFactory(flutterPluginBinding.getBinaryMessenger()));
    }

//    @Override
//    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
//        if (call.method.equals("getPlatformVersion")) {
//            result.success("Android " + android.os.Build.VERSION.RELEASE);
//        } else if (call.method.equals("sayHi")) {
//            String name = (String) call.arguments;
//            result.success("Welcome, " + name);
//        } else {
//            result.notImplemented();
//        }
//    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
//        channel.setMethodCallHandler(null);
    }
}