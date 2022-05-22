import 'package:flutter/material.dart';

import 'LoadButton.widget.dart';

class Success extends StatelessWidget {
  final result;
  final VoidCallback onReset;

  const Success({
    Key? key,
    this.result = "Abastecer com alool",
    required this.onReset,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: Colors.white.withOpacity(0.8),
      ),
      child: Column(children: [
        const SizedBox(height: 50),
        Text(
          result,
          style: TextStyle(
            fontSize: 22,
            fontFamily: "Bangers",
            color: Theme.of(context).primaryColor,
          ),
        ),
        LoadButton(
          onPress: onReset,
          invert: false,
          label: "Calcular de novo",
        ),
      ]),
    );
  }
}
