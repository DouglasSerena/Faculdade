const faker = require(`faker/locale/pt_BR`);
const dayjs = require("dayjs");

module.exports = {
  product: () => faker.commerce.productName(),
  lorem: (amount = 20) => faker.lorem.words(amount),
  foreignKey: (max = 100) => {
    const value = faker.datatype.number(max);
    return value <= 0 ? 1 : value;
  },
  amount: (min = 0, max = 1000) => faker.finance.amount(min, max),
  price: (min = 0.1, max = 100) => faker.commerce.price(min, max),
  fullName: () => `${faker.name.findName()} ${faker.name.lastName()}`,
  dateFormat: (value) => dayjs(value).format("YYYY-MM-DD"),
  date: (
    start = dayjs().set("year", dayjs().year() - 1),
    end = dayjs().set("year", dayjs().year() + 1)
  ) => {
    return dayjs(faker.date.between(
      dayjs(start).format("YYYY-MM-DD"),
      dayjs(end).format("YYYY-MM-DD")
    )).format("YYYY-MM-DD");
  },
};
