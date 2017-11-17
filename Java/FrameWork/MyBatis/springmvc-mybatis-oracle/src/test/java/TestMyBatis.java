import com.nalan.batis.dao.ITest;
import org.junit.Assert;
import org.junit.Test;

public class TestMyBatis {
    ITest dao;
    @Test
    public void TestMain(){

        dao.insertTest(1, "nalan", "1234");
    }

    public void setDao(ITest dao) {
        this.dao = dao;
    }

    public ITest getDao() {
        return dao;
    }
}
