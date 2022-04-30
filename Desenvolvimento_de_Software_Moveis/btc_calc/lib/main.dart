import 'package:btc_calc/domain/bitcoin_price_usecase_interface.dart';
import 'package:btc_calc/domain/bitcoin_to_brl_usecase_interface.dart';
import 'package:btc_calc/usecase/bitcoin_convert_usecase.dart';
import 'package:btc_calc/usecase/bitcoin_to_brl_usecase.dart';
import 'package:btc_calc/widgets/app_bar_common_widget.dart';
import 'package:btc_calc/widgets/field_text/text_field_widget.dart';
import 'package:flutter/material.dart';

void main() => runApp(
      MaterialApp(
        home: Home(),
        theme: ThemeData(
          primaryColor: Colors.green,
          inputDecorationTheme: const InputDecorationTheme(
            border: OutlineInputBorder(
              borderSide: BorderSide(color: Colors.green, width: 2),
            ),
          ),
          appBarTheme: const AppBarTheme(
            backgroundColor: Colors.green,
          ),
          elevatedButtonTheme: ElevatedButtonThemeData(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.green),
            ),
          ),
        ),
        debugShowCheckedModeBanner: false,
      ),
    );

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState(
        bitcoinPriceUseCase: BitcoinPriceseCase(),
        bitcoinToBRLUseCase: BitcoinToBRLUseCase(),
      );
}

class _HomeState extends State<Home> {
  final GlobalKey<FormState>? _key = GlobalKey<FormState>();
  final TextEditingController _resultController = TextEditingController();
  final TextEditingController _brlController = TextEditingController();
  final TextEditingController _valueController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();

  IBitcoinPriceUseCase bitcoinPriceUseCase;
  IBitcoinToBRLUseCase bitcoinToBRLUseCase;

  _HomeState({
    required this.bitcoinToBRLUseCase,
    required this.bitcoinPriceUseCase,
  });

  @override
  void initState() {
    super.initState();

    reset();
  }

  void reset() {
    setState(() {
      _priceController.text = "0";
      _valueController.text = "0";
    });
  }

  void onChangeForm() {
    setState(() {
      double result = bitcoinPriceUseCase.calcWithPrice(
        double.parse(_priceController.text),
        double.parse(_valueController.text),
      );
      _brlController.text = bitcoinToBRLUseCase.calc(result).toString();

      _resultController.text = result.toString();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBarCommon(title: 'Converter', actions: <Widget>[
        IconButton(
          onPressed: reset,
          icon: const Icon(Icons.refresh),
        ),
      ]),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20.0),
        child: _buildForm(),
      ),
    );
  }

  Form _buildForm() {
    return Form(
      key: _key,
      onChanged: () => onChangeForm(),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: <Widget>[
          Image.asset("assets/images/logo.jpg"),
          const SizedBox(height: 15),
          TextFieldWidget(
            controller: _priceController,
            label: const Text("Cotação"),
            prefix: const Text("Bitcoin "),
          ),
          const SizedBox(height: 15),
          TextFieldWidget(
            controller: _valueController,
            label: const Text("Valor investido "),
            prefix: const Text("Bitcoin "),
          ),
          const SizedBox(height: 15),
          TextFieldWidget(
            readOnly: true,
            label: const Text("Reais"),
            controller: _brlController,
            prefix: const Text("R\$ "),
          ),
          const SizedBox(height: 15),
          TextFieldWidget(
            readOnly: true,
            label: const Text("Result"),
            controller: _resultController,
            prefix: const Text("Bitcoin "),
          ),
        ],
      ),
    );
  }
}
