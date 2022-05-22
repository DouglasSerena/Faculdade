import 'package:flutter/services.dart';
import 'package:intl/intl.dart';

class CurrencyBrlInputFormatter extends TextInputFormatter {
  @override
  TextEditingValue formatEditUpdate(
    TextEditingValue oldValue,
    TextEditingValue newValue,
  ) {
    if (newValue.selection.baseOffset == 0) {
      return newValue;
    }

    String value = CurrencyBrlInputFormatter.format(newValue.text);

    return newValue.copyWith(
      text: value,
      selection: TextSelection.collapsed(offset: value.length),
    );
  }

  static String format(String text) {
    double value = double.parse(text);
    final formatter = NumberFormat("#,##0.00", "pt_BR");
    return "R\$ " + formatter.format(value / 100);
  }

  static double unformat(String text) {
    return double.parse(
        text.replaceAll(RegExp(r'[R$.]'), "").replaceAll(r',', "."));
  }
}
