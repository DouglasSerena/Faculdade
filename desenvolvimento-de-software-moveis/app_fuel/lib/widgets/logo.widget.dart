import 'package:flutter/material.dart';

class Logo extends StatelessWidget {
  const Logo({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const SizedBox(
          height: 48,
        ),
        Image.asset(
          "assets/images/gas-pump.png",
          height: 120,
        ),
        const SizedBox(
          height: 16,
        ),
        const Text("Alcool ou gasolina",
            style: TextStyle(
                color: Colors.white, fontSize: 24, fontFamily: "Bangers"),
            textAlign: TextAlign.center),
        const SizedBox(
          height: 16,
        ),
      ],
    );
  }
}
