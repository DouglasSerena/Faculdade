import 'package:btc_calc/widgets/field_text/validators/field_text_validator.dart';

class FieldTextRequiredValidator extends FieldTextValidate {
  FieldTextRequiredValidator({required String message})
      : super(
          message: message,
          name: "required",
          validator: (text) => text?.isEmpty ?? false,
        );
}
