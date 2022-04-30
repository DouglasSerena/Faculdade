import 'package:faculdade/widgets/fab/fab_widget.dart';
import 'package:flutter/material.dart';

class HeaderHomeWidget extends StatelessWidget {
  const HeaderHomeWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(top: MediaQuery.of(context).padding.top),
      decoration: const BoxDecoration(
        color: Colors.purple,
      ),
      padding: const EdgeInsets.all(20),
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
    );
  }
}
