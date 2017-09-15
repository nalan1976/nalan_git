package hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Transactional
public class HibernateTest2 {
    @Test
    public void testCURD() {
        String[] configLocations = new String[]{
//                "classpath:chapter7/applicationContext-resources.xml",
                "applicationContext-hbt2.xml"};
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(configLocations);
        HibernateTemplate hibernateTemplate =
                ctx.getBean(HibernateTemplate.class);

        hibernateTemplate.setCheckWriteOperations(false);

        UserModel2 model = new UserModel2();
        model.setMyName("test");
        insert(hibernateTemplate, model);
        select(hibernateTemplate, model);
        //以下2个操作不成功，原因未知
        update(hibernateTemplate, model);
        delete(hibernateTemplate, model);
    }

    private void insert(HibernateTemplate hibernateTemplate, UserModel2 model) {
        hibernateTemplate.save(model);
    }

    private void select(HibernateTemplate hibernateTemplate, UserModel2 model) {
        UserModel2 model2 = hibernateTemplate.get(UserModel2.class, 1);
        Assert.assertEquals(model2.getMyName(), model.getMyName());
        List<UserModel2> list = (List<UserModel2>)hibernateTemplate.find("from UserModel2");
        Assert.assertEquals(list.get(0).getMyName(), model.getMyName());
    }

    private void update(HibernateTemplate hibernateTemplate, UserModel2 model) {
        UserModel2 model2 = hibernateTemplate.get(UserModel2.class, 1);
        model2.setMyName("test2");
        hibernateTemplate.update(model2);
/**原代码
 *  model.setMyName("test2");
        hibernateTemplate.update(model);*/
//        hibernateTemplate.getSessionFactory().getCurrentSession().flush();
//        org.springframework.orm.hibernate5.SessionFactoryUtils.getDataSource().getConnection().get HibernateSessionFactoryUtil.
    }

    private void delete(HibernateTemplate hibernateTemplate, UserModel2 model) {
        hibernateTemplate.delete(model);
//        hibernateTemplate.getSessionFactory().getCurrentSession().flush();
    }
}
