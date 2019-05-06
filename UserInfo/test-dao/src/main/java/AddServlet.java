import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Properties;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbpassword = properties.getProperty("db.password");
            String driverClassname = properties.getProperty("db.driverClassName");

            Class.forName(driverClassname);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbpassword);
        }
        catch (IOException | SQLException | ClassNotFoundException e)
        {
            throw new IllegalStateException(e);
        }
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
    /*Cобираем запрос канкатинируем строки выполняем sql запрос*/
    /*разобраться в с датой в базе данных и сделать уже наконец ебанна рот*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String middleName = req.getParameter("middle-name");
        String lastName = req.getParameter("last-name");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String genderUser = req.getParameter("gender");


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO data_user(first_name, middle_name, last_name, birth_date, gender) VALUES (?,?,?,?,?::gender)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2,  middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDate(4,  java.sql.Date.valueOf(birthDate));
            if (genderUser.equals("F"))
                preparedStatement.setString(5, User.gendertype.FEMALE.toString());
            else
                preparedStatement.setString(5, User.gendertype.MALE.toString());
            preparedStatement.execute();

        }
        catch(SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
