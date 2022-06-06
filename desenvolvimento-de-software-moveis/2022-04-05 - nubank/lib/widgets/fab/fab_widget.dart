import 'package:flutter/material.dart';

class FabWidget extends StatelessWidget {
  final Color? color;
  final EdgeInsetsGeometry? padding;
  final Widget child;
  final void Function()? onPressed;

  const FabWidget(
      {Key? key,
      this.color,
      this.padding,
      required this.onPressed,
      required this.child})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return InkWell(
      customBorder: const CircleBorder(),
      onTap: onPressed,
      child: Container(
        padding: padding ?? const EdgeInsets.all(10),
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: color,
        ),
        child: child,
      ),
    );
  }
}
