import 'package:faculdade/modules/home/widgets/account_home_widget.dart';
import 'package:faculdade/modules/home/widgets/find_out_more_home_widget.dart';
import 'package:faculdade/modules/home/widgets/header_home_widget.dart';
import 'package:faculdade/modules/home/widgets/options_home_widget.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  double _height = 0;
  final List<dynamic> _infos = [
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
  final List<dynamic> _fabs = [
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
      body: Stack(
        children: [
          Container(
            width: double.infinity,
            height: _height,
            color: Colors.purple,
            child: const Center(
              child: CircularProgressIndicator(
                color: Colors.white,
              ),
            ),
          ),
          RefreshIndicator(
            triggerMode: RefreshIndicatorTriggerMode.anywhere,
            onRefresh: () async {
              await Future.delayed(const Duration(milliseconds: 3000));
              print("refresh");
            },
            child: NotificationListener<ScrollNotification>(
              onNotification: (scrollNotification) {
                setState(() {
                  if (scrollNotification.metrics.pixels > 0) {
                    _height = 0;
                  } else {
                    _height = (-scrollNotification.metrics.pixels) +
                        MediaQuery.of(context).padding.top +
                        10;
                  }
                });
                return true;
              },
              child: SingleChildScrollView(
                physics: const BouncingScrollPhysics(),
                child: Column(
                  children: [
                    const HeaderHomeWidget(),
                    AccountHomeWidget(fabs: _fabs),
                    const OptionsHomeWidget(),
                    FindOutMoreHomeWidget(infos: _infos)
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
