import 'package:flutter/material.dart';

class CalculateDisplayScreenBlock extends StatefulWidget {
  const CalculateDisplayScreenBlock({Key? key}) : super(key: key);

  @override
  State<CalculateDisplayScreenBlock> createState() =>
      _CalculateDisplayScreenBlockState();
}

class _CalculateDisplayScreenBlockState
    extends State<CalculateDisplayScreenBlock> {
  final TextEditingController _controller = TextEditingController();

  _CalculateDisplayScreenBlockState() : super();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: MediaQuery.of(context).size.height * 0.20,
      decoration: BoxDecoration(
        color: Theme.of(context).cardColor,
        borderRadius: const BorderRadius.only(
          bottomLeft: Radius.circular(16),
          bottomRight: Radius.circular(16),
        ),
      ),
      child: Container(
        padding: const EdgeInsets.all(16),
        child: Center(
          child: TextField(
            autofocus: true,
            textAlign: TextAlign.end,
            keyboardType: TextInputType.none,
            controller: _controller,
            style: const TextStyle(
              fontSize: 60,
            ),
            decoration: const InputDecoration(
              border: InputBorder.none,
            ),
          ),
        ),
      ),
    );
  }
}
