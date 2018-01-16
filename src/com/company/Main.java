package com.company;

import java.sql.*;
import java.util.Scanner;
public class Main {
    static String url = "jdbc:postgresql://localhost/";
    static String user = "postgres";
    static String pass = "";
    static PreparedStatement preparedstat_update_zal, preparedstat_delete_zal, preparedstat1, preparedstat2,preparedstat3, preparedstat4,preparedstat_add_client, preparedstat_add_abonement, preparedstat_add_trainer, preparedstat_add_zal = null;
    static ResultSet res1, res2, res3, res4 = null;
    static Connection conn;
    static Scanner in = new Scanner(System.in);


    private static void menu() throws SQLException {
        System.out.println("\n *** Меню *** \n");
        System.out.println("1: Добавить данные в таблицу");
        System.out.println("2: Удалить данные из таблицы");
        System.out.println("3: Изменить данные из таблицы");
        System.out.println("4: Просмиотр");
        System.out.println("5: Выход");

        boolean exit = true;
        while (exit){
            System.out.println("\n Выберите пункт:");
            int ur = in.nextInt();
            switch (ur){
                case 1: select_add_in_table(); break;
                case 2: select_drop_in_table(); break;
                case 3: update_in_table(); break;
                case 4: select_view(); break;
                case 5: exit = false; System.exit(0); break;

            }
        }
    }

    //     ********** ФУНКЦИИ ИЗМЕНЕНИЯ ЗАПИСЕЙ *************
    private static void update_in_table() throws SQLException {
        System.out.println("1: Изменить данные в таблице zal");
        System.out.println("2: Изменить данные в таблице trainer");
        System.out.println("3: Изменить данные в таблице abonement");
        System.out.println("4: Изменить данные в таблице client");
        System.out.println("5: Изменить данные в таблице registration");
        System.out.println("6: Назад");


        while (true){
            int ur=in.nextInt();
            switch (ur){
                case 1: update_zal(); break;
                case 2: update_trainer(); break;
                case 3: update_abonement(); break;
                case 4: update_client(); break;
                case 5: update_registration(); break;
                case 6: menu(); break;
            }

        }
    }


    private static void update_registration() {

    }

    private static void update_client() {

    }

    private static void update_abonement() {

    }

    private static void update_trainer() {

    }

    private static void update_zal() throws SQLException {
        System.out.println("введите id зала");
        Scanner id_zal_scanner = new Scanner(System.in);
        int id_zal = id_zal_scanner.nextInt();
        System.out.println("введите название зала");
        Scanner name_zal_scanner = new Scanner(System.in);
        String name_zal = name_zal_scanner.nextLine();
        System.out.println("введите площадь зала");
        Scanner area_zal_scanner = new Scanner(System.in);
        String area_zal = area_zal_scanner.nextLine();
        preparedstat_update_zal = conn.prepareStatement("UPDATE zal SET zal_name = ?, area = ? WHERE id_zal = ?");
        preparedstat_update_zal.setString(1, name_zal);
        preparedstat_update_zal.setString(2, area_zal);
        preparedstat_update_zal.setInt(3, id_zal);
        preparedstat_update_zal.executeUpdate();
        System.out.println("Данные изменены");
        menu();
    }



    //    ********** ФУНКЦИИ УДАЛЕНИЯ ЗАПИСЕЙ *************
    private static void select_drop_in_table() throws SQLException {
        System.out.println("1: Удалить данные из таблицы zal");
        System.out.println("2: Удалить данные из таблицы trainer");
        System.out.println("3: Удалить данные из таблицы abonement");
        System.out.println("4: Удалить данные из таблицы client");
        System.out.println("5: Удалить данные из таблицы registration");
        System.out.println("6: Назад");

        while (true){
            int ur=in.nextInt();
            switch (ur){
                case 1: delete_zal(); break;
                case 2: delete_trainer(); break;
                case 3: delete_abonement(); break;
                case 4: delete_client(); break;
                case 5: delete_registration(); break;
                case 6: menu(); break;
            }

        }
    }
    private static void delete_zal() throws SQLException {
        System.out.println("введите название зала");
        Scanner name_zal_scanner = new Scanner(System.in);
        String name = name_zal_scanner.nextLine();
        preparedstat_delete_zal = conn.prepareStatement("DELETE FROM zal WHERE zal_name = ?");
        preparedstat_delete_zal.setString(1, name);
        preparedstat_delete_zal.executeUpdate();
        System.out.println("Данные удалены");
        menu();
    }

    private static void delete_registration() {

    }

    private static void delete_client() {

    }

    private static void delete_abonement() {

    }


    private static void delete_trainer() {

    }



