import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

import 'package:flutter/services.dart';
import 'package:rich_input/rich_input.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: [
            ElevatedButton(
              onPressed: _setInputText,
              child: Text('test'),
            ),
            // Expanded(child: myRichInput, flex: 1),
            // Expanded(child: Text('haha'), flex: 5),
            TextField(),
            Container(
              height: 60,
              child: buildRichInput(),
            )
          ],
        ),
      ),
    );
  }

  var _count = 0;
  void _setInputText() {
    RichInput.setText('Current count: ${_count++} ');
  }

  final Map<String, dynamic> creationParams = {
    "content": "this is my first native view!!!"
  };

  final _focusNode = FocusNode();

  var viewType = 'com.fanbook.rich_input';

  Widget buildRichInput() {
    return PlatformViewLink(
      viewType: viewType,
      surfaceFactory: (context, controller) {
        return AndroidViewSurface(
          controller: controller,
          gestureRecognizers: const <Factory<OneSequenceGestureRecognizer>>{},
          hitTestBehavior: PlatformViewHitTestBehavior.opaque,
        );
      },
      onCreatePlatformView: (params) {
        return PlatformViewsService.initSurfaceAndroidView(
          id: params.id,
          viewType: viewType,
          layoutDirection: TextDirection.ltr,
          creationParams: creationParams,
          creationParamsCodec: StandardMessageCodec(),
        )
          ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
          ..create();
      },
    );
    // return Focus(
    //   focusNode: _focusNode,
    //   child: AndroidView(
    //     viewType: 'com.fanbook.rich_input',
    //     creationParams: creationParams,
    //     creationParamsCodec: StandardMessageCodec(),
    //   ),
    // );
  }
}
