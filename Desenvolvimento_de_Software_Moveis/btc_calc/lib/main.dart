import 'package:btc_calc/widgets/app_bar_common_widget.dart';
import 'package:btc_calc/widgets/field_text/field_text_widget.dart';
import 'package:btc_calc/widgets/field_text/validators/field_text_required_validator.dart';
import 'package:flutter/material.dart';
import 'Bitcoin.dart';

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
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final GlobalKey<FormState>? _key = GlobalKey<FormState>();
  final TextEditingController? _cotacaoController = TextEditingController();
  final TextEditingController? _valorController = TextEditingController();
  String _resultado = "Valor";

  @override
  void initState() {
    super.initState();

    _clear();
  }

  void _reset() {
    _cotacaoController?.text = "";
    _valorController?.text = "";
  }

  void _clear() {
    _reset();
    setState(() {
      _resultado = "Informe os valores";
    });
  }

  void onCalculate() {
    Bitcoin btc = Bitcoin();
    btc.cotacao = double.parse(_cotacaoController!.text);
    btc.valor = double.parse(_valorController!.text);
    _reset();
    setState(() {
      _resultado = btc.calcular();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBarCommon(title: 'Converter', actions: <Widget>[
        IconButton(
          onPressed: _clear,
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
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: <Widget>[
          FieldTextWidget(
            controller: _cotacaoController,
            label: const Text("Cotação do Bitcon"),
            validators: [
              FieldTextRequiredValidator(message: "Informe a cotação do BTC"),
            ],
          ),
          const SizedBox(height: 15),
          FieldTextWidget(
            controller: _valorController,
            label: const Text("Valor investido do Bitcon"),
            validators: [
              FieldTextRequiredValidator(message: "Informe o valor do BTC"),
            ],
          ),
          const SizedBox(height: 15),
          Text(
            _resultado,
            textAlign: TextAlign.center,
            style: const TextStyle(
              fontSize: 18,
              fontWeight: FontWeight.w600,
            ),
          ),
          ElevatedButton(
            child: const Text("Cotar"),
            onPressed: () {
              if (_key!.currentState!.validate()) {
                onCalculate();
              }
            },
          )
        ],
      ),
    );
  }
}