    //    ********** ФУНКЦИИ ДОБАВЛЕНИЯ ЗАПИСЕЙ *************
    private static void select_add_in_table() throws SQLException {
        System.out.println("1: Добавить данные в таблицу zal");
        System.out.println("2: Добавить данные в таблицу trainer");
        System.out.println("3: Добавить данные в таблицу abonement");
        System.out.println("4: Добавить данные в таблицу client");
        System.out.println("5: Добавить данные в таблицу registration");
        System.out.println("6: Назад");

        while (true){
            int ur=in.nextInt();
            switch (ur){
                case 1: add_zal(); break;
                case 2: add_trainer(); break;
                case 3: add_abonement(); break;
                case 4: add_client(); break;
                case 5: add_registration(); break;
                case 6: menu(); break;
            }

        }
    }

    private static void add_registration() {

    }

    private static void add_client() throws SQLException {
        System.out.println("Введите имя");
        Scanner first_name_scanner = new Scanner(System.in);
        String first_name_client = first_name_scanner.nextLine();
        System.out.println("введите фамилию");
        Scanner last_name_scanner = new Scanner(System.in);
        String last_name_client = last_name_scanner.nextLine();
        System.out.println("введите номер телефона");
        Scanner phone_scanner = new Scanner(System.in);
        String phone_client = phone_scanner.nextLine();
        System.out.println("введите id тренера");
        Scanner id_trainer = new Scanner(System.in);
        int id_trainer_client = id_trainer.nextInt();
        preparedstat_add_client = conn.prepareStatement("INSERT INTO client(first_name,last_name,phone, id_trainer) VALUES(?, ?, ?,?)");
        preparedstat_add_client.setString(1,first_name_client);
        preparedstat_add_client.setString(2,last_name_client);
        preparedstat_add_client.setString(3, phone_client);
        preparedstat_add_client.setInt(4, id_trainer_client);
        preparedstat_add_client.executeUpdate();
        System.out.println("Данные добавлены");
        menu();
    }

    private static void add_abonement() throws SQLException {
        System.out.println("Введите описание");
        Scanner description_scanner = new Scanner(System.in);
        String description_abonement = description_scanner.nextLine();
        System.out.println("введите цену");
        Scanner price_scanner = new Scanner(System.in);
        int price_abonement =  price_scanner.nextInt();
        System.out.println("введите код зала");
        Scanner id_zal_scanner = new Scanner(System.in);
        int id_zal_abonement =  id_zal_scanner.nextInt();
        preparedstat_add_abonement = conn.prepareStatement("INSERT INTO abonement(description,price,id_zal) VALUES(?, ?, ?)");
        preparedstat_add_abonement.setString(1,description_abonement);
        preparedstat_add_abonement.setInt(2,price_abonement);
        preparedstat_add_abonement.setInt(3, id_zal_abonement);
        preparedstat_add_abonement.executeUpdate();
        System.out.println("Данные добавлены");
        menu();
    }

    private static void add_zal() throws SQLException {
        System.out.println("введите название зала");
        Scanner name_zal_scanner = new Scanner(System.in);
        String name = name_zal_scanner.nextLine();
        System.out.println("введите площадь зала");
        Scanner area_scanner = new Scanner(System.in);
        String area = area_scanner.nextLine();
        preparedstat_add_zal = conn.prepareStatement("INSERT INTO zal(zal_name,area) VALUES(?, ?)");
        preparedstat_add_zal.setString(1, name);
        preparedstat_add_zal.setString(2, area);
        preparedstat_add_zal.executeUpdate();
        System.out.println("Данные добавлены");
        menu();

    }

    private static void add_trainer() throws SQLException {
        System.out.println("введите имя тренера");
        Scanner first_name_trianner_scanner = new Scanner(System.in);
        String first_name_trainer = first_name_trianner_scanner.nextLine();
        System.out.println("введите фамилию тренера");
        Scanner last_name_trianner_scanner = new Scanner(System.in);
        String last_name_trainer = last_name_trianner_scanner.nextLine();
        System.out.println("введите оклад тренера");
        Scanner salary_trianner_scanner = new Scanner(System.in);
        int salary = salary_trianner_scanner.nextInt();
        preparedstat_add_trainer = conn.prepareStatement("INSERT INTO trainer(first_name,last_name,salary) VALUES(?, ?,?)");
        preparedstat_add_trainer.setString(1,first_name_trainer);
        preparedstat_add_trainer.setString(2, last_name_trainer);
        preparedstat_add_trainer.setInt(3,salary);
        preparedstat_add_trainer.executeUpdate();
        System.out.println("Данные добавлены");
        menu();
    }


