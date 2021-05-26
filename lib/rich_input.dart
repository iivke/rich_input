import 'dart:async';

import 'package:flutter/services.dart';

class RichInput {
  static const MethodChannel _channel = const MethodChannel('rich_input');

  static Future setText(String content) async {
    await _channel.invokeMethod('setText', content);
  }
}
