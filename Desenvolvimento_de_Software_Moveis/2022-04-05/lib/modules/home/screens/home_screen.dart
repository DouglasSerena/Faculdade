import 'package:faculdade/widgets/button/button_widget.dart';
import 'package:faculdade/widgets/card/card_link_widget.dart';
import 'package:faculdade/widgets/card/card_widget.dart';
import 'package:faculdade/widgets/fab/fab_widget.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final double price = 1356.98;
  final List<dynamic> infos = [
    {
      "title": "Convidar amigos",
      "description":
          "Tire seus amigos da fila do banco e livre eles da burocracia."
    },
    {
      "title": "Shipping",
      "description": "Tem shopping no se bank. Conheça agora."
    },
    {
      "title": "Empréstimo",
      "description": "Você tem até R\$ 8.100,00 disponíveis para empréstimo"
    },
  ];
  final List<dynamic> fabs = [
    {"icon": Icons.pix, "label": "Pix"},
    {"icon": Icons.qr_code, "label": "Pagar"},
    {"icon": Icons.move_up_outlined, "label": "Transferir"},
    {"icon": Icons.move_down_outlined, "label": "Depositar"},
    {"icon": Icons.account_balance_outlined, "label": "Pegar emprestado"},
    {"icon": Icons.phone_iphone_outlined, "label": "Recarga de celular"},
    {"icon": Icons.local_atm_outlined, "label": "Cobrar"},
    {"icon": Icons.favorite_border_outlined, "label": "Doação"},
    {"icon": Icons.language_outlined, "label": "Transferia internac."},
  ];

  _HomeScreenState();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: RefreshIndicator(
        triggerMode: RefreshIndicatorTriggerMode.anywhere,
        onRefresh: () async {
          await Future.delayed(const Duration(milliseconds: 3000));
          print("refresh");
        },
        child: SingleChildScrollView(
          physics: const BouncingScrollPhysics(),
          child: Column(
            children: [
              Container(
                decoration: const BoxDecoration(
                  color: Colors.purple,
                ),
                padding: EdgeInsets.only(
                  top: MediaQuery.of(context).padding.top + 20,
                  left: 20,
                  bottom: 20,
                  right: 20,
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        FabWidget(
                          color: const Color.fromARGB(30, 255, 255, 255),
                          onPressed: () => print("OK"),
                          child: const Icon(
                            Icons.person_outline,
                            color: Colors.white,
                          ),
                        ),
                        Row(children: [
                          FabWidget(
                            onPressed: () => print("OK"),
                            child: const Icon(
                              Icons.visibility_outlined,
                              color: Colors.white,
                            ),
                          ),
                          const SizedBox(height: 10),
                          FabWidget(
                            onPressed: () => print("OK"),
                            child: const Icon(
                              Icons.info_outline,
                              color: Colors.white,
                            ),
                          ),
                          const SizedBox(height: 10),
                          FabWidget(
                            onPressed: () => print("OK"),
                            child: const Icon(
                              Icons.person_add_alt,
                              color: Colors.white,
                            ),
                          ),
                        ])
                      ],
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    ),
                    const SizedBox(height: 20),
                    const Text(
                      "Olá, Douglas",
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 20,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ],
                ),
              ),
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
                padding:
                    const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
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
                                  Text(fab["label"],
                                      textAlign: TextAlign.center)
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
              Container(
                padding: const EdgeInsets.only(left: 20, right: 20, bottom: 20),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text("Descubra mais",
                        style: Theme.of(context).textTheme.titleLarge),
                    const SizedBox(height: 10),
                    SizedBox(
                      height: 100,
                      child: ListView.separated(
                        itemCount: infos.length,
                        scrollDirection: Axis.horizontal,
                        physics: const BouncingScrollPhysics(),
                        separatorBuilder: (context, index) =>
                            const SizedBox(width: 20),
                        itemBuilder: (context, index) {
                          dynamic info = infos[index];

                          return CardWidget(
                            width: MediaQuery.of(context).size.width - 100,
                            decoration: BoxDecoration(
                              color: Colors.grey.shade200,
                              borderRadius: BorderRadius.circular(10),
                            ),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  info["title"],
                                  style: const TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.w600),
                                ),
                                const SizedBox(height: 5),
                                Text(
                                  info["description"],
                                  maxLines: 2,
                                  style: Theme.of(context).textTheme.bodyText2,
                                )
                              ],
                            ),
                          );
                        },
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