    // ********** ЗАПРОСЫ *************
    private static void select_view() throws SQLException {
        System.out.println("1: Вычислить премию 40 процентов для тренеров у которых клиентов больше 2");
        System.out.println("2: Список клиентов, которые не заплатили");
        System.out.println("3: Список клиентов, которые занимаются в январе");
        System.out.println("4: Список клиентов с именем Владимир и у которых тренера зовут Андрей");
        System.out.println("5: Назад");

        while (true){
            int ur=in.nextInt();
            switch (ur){
                case 1: prize(); break;
                case 2: not_pay(); break;
                case 3: go_month(); break;
                case 4: name_coincidence(); break;
                case 5: menu(); break;
            }

        }
    }


    //      клиент Владимир, тренер Андрей
    private static void name_coincidence() throws SQLException {
        System.out.println("введите имя клиента");
        Scanner name_client_scanner = new Scanner(System.in);
        String name_client_sql = name_client_scanner.nextLine();
        System.out.println("введите имя тренера");
        Scanner name_trainer_scanner = new Scanner(System.in);
        String name_trainer_sql = name_trainer_scanner.nextLine();
        preparedstat4 = conn.prepareStatement("select client.first_name, client.last_name, trainer.first_name, trainer.last_name from client, trainer where client.first_name = ? and trainer.first_name = ?");
        preparedstat4.setString(1,name_client_sql);
        preparedstat4.setString(2,name_trainer_sql);
        res4 = preparedstat4.executeQuery();
        while (res4.next()){
            System.out.println(res4.getString(1) + " " + res4.getString(2) + " " + res4.getString(3) + " " +res4.getString(4));
        }
        menu();
    }

    //    январь
    private static void go_month() throws SQLException {
        System.out.println("введите месяц");
        Scanner month_scanner = new Scanner(System.in);
        String month_sql = month_scanner.nextLine();
        preparedstat3 = conn.prepareStatement("SELECT client.id_client, client.first_name, client.last_name FROM client WHERE (((client.id_client) IN (SELECT registration.id_client FROM registration WHERE (registration.month)=?)))");
        preparedstat3.setString(1, month_sql);
        res3 = preparedstat3.executeQuery();
        while (res3.next()){
            System.out.println(res3.getInt(1) + " " + res3.getString(2) + " " + res3.getString(3));
        }
        menu();
    }

    //    false
    private static void not_pay() throws SQLException {
        System.out.println("введите true или false");
        Scanner false_scanner = new Scanner(System.in);
        boolean false_true_scanner = false_scanner.nextBoolean();
        preparedstat2 = conn.prepareStatement("SELECT client.id_client, client.last_name, registration.pass_pay FROM client INNER JOIN registration ON client.id_client = registration.id_client WHERE ((registration.pass_pay)=?)");
        preparedstat2.setBoolean(1, false_true_scanner);
        res2 = preparedstat2.executeQuery();
        while (res2.next()){
            System.out.println(res2.getInt(1) + " " + res2.getString(2) + " " + res2.getBoolean(3));
        }
        menu();
    }

    //     больше 2
    private static void prize() throws SQLException {
        System.out.println("введите количество клиентов");
        Scanner col_client_scanner = new Scanner(System.in);
        int col_client = col_client_scanner.nextInt();
        preparedstat1 = conn.prepareStatement("SELECT trainer.id_trainer, trainer.last_name, Count(client.id_client) AS number, (salary)*0.4 AS premium FROM trainer INNER JOIN client ON trainer.id_trainer=client.id_trainer GROUP BY trainer.id_trainer, trainer.last_name, (salary)*0.4 HAVING (((Count(client.id_client))> ?))");
        preparedstat1.setInt(1, col_client);
        res1 = preparedstat1.executeQuery();
        while(res1.next()){
            System.out.println(res1.getInt(1) + " " + res1.getString(2) + " " + res1.getInt(3) + " " + res1.getInt(4));
        }
        menu();
    }

