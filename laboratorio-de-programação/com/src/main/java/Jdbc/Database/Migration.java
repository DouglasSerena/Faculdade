package Jdbc.Database;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Jdbc.Utils.Color;
import Jdbc.Utils.Console;

public class Migration {
  public Migration(Connect connect, boolean dropTable) {
    this.createMigrations(connect, dropTable);
  }

  public Migration(Connect connect) {
    this.createMigrations(connect, false);
  }

  public void createMigrations(Connect connect, boolean dropTable) {
    ArrayList<String> sqls = new ArrayList<>();

    String migrations = "./com/src/main/java/Jdbc/Database/migrations/";
    File files = new File(migrations);
    String[] pathnames = files.list();

    for (String pathname : pathnames) {
      String sql = "create table if not exists ";

      try {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fabrica.newDocumentBuilder();
        Document document = builder.parse(migrations + pathname);

        NodeList tableNode = document.getElementsByTagName("TABLE");
        Element tableEl = (Element) tableNode.item(0);
        NodeList nomeNode = tableEl.getElementsByTagName("NAME");
        Element nomeEl = (Element) nomeNode.item(0);
        sql += nomeEl.getTextContent() + "(\n";

        if (dropTable) {
          try {
            Statement conn = connect.getStatement();
            String drop = "DROP TABLE IF EXISTS " + nomeEl.getTextContent() + ";";
            conn.execute(drop);
          } catch (SQLException err) {
            this.message(err.getMessage());
          }
        }

        NodeList fieldsNode = tableEl.getElementsByTagName("FIELD");

        for (int index = 0; index < fieldsNode.getLength(); index++) {
          NodeList fieldNode = fieldsNode.item(index).getChildNodes();

          for (int i = 0; i < fieldNode.getLength(); i++) {
            Node element = fieldNode.item(i);

            switch (element.getNodeName()) {
              case "NAME":
                sql += element.getTextContent() + " ";
                break;
              case "TYPE":
                sql += element.getTextContent() + " ";
                break;
              case "LENGTH":
                sql += "(" + element.getTextContent() + ") ";
                break;
              case "NOTNULL":
                sql += "NOT NULL ";
                break;
              case "AUTOINCREMENT":
                sql += "AUTOINCREMENT ";
                break;
              case "PRIMARYKEY":
                sql += "PRIMARY KEY ";
                break;
            }
          }
          sql += index != fieldsNode.getLength() - 1 ? ",\n" : "\n";
        }
        sqls.add(sql + ");");
      } catch (SAXException err) {
        Console.log(err.getMessage());
      } catch (IOException err) {
        Console.log(err.getMessage());
      } catch (ParserConfigurationException err) {
        Console.log(err.getMessage());
      }
    }

    for (String sql : sqls) {
      try {
        Statement conn = connect.getStatement();
        conn.execute(sql);
      } catch (SQLException err) {
        this.message(err.getMessage());
      }
    }

    Console.log(Color.tag("DATABASE", Color.YELLOW_BOLD) + " Migrations Created");
  }

  // DEBUG
  public void message(String message) {
    Console.log(message);
  }
}
