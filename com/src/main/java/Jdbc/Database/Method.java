package Jdbc.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Method {
  private Connect connect;
  private String tableName;
  private boolean debug = false;

  Method(Connect connect, String tableName, boolean debug) {
    this.tableName = tableName;
    this.debug = debug;
    this.connect = connect;
  }

  Method(Connect connect, String tableName) {
    tableName = tableName;
    this.connect = connect;
  }

  // EXECUTE QUERY
  public boolean query(String query) {
    try {
      Statement statement = this.connect.getStatement();
      statement.execute(query);
      return true;
    } catch (SQLException err) {
      message(err.getMessage());
    }
    return false;
  }

  /**************** QUERY ACTIONS ****************/
  // INSERTE
  public boolean insert(String values) {
    String sql = "INSERT INTO " + tableName + " VALUES(" + values + ");";
    return query(sql);
  }

  // UPDATE
  public boolean update(String fieldsValues, String where) {
    String sql = "UPDATE " + tableName + " SET " + fieldsValues + " WHERE " + where;
    return query(sql);
  }

  // SELECT
  public ResultSet select(String fields) {
    try {
      Statement statement = this.connect.getStatement();
      String sql = "SELECT " + fields + " FROM " + tableName;
      ResultSet result = statement.executeQuery(sql);
      return result;
    } catch (SQLException err) {
      message(err.getMessage());
    }
    return null;
  }

  // DEBUG
  public void message(String message) {
    if (debug)
      System.out.println(message);
  }
}
