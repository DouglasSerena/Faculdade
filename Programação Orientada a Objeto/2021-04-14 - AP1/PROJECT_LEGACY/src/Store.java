import java.util.ArrayList;

public class Store {
  private static ArrayList<String> cpfs = new ArrayList<String>();
  private static ArrayList<String> numbersAccount = new ArrayList<String>();

  public static boolean existCpf(String cpf) {
    for (String value : Store.cpfs)
      if (value.equals(cpf))
        return true;
    return false;
  }

  public static void pushCpf(String cpf) {
    cpfs.add(cpf);
  }

  public static boolean existNumberAccount(String number) {
    for (String value : Store.numbersAccount)
      if (value.equals(number))
        return true;
    return false;
  }

  public static void pushNumberAccount(String number) {
    numbersAccount.add(number);
  }
}