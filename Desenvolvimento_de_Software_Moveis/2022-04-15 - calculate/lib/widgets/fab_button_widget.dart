import 'package:flutter/material.dart';

class FabButton extends StatelessWidget {
  VoidCallback onPressed;
  Widget child;
  double? size;
  Color? backgroundColor;

  FabButton({
    Key? key,
    this.size,
    this.backgroundColor,
    required this.child,
    required this.onPressed,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: AspectRatio(
        aspectRatio: 1,
        child: Material(
          color: backgroundColor ?? Theme.of(context).backgroundColor,
          shape: const CircleBorder(),
          child: InkWell(
            onTap: onPressed,
            borderRadius: BorderRadius.circular(10000),
            child: Align(
              alignment: Alignment.center,
              widthFactor: 1.0,
              heightFactor: 1.0,
              child: child,
            ),
          ),
        ),
      ),
    );
  }
}
