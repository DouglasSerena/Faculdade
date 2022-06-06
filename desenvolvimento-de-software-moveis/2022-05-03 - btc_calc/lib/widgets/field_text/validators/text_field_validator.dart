class TextFieldValidate {
  String name;
  String message;
  bool Function(String?) validator;

  TextFieldValidate({
    required this.name,
    required this.message,
    required this.validator,
  });
}
