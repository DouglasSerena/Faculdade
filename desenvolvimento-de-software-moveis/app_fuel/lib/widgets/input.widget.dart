import 'package:app_fuel/helpers/currency_brl_input_formatter.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Input extends StatelessWidget {
  String label;
  late TextEditingController controller;

  Input({
    Key? key,
    this.label = "",
    TextEditingController? controller,
  }) : super(key: key) {
    this.controller = controller ?? TextEditingController();
    this.controller.text = CurrencyBrlInputFormatter.format("0");
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(4.0),
      child: Row(
        children: [
          Container(
            width: 80,
            alignment: Alignment.centerRight,
            child: Text(
              label,
              style: const TextStyle(
                fontSize: 22,
                color: Colors.black,
                fontFamily: "Bangers",
              ),
            ),
          ),
          const SizedBox(width: 20),
          Expanded(
            child: Container(
              color: Theme.of(context).focusColor,
              child: TextFormField(
                controller: controller,
                inputFormatters: [
                  FilteringTextInputFormatter.digitsOnly,
                  CurrencyBrlInputFormatter()
                ],
                textAlign: TextAlign.right,
                style: const TextStyle(color: Colors.black, fontSize: 24),
                decoration: const InputDecoration(
                  contentPadding: EdgeInsets.all(8),
                  labelText: "Digite o valor",
                  prefixIcon: Icon(
                    Icons.calculate,
                    color: Colors.black,
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
