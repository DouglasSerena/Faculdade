import 'package:flutter/material.dart';

class AppBarCommon extends AppBar {
  AppBarCommon({Key? key, required String title, List<Widget>? actions})
      : super(
          key: key,
          actions: actions,
          title: Text(title),
        );
}
