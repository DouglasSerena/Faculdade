import 'dart:io';

import 'package:btc_calc/config/theme/theme_config.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:path_provider/path_provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

class ThemeCubit extends Cubit<ThemeData> {
  ThemeCubit() : super(themes[THEME.light]!) {
    SharedPreferences.getInstance().then((sharedPreferences) async {
      var theme = sharedPreferences.getString("theme_mode");

      switch (theme) {
        case 'light':
          return changeLight();
        case 'dark':
          return changeDark();
      }
    });
  }

  Future changeLight() async {
    emit(themes[THEME.light]!);
    await _saveFile("light");
    await _readFile();
  }

  Future changeDark() async {
    emit(themes[THEME.dark]!);
    await _saveFile("dark");
    await _readFile();
  }

  Future _readFile() async {
    Directory appDocumentsDirectory = await getApplicationDocumentsDirectory();
    String appDocumentsPath = appDocumentsDirectory.path;
    String filePath = '$appDocumentsPath/theme-mode';

    File file = File(filePath);
    String content = await file.readAsString();

    print('File Content: $content');
  }

  Future _saveFile(String theme) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    sharedPreferences.setString("theme_mode", theme);

    Directory appDocumentsDirectory = await getApplicationDocumentsDirectory();
    String appDocumentsPath = appDocumentsDirectory.path;
    String filePath = '$appDocumentsPath/theme-mode';

    File file = File(filePath);
    file.writeAsString(theme);
  }
}
