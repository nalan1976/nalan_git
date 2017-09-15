package hibernate;

public interface IUserDao {

    public void save(UserModel user);

    public int countAll();

}