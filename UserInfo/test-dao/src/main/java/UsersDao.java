import java.util.List;

public interface UsersDao  extends  Model<User>{
    List<User> findAllByFirstName(String firstName);
}