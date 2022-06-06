import 'package:btc_calc/widgets/field_text/validators/text_field_validator.dart';

class TextFieldRequiredValidator extends TextFieldValidate {
  TextFieldRequiredValidator({required String message})
      : super(
          message: message,
          name: "required",
          validator: (text) => text?.isEmpty ?? false,
        );
}
