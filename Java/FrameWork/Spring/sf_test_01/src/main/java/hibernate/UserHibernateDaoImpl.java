package hibernate;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserHibernateDaoImpl extends HibernateDaoSupport
        implements IUserDao {
    private static final String COUNT_ALL_HQL =
            "select count(*) from UserModel";
    @Override
    public void save(UserModel model) {
        getHibernateTemplate().save(model);
    }
    @Override
    public int countAll() {
        Number count =
                (Number) getHibernateTemplate().find(COUNT_ALL_HQL).get(0);
        return count.intValue();
    }

}
