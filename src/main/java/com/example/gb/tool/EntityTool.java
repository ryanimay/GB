package com.example.gb.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

/**
 * packageName和import要自己加
 * 20230226
 */
//@SpringBootApplication
public class EntityTool implements CommandLineRunner {
    private final String tableName = "admin";
    //entity輸出路徑+名稱
    private String root = "C:\\Users\\user\\Desktop\\tool\\";
    private String beanPath = root + "model\\po\\" + upperFirstChar(rename(tableName)) + ".java";
    private String repositoryPath = root + "model\\repository\\" + upperFirstChar(rename(tableName)) + "Repository.java";
    private String servicePath = root + "service\\" + upperFirstChar(rename(tableName)) + "Service.java";
    private String url;
    private String username;
    private String password;

    @Autowired
    private Environment env;

//    public static void main(String[] args) {
//        SpringApplication.run(EntityTool.class, args);
//    }

    @Override
    public void run(String... args) throws Exception {
        url = env.getProperty("spring.datasource.url");
        username = env.getProperty("spring.datasource.username");
        password = env.getProperty("spring.datasource.password");

        System.out.println(tableName);
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("Database name: " + metaData.getDatabaseProductName());
            System.out.println("Database version: " + metaData.getDatabaseProductVersion());
            String className = upperFirstChar(rename(tableName));
            System.out.println("寫入路徑:" + root);

            createBean(metaData, className);
            createRepository(metaData, className);
            createService(className);
        }
    }

    private void createBean(DatabaseMetaData metaData, String className) throws IOException, SQLException {
        System.out.println("createBean");
        ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
        ResultSet pk = metaData.getPrimaryKeys(null, null, tableName);
        FileWriter fw = new FileWriter(createFile(beanPath));
        StringBuilder sb = new StringBuilder();
        //Header
        sb.append("@Entity\n");
        sb.append("@Table(name=\"" + tableName + "\")\n");
        sb.append("public class " + className + " {\n");
        StringBuilder properties = new StringBuilder();
        StringBuilder getterSetter = new StringBuilder();
        //body
        while (resultSet.next()) {
            String columnName = resultSet.getString("COLUMN_NAME");
            String columnType = resultSet.getString("TYPE_NAME");
            int columnSize = resultSet.getInt("COLUMN_SIZE");
            boolean isNullable = resultSet.getBoolean("NULLABLE");
            boolean isAutoincrement = "YES".equals(resultSet.getString("IS_AUTOINCREMENT"));
            //properties
            if(isPk(pk, columnName)) properties.append("    @Id\n");
            if(isAutoincrement) properties.append("    @GeneratedValue(strategy = GenerationType.IDENTITY)\n");
            properties.append("    @Column(name = \"" + columnName + "\")\n");
            properties.append("    private " + handleType(columnType) + " " + rename(columnName) + ";\n");
            //getter/setter
            getterSetter.append("    public " + handleType(columnType) + " get" + upperFirstChar(rename(columnName)) + "() {return " + rename(columnName) + ";}\n");
            getterSetter.append("    public void set" + upperFirstChar(rename(columnName)) + "(" + handleType(columnType) + " " + rename(columnName) + ") {this." + rename(columnName) + " = " + rename(columnName) + ";}\n");
        }
        sb.append(properties);
        sb.append("\n");
        sb.append(getterSetter);
        sb.append("}");
        fw.write(sb.toString());
        fw.close();
    }
    private void createRepository(DatabaseMetaData metaData, String className) throws IOException, SQLException {
        System.out.println("createRepository");
        ResultSet pk = metaData.getPrimaryKeys(null, null, tableName);
        FileWriter fw = new FileWriter(createFile(repositoryPath));
        StringBuilder sb = new StringBuilder();
        if (pk.next()) {
            String columnName = pk.getString("COLUMN_NAME");
            pk = metaData.getColumns(null, null, tableName, columnName);
            if(pk.next()){
                String columnType = pk.getString("TYPE_NAME");
                sb.append("@Repository\n");
                sb.append("public interface " + className + "Repository extends JpaRepository<" + className + "," + handleType(columnType) + ">{\n");
                sb.append("}");
                fw.write(sb.toString());
                fw.close();
            }
        }
    }
    private void createService(String className) throws IOException, SQLException {
        System.out.println("createService");
        FileWriter fw = new FileWriter(createFile(servicePath));
        StringBuilder sb = new StringBuilder();
        sb.append("@Service\n");
        sb.append("@Transactional\n");
        sb.append("public class " + className + "Service {\n");
        sb.append("    @Autowired\n");
        sb.append("    private " + className + "Repository mapper;\n");
        sb.append("}");
        fw.write(sb.toString());
        fw.close();
    }

    /**
     * '_'命名拆成駝峰
     */
    private String rename(String name) {
        if (name.contains("_")) {
            String[] arr = name.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)));
                sb.append(arr[i].substring(1));
            }
            return sb.toString();
        }
        return name;
    }

    private String upperFirstChar(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private File createFile(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    private String handleType(String type) {
        return switch (type.toUpperCase()) {
            case "INT" -> "Integer";
            case "DOUBLE" -> "Double";
            case "DATETIME" -> "Date";
            default -> "String";
        };
    }

    private boolean isPk(ResultSet rs, String columnName) throws SQLException {
        while(rs.next()){
            if(columnName.equals(rs.getString("COLUMN_NAME"))) return true;
        }
        return false;
    }

}
