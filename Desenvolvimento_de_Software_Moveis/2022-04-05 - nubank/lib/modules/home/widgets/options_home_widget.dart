import 'package:faculdade/widgets/card/card_link_widget.dart';
import 'package:flutter/material.dart';

class OptionsHomeWidget extends StatelessWidget {
  const OptionsHomeWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const SizedBox(height: 10),
        const Divider(thickness: 2, height: 2),
        CardLinkWidget(
          icon: const Icon(Icons.credit_card_outlined),
          title: "Cartão de crédito",
          onTab: () => print("tab"),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Fatura atual",
                style: Theme.of(context).textTheme.subtitle1,
              ),
              const SizedBox(height: 10),
              const Text(
                "R\$ 1.356,95",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 26,
                ),
              ),
              const SizedBox(height: 10),
              Text(
                "Limite disponivel: R\$ 730,00",
                style: Theme.of(context).textTheme.subtitle1,
              ),
            ],
          ),
        ),
        const Divider(thickness: 2, height: 2),
        CardLinkWidget(
          icon: const Icon(Icons.account_balance_outlined),
          title: "Empréstimo",
          onTab: () => print("tab"),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Até R\$ 9.600 disponível para você",
                style: Theme.of(context).textTheme.subtitle1,
              ),
            ],
          ),
        ),
        const Divider(thickness: 2, height: 2),
        CardLinkWidget(
          icon: const Icon(Icons.favorite_border_outlined),
          title: "Seguro de vida",
          onTab: () => print("tab"),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Um seguro completo e que cabe no bolso",
                style: Theme.of(context).textTheme.subtitle1,
              ),
            ],
          ),
        ),
        const Divider(thickness: 2, height: 2),
        const SizedBox(height: 20),
      ],
    );
  }
}
