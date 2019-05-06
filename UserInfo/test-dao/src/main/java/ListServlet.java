import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

@WebServlet("/users")
public class ListServlet extends HttpServlet {
    private UsersDao usersDao;


    @Override
    public void init() throws ServletException{
        Properties properties = new Properties();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        try{
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/test-dao/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbpassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");


            dataSource.setUrl(dbUrl);
            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbpassword);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UserDaoJdbcImpl(dataSource);
        }
        catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersDao.findAll();
        req.setAttribute("usersFromServer",users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/users.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("delete");
        String update = req.getParameter("update");

        if (update != null){

            Integer id2 = Integer.valueOf(req.getParameter("update"));
            String firstName = req.getParameter("first-name");
            String lastName = req.getParameter("last-name");
            String middleName = req.getParameter("middle-name");
            Date birthDate = Date.valueOf(req.getParameter("birthDate"));
            String genderUser = req.getParameter("gender");


            User user = new User(id2, firstName, middleName, lastName, birthDate, genderUser);

            usersDao.update(user);
        }
        if (id != null) {
            usersDao.delet(Integer.valueOf(id));
        }

    }

}
