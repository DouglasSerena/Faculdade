package Jdbc.Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
  private static Connection connect = null;
  private boolean debug = false;

  public Connection getConnect() {
    return connect;
  }

  public Statement getStatement() throws SQLException {
    return connect.createStatement();
  }

  // START
  public Connect() {
    createConnect();
  }

  public Connect(boolean debug) {
    this.debug = debug;
    createConnect();
  }

  // CONNECTION
  private Connection createConnect() {
    if (connect == null) {
      try {
        connect = DriverManager.getConnection("jdbc:sqlite:./data.sqlite");
        return connect;
      } catch (SQLException err) {
        message(err.getMessage());
      }
    }
    return connect;
  }

  public boolean closeConnect() {
    try {
      connect.close();
      return true;
    } catch (SQLException err) {
      message(err.getMessage());
    }
    return false;
  }

  // DEBUG
  public void message(String message) {
    if (debug)
      System.out.println(message);
  }
}