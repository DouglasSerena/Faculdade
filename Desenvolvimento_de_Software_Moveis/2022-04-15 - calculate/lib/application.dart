import 'package:calculate/modules/modules.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:calculate/config/theme/theme.dart';

class Application extends StatefulWidget {
  const Application({Key? key}) : super(key: key);

  @override
  State createState() {
    return ApplicationState();
  }
}

class ApplicationState extends State<Application> {
  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (_) => ThemeCubit(),
      child: BlocBuilder<ThemeCubit, ThemeData>(
        builder: _build,
      ),
    );
  }

  Widget _build(BuildContext context, ThemeData state) {
    return MaterialApp(
      theme: state,
      title: 'Aplication',
      home: const CalculateScreen(),
    );
  }
}
