/**
 * Created by Yulya Telysheva
 */
package lesson8;


import java.sql.*;

public class SqliteExamples {
    public static void main(String[] args) {
        Connection connection = null;
        //ищем класс, с помощью Class.forName()
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jalexy\\Desktop\\SQLite\\geekbrains.db");

            Statement statement = connection.createStatement();

            statement.executeUpdate("update faculties set name = 'Test1' where id = 1");
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getInt("faculty_id") + "\n");
            }
            /*
            Long time = System.currentTimeMillis();
            //здесь на каждом шаге будет работать автокоммит
            for (int i = 1; i < 100; i++) {
                statement.executeUpdate(String.format("insert into students (name, score, faculty_id) values ('%s', %d, %d)",
                        "student" + i , i, i));
            }
            System.out.println("Время вставки 100 строк = " + (System.currentTimeMillis() - time));

            time = System.currentTimeMillis();
            //убираем автокоммит, время идет намного быстрее, в конце 1 раз закомитим и все
            connection.setAutoCommit(false);
            for (int i = 100; i < 200; i++) {
                statement.executeUpdate(String.format("insert into students (name, score, faculty_id) values ('%s', %d, %d)",
                        "student" + i , i, i));
            }
            connection.commit();
            System.out.println("Время вставки 100 строк без автокоммита = " + (System.currentTimeMillis() - time));
             */

            //подготовленный запрос
            PreparedStatement preparedStatement = connection.prepareStatement("insert into students (name, score, faculty_id) values (?, ?, ?)");

            connection.setAutoCommit(false);
            preparedStatement.setString(1, "Sasha");
            preparedStatement.setInt(2, 100);
            preparedStatement.setInt(3, 3);
            preparedStatement.addBatch();//промежуточное сохранение
            preparedStatement.setString(1, "Oleg");
            preparedStatement.setInt(2, 200);
            preparedStatement.setInt(3, 5);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();//выполнить

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
