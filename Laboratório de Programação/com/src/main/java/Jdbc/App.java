package Jdbc;

import Jdbc.Database.Connect;
import Jdbc.Database.Migration;

public class App {
  public static void main(String[] args) {
    Connect connect = new Connect();

    new Migration(connect);

    // try {
    // while(result.next()) {
    // System.out.println("ID: " + result.getInt("id"));
    // System.out.println("NAME: " + result.getString("name"));
    // System.out.println("AGE: " + result.getInt("age"));
    // }
    // } catch(SQLException err) {
    // System.out.println(err.getMessage());
    // }
  }
}
