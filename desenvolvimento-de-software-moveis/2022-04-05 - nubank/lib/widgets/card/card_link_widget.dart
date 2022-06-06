import 'package:faculdade/widgets/card/card_widget.dart';
import 'package:flutter/material.dart';

class CardLinkWidget extends CardWidget {
  Widget? icon;
  String title;

  CardLinkWidget({
    Key? key,
    this.icon,
    required this.title,
    required onTab,
    required child,
  }) : super(
          key: key,
          onTab: onTab,
          child: Column(
            children: [
              icon ?? const SizedBox.shrink(),
              Row(
                children: [
                  Text(
                    title,
                    style: const TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 18,
                    ),
                  ),
                  const Icon(Icons.arrow_forward_ios_outlined),
                ],
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
              ),
              const SizedBox(height: 10),
              child,
            ],
            crossAxisAlignment: CrossAxisAlignment.start,
          ),
        );
}
