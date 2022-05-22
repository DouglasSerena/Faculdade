import 'package:app_fuel/widgets/submit.form.dart';
import 'package:app_fuel/widgets/success.widget.dart';
import 'package:flutter/material.dart';
import 'package:app_fuel/widgets/logo.widget.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final _gasController = TextEditingController();
  final _alcoolController = TextEditingController();
      

  String _resultText = "Abastecer com alcool";
  bool _completed = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Theme.of(context).primaryColor,
        body: ListView(
          children: [
            const Logo(),
            _completed
                ? Success(
                    result: _resultText,
                    onReset: () {
                      setState(() {
                        _completed = false;
                      });
                    })
                : SubmitForm(
                    gasolineController: _gasController,
                    alcoholController: _alcoolController,
                    onSubmit: (double gasoline, double alcohol) {
                      setState(() {
                        double diff = gasoline * 0.7;
                        if (diff > alcohol) {
                          _resultText = "Abastecer com alcool.";
                        } else {
                          _resultText = "Abastecer com gasolina.";
                        }
                        _completed = true;
                      });
                    },
                  )
          ],
        ));
  }
}
