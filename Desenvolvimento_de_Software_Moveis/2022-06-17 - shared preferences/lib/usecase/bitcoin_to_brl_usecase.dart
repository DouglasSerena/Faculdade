import 'package:btc_calc/domain/bitcoin_to_brl_usecase_interface.dart';

class BitcoinToBRLUseCase extends IBitcoinToBRLUseCase {
  @override
  double priceBitcoin = 190270.84;

  @override
  double calc(double value) {
    double result = priceBitcoin / value;
    
    return result.isNaN ? 0 : result;
  }
}
