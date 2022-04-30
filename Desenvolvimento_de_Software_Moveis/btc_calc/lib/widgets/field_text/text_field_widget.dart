import 'package:btc_calc/widgets/field_text/validators/text_field_validator.dart';
import 'package:flutter/material.dart';

class TextFieldWidget extends StatelessWidget {
  Widget? label;
  Widget? prefix;
  Widget? suffix;
  bool readOnly;
  TextInputType? keyboardType;
  InputDecoration? decoration;
  void Function(String)? onChanged;
  List<TextFieldValidate>? validators;
  TextEditingController controller;

  TextFieldWidget({
    Key? key,
    this.label,
    this.prefix,
    this.suffix,
    this.onChanged,
    this.validators,
    this.decoration,
    this.keyboardType,
    this.readOnly = false,
    required this.controller,
  }) : super(key: key);

  String? onValidator(String? text) {
    if (validators != null) {
      for (TextFieldValidate validator in validators!) {
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
      readOnly: readOnly,
      onChanged: onChanged,
      validator: onValidator,
      controller: controller,
      keyboardType: keyboardType,
      decoration: InputDecoration(
        label: label,
        prefix: prefix,
        suffix: suffix,
      ),
    );
  }
}
