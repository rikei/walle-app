import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lipan
 * @version V1.0.0
 * @company lhfinance.com
 * @package PACKAGE_NAME
 * @className: Main
 * @description: xxxxxxxxx
 * @date 2019/11/4 19:30
 */
public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
        DataSource dataSource = (DataSource)context.getBean("dataSource");

        String STATMENT="select current_date FROM DUAL";
        Connection conn = dataSource.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(STATMENT);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Date date = resultSet.getDate("current_date");
            System.out.println(date);
        }

        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new XSThread(dataSource, "thread"+i+1));
        }
        executorService.awaitTermination(100000, TimeUnit.SECONDS);


        Thread.sleep(100000);
    }
}

class XSThread implements Runnable{

    private DataSource dataSource;
    private String name;

    public XSThread(DataSource dataSource, String name) {
        this.dataSource = dataSource;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " 开始获取连接...");
            Connection conn2 = dataSource.getConnection();
            conn2.prepareStatement("select current_date FROM DUAL").execute();
            System.out.println(this.name + " 结束获取连接...");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
