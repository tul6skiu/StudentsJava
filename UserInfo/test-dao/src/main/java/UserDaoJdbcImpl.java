import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJdbcImpl implements UsersDao{

    /* language=SQL */
    private final String SQL_SELECT_ALL =
            "SELECT * FROM data_user";

    /* language=SQL */
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM  data_user WHERE id = ?";

    /* language=SQL */
    private final String SQL_DELETE =
            "DELETE FROM data_user WHERE id = ?";

    /* language=SQL */
    private final String UPDATE_USER =
            "UPDATE data_user SET  first_name=?, middle_name=?, last_name=?, birth_date=?, gender=?::gender WHERE id=?";



    private Connection connection;

    public  UserDaoJdbcImpl (DataSource dataSource) {

        try {
            this.connection = dataSource.getConnection();
        }
        catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }

    }



    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        try
        {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String firstName = resultSet.getString("firs_name");
                String lastName = resultSet.getString("last_name");
                String middleName = resultSet.getString("middle_name");
                Date birthDate = resultSet.getDate("birth_date");
                String  genderUser = resultSet.getString("gender");
                Optional.of(new User(id, firstName, middleName, lastName, birthDate, genderUser));

            }
            return  Optional.empty();
        }
        catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }
    }




    @Override
    public void update(User model) {
        try{
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);

            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getMiddleName());
            statement.setString(3, model.getLastName());
            statement.setDate(4,(model.getBirthDate()));
            statement.setString(5,model.getGender());
            statement.setInt(6, model.getId());



            int rows  = statement.executeUpdate();
            System.out.printf("Updated %d rows", rows);
        }
        catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delet(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, Integer.valueOf(id));
            statement.execute();
        }catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {

        try
        {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next())
            {
                Integer id =resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String middleName = resultSet.getString("middle_name");
                Date birthDate = resultSet.getDate("birth_date");
                String genderUser = resultSet.getString("gender");


                User user = new User(id, firstName, middleName, lastName, birthDate, genderUser);
                users.add(user);
            }
            return  users;
        }catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }


    }
}