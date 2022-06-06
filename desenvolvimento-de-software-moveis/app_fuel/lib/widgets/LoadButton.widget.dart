import 'package:flutter/material.dart';

class LoadButton extends StatelessWidget {
  final VoidCallback onPress;
  final String label;
  final bool invert;

  const LoadButton({
    Key? key,
    required this.invert,
    this.label = "Calcular",
    required this.onPress,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(24),
      decoration: BoxDecoration(borderRadius: BorderRadius.circular(20)),
      child: ElevatedButton(
        onPressed: onPress,
        child: Text(
          label,
          style: const TextStyle(color: Colors.white, fontFamily: "Bangers"),
        ),
        style: ElevatedButton.styleFrom(
          primary: invert ? Colors.amberAccent : Colors.blueGrey,
          onSurface: Colors.red,
        ),
      ),
    );
  }
}
