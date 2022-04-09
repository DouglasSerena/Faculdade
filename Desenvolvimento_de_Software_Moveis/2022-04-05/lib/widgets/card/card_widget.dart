import 'package:flutter/material.dart';

class CardWidget extends StatelessWidget {
  final Widget child;
  final void Function()? onTab;
  final Color? color;
  final Decoration? decoration;
  final double? width;
  final double? height;

  const CardWidget({
    Key? key,
    this.color,
    this.width,
    this.height,
    this.decoration,
    this.onTab,
    required this.child,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    if (onTab != null) {
      return InkWell(
        onTap: onTab,
        child: Container(
          child: child,
          color: color,
          width: width,
          height: height,
          decoration: decoration,
          padding: const EdgeInsets.all(20),
        ),
      );
    }
    return Container(
      child: child,
      color: color,
      width: width,
      height: height,
      decoration: decoration,
      padding: const EdgeInsets.all(20),
    );
  }
}
