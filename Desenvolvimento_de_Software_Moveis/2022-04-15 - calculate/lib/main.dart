import 'package:flutter/material.dart';
import 'package:calculate/application.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

void main() {
  BlocOverrides.runZoned(
    () => runApp(const Application()),
  );
}
