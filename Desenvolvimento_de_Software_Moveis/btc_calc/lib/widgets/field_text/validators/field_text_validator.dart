class FieldTextValidate {
  String name;
  String message;
  bool Function(String?) validator;

  FieldTextValidate({
    required this.name,
    required this.message,
    required this.validator,
  });
}
