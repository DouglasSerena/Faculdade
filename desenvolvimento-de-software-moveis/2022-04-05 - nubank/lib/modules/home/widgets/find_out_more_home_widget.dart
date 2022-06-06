import 'package:faculdade/widgets/card/card_widget.dart';
import 'package:flutter/material.dart';

class FindOutMoreHomeWidget extends StatelessWidget {
  final List<dynamic> infos;

  const FindOutMoreHomeWidget({Key? key, required this.infos})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.only(left: 20, right: 20, bottom: 20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text("Descubra mais", style: Theme.of(context).textTheme.titleLarge),
          const SizedBox(height: 10),
          SizedBox(
            height: 100,
            child: ListView.separated(
              itemCount: infos.length,
              scrollDirection: Axis.horizontal,
              physics: const BouncingScrollPhysics(),
              separatorBuilder: (context, index) => const SizedBox(width: 20),
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
                            fontSize: 16, fontWeight: FontWeight.w600),
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
    );
  }
}
