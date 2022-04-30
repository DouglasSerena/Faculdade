import 'package:btc_calc/widgets/field_text/validators/field_text_validator.dart';
import 'package:flutter/material.dart';

class FieldTextWidget extends StatelessWidget {
  Widget? label;
  late String initialValue;
  TextInputType? keyboardType;
  InputDecoration? decoration;
  void Function(String)? onChanged;
  List<FieldTextValidate>? validators;
  late TextEditingController controller;

  FieldTextWidget({
    Key? key,
    this.label,
    this.onChanged,
    this.validators,
    this.decoration,
    this.keyboardType,
    this.initialValue = "",
    TextEditingController? controller,
  }) : super(key: key) {
    this.controller = controller ?? TextEditingController();

    this.controller.text = initialValue;
  }

  String? onValidator(String? text) {
    if (validators != null) {
      for (FieldTextValidate validator in validators!) {
        if (validator.validator(text)) {
          return validator.message;
        }
      }
    }

    return null;
  }

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      onChanged: onChanged,
      validator: onValidator,
      controller: controller,
      keyboardType: keyboardType,
      decoration: InputDecoration(
        label: label,
      ),
    );
  }
}
