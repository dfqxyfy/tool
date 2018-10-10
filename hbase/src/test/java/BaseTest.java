//import org.apache.hadoop.hbase.util.Bytes;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.Result;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//public class BaseTest {
//
//    @Autowired
//    private HbaseTemplate template;
//
//    @Test
//    public void testFind() {
//        List<String> rows = template.find("user", "cf", "name", new RowMapper<String>() {
//            public String mapRow(Result result, int i) throws Exception {
//                return result.toString();
//            }
//        });
//        Assert.assertNotNull(rows);
//    }
//
//    @Test
//    public void testPut() {
//        template.put("user", "1", "cf", "name", Bytes.toBytes("Alice"));
//    }
//}