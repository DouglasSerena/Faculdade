import 'package:calculate/modules/calculate/screen/blocks/calculate_display_screen_block.dart';
import 'package:calculate/modules/calculate/screen/blocks/calculate_keyboard_screen_block.dart';
import 'package:flutter/material.dart';

class CalculateScreen extends StatefulWidget {
  const CalculateScreen({Key? key}) : super(key: key);

  @override
  State<CalculateScreen> createState() => _CalculateScreenState();
}

class _CalculateScreenState extends State<CalculateScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: const [
            CalculateDisplayScreenBlock(),
            CalculateKeyboardScreenBlock()
          ],
        ),
      ),
    );
  }
}
