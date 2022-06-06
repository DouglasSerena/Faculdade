import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: const [
              CircleAvatar(
                radius: 100,
                backgroundColor: Colors.white,
                backgroundImage: AssetImage("assets/images/avatar.png"),
              ),
              SizedBox(height: 20),
              Text(
                "Douglas Schneider Serena",
                style: TextStyle(fontSize: 30, fontFamily: "BeauRivage"),
              ),
              Text(
                "Professor",
                style: TextStyle(fontSize: 20, letterSpacing: 2),
              ),
              SizedBox(height: 20),
              Divider(
                thickness: 2,
                indent: 20,
                endIndent: 20,
              ),
              SizedBox(height: 20),
              Card(
                child: Padding(
                  padding: EdgeInsets.all(12),
                  child: ListTile(
                    leading: Icon(Icons.phone),
                    title: Text("Douglas@gmail.com"),
                  ),
                ),
              ),
              Card(
                child: Padding(
                  padding: EdgeInsets.all(12),
                  child: ListTile(
                    leading: Icon(Icons.email),
                    title: Text("Douglas@gmail.com"),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
