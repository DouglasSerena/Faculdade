import 'package:flutter/material.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          width: double.infinity,
          alignment: Alignment.center,
          padding: const EdgeInsets.only(
            top: 120,
            left: 40,
            right: 40,
          ),
          child: Column(
            children: [
              const Text(
                'Sign in',
                style: TextStyle(
                  fontSize: 30,
                  fontFamily: "OpenSans",
                  fontWeight: FontWeight.bold
                )
              ),
              const SizedBox(height: 30),

              const TextField(
                decoration: InputDecoration(
                  labelText: "Email",
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.email)
                ),
              ),
              const SizedBox(height: 10),

              const TextField(
                decoration: InputDecoration(
                  labelText: "Password",
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.lock)
                ),
              ),

              Row(
                children: [
                  TextButton(
                    onPressed: () => print("OK"),
                    child: const Text("Forgot password?")
                  ),
                ],
                mainAxisAlignment: MainAxisAlignment.end,
              ),

              Row(
                children: [
                  Checkbox(
                    onChanged: (checked) => print(checked),
                    value:  false,
                  ),
                  const Text('Remember me'),
                ],
                mainAxisAlignment: MainAxisAlignment.start,
              ),

              ElevatedButton(
                onPressed: () => print("OK"),
                child: const Center(widthFactor: double.infinity, child: Text('Login'))
              ),
              const SizedBox(height: 10),

              const Text('- OR -'),
              const SizedBox(height: 20),

              const Text('Sign in with'),
              const SizedBox(height: 20),

              Row(
                children: [
                  FloatingActionButton(
                    onPressed: () => print("OK"),
                    backgroundColor: Colors.white,
                    child: const Image(width: 45, height: 45, image: AssetImage("assets/logos/facebook.jpg"),),
                  ),
                  FloatingActionButton(
                    onPressed: () => print("OK"),
                    backgroundColor: Colors.white,
                    child: const Image(width: 45, height: 45, image: AssetImage("assets/logos/google.jpg"),),
                  )
                ],
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              ),
              const SizedBox(height: 20),

              Row(
                children: [
                  const Text('Don\'t have an Account? '),
                  TextButton(
                    onPressed: () => print("OK"),
                    child: const Text('Sign Up')  
                  ),
                ],
                mainAxisAlignment: MainAxisAlignment.center,
              )
            ],
          )
        ),
      )
    );
  }
}
