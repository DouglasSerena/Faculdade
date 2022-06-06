import 'package:faculdade/modules/modules.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Application extends StatelessWidget {
  const Application({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    SystemChrome.setSystemUIOverlayStyle(const SystemUiOverlayStyle(
      statusBarColor: Colors.purple,
    ));

    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: const Color(0x00612f74),
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(
            primary: Colors.blueGrey[900],
          ),
        ),
      ),
      home: HomeScreen(),
    );
  }
}
