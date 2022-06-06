abstract class IBitcoinPriceUseCase {
  abstract double price;
  double calc(double value);
  double calcWithPrice(double value, double price);
}
