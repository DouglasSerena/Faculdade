import 'package:app_fuel/helpers/currency_brl_input_formatter.dart';
import 'package:flutter/material.dart';
import 'LoadButton.widget.dart';
import 'package:app_fuel/widgets/input.widget.dart';

class SubmitForm extends StatelessWidget {
  TextEditingController gasolineController = TextEditingController();
  TextEditingController alcoholController = TextEditingController();
  bool busy = false;
  final void Function(double gasoline, double alcohol) onSubmit;

  SubmitForm({
    Key? key,
    required this.gasolineController,
    required this.alcoholController,
    required this.onSubmit,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: Colors.white.withOpacity(0.8),
      ),
      child: Column(
        children: [
          Input(label: "Gasolina", controller: gasolineController),
          Input(label: "Alcool", controller: alcoholController),
          LoadButton(
            invert: false,
            label: "Calcular",
            onPress: () {
              onSubmit(
                CurrencyBrlInputFormatter.unformat(gasolineController.text),
                CurrencyBrlInputFormatter.unformat(alcoholController.text),
              );
            },
          ),
        ],
      ),
    );
  }
}
