import 'package:btc_calc/domain/bitcoin_price_usecase_interface.dart';

class BitcoinPriceseCase extends IBitcoinPriceUseCase {
  @override
  double price = 190270.84;

  @override
  double calc(double value) {
    return calcWithPrice(value, price);
  }

  @override
  double calcWithPrice(double value, double price) {
    return value / price;
  }
}
