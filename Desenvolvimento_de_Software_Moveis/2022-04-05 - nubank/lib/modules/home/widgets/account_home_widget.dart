import 'package:faculdade/widgets/button/button_widget.dart';
import 'package:faculdade/widgets/card/card_link_widget.dart';
import 'package:faculdade/widgets/fab/fab_widget.dart';
import 'package:flutter/material.dart';

class AccountHomeWidget extends StatelessWidget {
  final List<dynamic> fabs;

  const AccountHomeWidget({Key? key, required this.fabs}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        CardLinkWidget(
          title: "Conta",
          onTab: () => print("tab"),
          child: Column(
            children: const [
              Text(
                "R\$ 1.356,95",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 24,
                ),
              ),
            ],
          ),
        ),
        Container(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          child: Column(
            children: [
              SizedBox(
                height: 110,
                child: ListView.builder(
                  itemCount: fabs.length,
                  scrollDirection: Axis.horizontal,
                  physics: const BouncingScrollPhysics(),
                  itemBuilder: (context, index) {
                    dynamic fab = fabs[index];

                    return SizedBox(
                      width: 75,
                      child: Column(
                        children: [
                          const SizedBox(width: 5),
                          Column(children: [
                            FabWidget(
                              color: const Color.fromARGB(10, 0, 0, 0),
                              padding: const EdgeInsets.all(20),
                              onPressed: () => print("tab"),
                              child: Icon(fab["icon"]),
                            ),
                            const SizedBox(height: 10),
                            Text(fab["label"], textAlign: TextAlign.center)
                          ]),
                          const SizedBox(width: 5),
                        ],
                      ),
                    );
                  },
                ),
              ),
              const SizedBox(height: 20),
              ButtonWidget.icon(
                onPressed: () => print("OK"),
                icon: const Icon(Icons.payments),
                label: Row(
                  children: const [
                    Text('Meus cartões'),
                    Text("3"),
                  ],
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                ),
              )
            ],
          ),
        ),
      ],
    );
  }
}
