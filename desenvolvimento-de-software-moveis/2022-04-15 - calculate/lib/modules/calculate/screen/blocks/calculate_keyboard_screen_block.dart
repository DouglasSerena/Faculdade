import 'package:calculate/widgets/fab_button_widget.dart';
import 'package:flutter/material.dart';

class CalculateKeyboardScreenBlock extends StatelessWidget {
  const CalculateKeyboardScreenBlock({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Row(
              children: [
                FabButton(
                  backgroundColor: Colors.greenAccent.shade100,
                  child: const Text("AC", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Text("( )", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Icon(Icons.percent, size: 30),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Icon(Icons.remove, size: 30),
                  onPressed: () => print("OK"),
                ),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              children: [
                FabButton(
                  child: const Text("7", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("8", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("9", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Icon(Icons.close, size: 30),
                  onPressed: () => print("OK"),
                ),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              children: [
                FabButton(
                  child: const Text("4", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("5", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("6", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Icon(Icons.remove, size: 30),
                  onPressed: () => print("OK"),
                ),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              children: [
                FabButton(
                  child: const Text("1", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("2", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text("3", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.blueAccent.shade100,
                  child: const Icon(Icons.add, size: 30),
                  onPressed: () => print("OK"),
                ),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              children: [
                FabButton(
                  child: const Text("0", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Text(",", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  child: const Icon(Icons.backspace, size: 30),
                  onPressed: () => print("OK"),
                ),
                const SizedBox(width: 10),
                FabButton(
                  backgroundColor: Colors.lightBlueAccent.shade100,
                  child: const Text("=", style: TextStyle(fontSize: 30)),
                  onPressed: () => print("OK"),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