    static {
        try {
            conn = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        try (Statement stat = conn.createStatement()) {
            System.out.println("Соединение установлено");
            try {
                stat.executeUpdate("CREATE DATABASE java_database");
            } catch (SQLException e) {
                System.out.println("База данных уже создана");
            }


/*   ********** УДАЛЕНИЕ ТАБЛИЦ *************  

            stat.executeUpdate("DROP TABLE client CASCADE ");
            stat.executeUpdate("DROP TABLE abonement CASCADE ");
            stat.executeUpdate("DROP TABLE trainer CASCADE ");
            stat.executeUpdate("DROP TABLE zal CASCADE ");
            stat.executeUpdate("DROP TABLE registration CASCADE ");
*/



 // ********** СОЗДАНИЕ ТАБЛИЦ *************   

            String create_table_zal = "CREATE TABLE IF NOT EXISTS zal" +
                    "(id_zal SERIAL NOT NULL, " +
                    "zal_name VARCHAR(30) NOT NULL, " +
                    "area VARCHAR(10) NOT NULL, " +
                    "PRIMARY KEY (id_zal))";
            stat.executeUpdate(create_table_zal);

            String create_table_trainer = "CREATE TABLE IF NOT EXISTS trainer " +
                    "(id_trainer SERIAL NOT NULL, " +
                    "first_name VARCHAR(30) NOT NULL, " +
                    "last_name VARCHAR(30) NOT NULL, " +
                    "salary INTEGER NOT NULL, " +
                    "PRIMARY KEY (id_trainer))";
            stat.executeUpdate(create_table_trainer);

            String create_table_abonement = "CREATE TABLE IF NOT EXISTS abonement " +
                    "(id_abonement SERIAL NOT NULL, " +
                    "description VARCHAR(30) NOT NULL, " +
                    "price INTEGER NOT NULL, " +
                    "id_zal INTEGER NOT NULL, " +
                    "PRIMARY KEY (id_abonement), " +
                    "FOREIGN KEY (id_zal) REFERENCES zal(id_zal))";
            stat.executeUpdate(create_table_abonement);

            String create_table_client = "CREATE TABLE IF NOT EXISTS client " +
                    "(id_client SERIAL NOT NULL, " +
                    "first_name VARCHAR(30) NOT NULL, " +
                    "last_name VARCHAR(30) NOT NULL, " +
                    "phone VARCHAR(30), " +
                    "id_trainer INTEGER, " +
                    "PRIMARY KEY (id_client), " +
                    "FOREIGN KEY (id_trainer) REFERENCES trainer(id_trainer))";
            stat.executeUpdate(create_table_client);

            String create_table_registration = "CREATE TABLE IF NOT EXISTS registration " +
                    "(id_registration SERIAL NOT NULL, " +
                    "id_client INTEGER NOT NULL, " +
                    "id_abonement INTEGER NOT NULL, " +
                    "month VARCHAR(30) NOT NULL, " +
                    "pass_pay BOOLEAN, " +
                    "PRIMARY KEY (id_registration)," +
                    "FOREIGN KEY (id_abonement) REFERENCES abonement(id_abonement), " +
                    "FOREIGN KEY (id_client) REFERENCES client(id_client))";
            stat.executeUpdate(create_table_registration);


//  ********** ЗАПОЛНЕНИЕ ТАБЛИЦ *************  

            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('бассейн', '40m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('бассейн', '60m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('бассейн детский', '20m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('тренажерный 1', '220m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('тренажерный 2', '180m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('фитнес', '80m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('бокс', '50m')");
            stat.executeUpdate("INSERT INTO zal(zal_name,area) VALUES('сауна', '15m')");

            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Андрей', 'Медведев','15000')");
            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Михаил', 'Пушкин','25000')");
            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Петр', 'Петров','12500')");
            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Алексей', 'Алексеев','21300')");
            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Мария', 'Листкова','9800')");
            stat.executeUpdate("INSERT INTO trainer(first_name,last_name,salary) VALUES('Дарья', 'Петрова','28000')");

            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Владимир', 'Чайнов','89589877559','1')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Алексей', 'Коробков','89574589625','2')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Мария', 'Волгина','89879511557','4')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Елена', 'Медведева','89634569815','3')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Максим', 'Зубов','89877659158','6')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Андрей', 'Ключов','89577845896','5')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Олег', 'Мажоров','89877415987','5')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Владимир', 'Егоров','89877985225','5')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Ольга', 'Шмелева','89844595887','1')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Егор', 'Мальцев','8985487995','1')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Кристина', 'Карпова','89855987651','2')");
            stat.executeUpdate("INSERT INTO client(first_name,last_name,phone,id_trainer) VALUES('Владимир', 'Литов','89833655971','5')");

            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1000','1')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1200','2')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '800','3')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1600','4')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1400','5')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1000','6')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1200','7')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('целый месяц', '1200','8')");

            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '800','1')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '1000','2')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '600','3')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '1300','4')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '1100','5')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '800','6')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '800','7')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('8 раз в месяц', '950','8')");

            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '600','1')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '800','2')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '500','3')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '1000','4')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '850','5')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '650','6')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '600','7')");
            stat.executeUpdate("INSERT INTO abonement(description,price,id_zal) VALUES('4 раз в месяц', '700','8')");

            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('1', '1','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('2', '11','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('3', '13','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('4', '4','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('5', '5','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('6', '20','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('7', '4','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('8', '10','january','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('9', '24','december','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('10', '11','december','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('11', '1','december','false')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('12', '9','december','true')");
            stat.executeUpdate("INSERT INTO registration(id_client, id_abonement, month, pass_pay) VALUES('12', '9','august','true')");



 //   ********** ИЗМЕНЕНИЕ ЗАПИСЕЙ ************* 

            stat.executeUpdate("UPDATE abonement SET price = price*1.2");
            stat.executeUpdate("DELETE FROM registration WHERE (registration.month='august')");


            menu();

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }            
        }
}
}
























