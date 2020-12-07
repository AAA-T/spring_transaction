package cn.huiyusheng;

import cn.huiyusheng.entity.User;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 悔余生
 * @ClassName:JDBCTest
 * @Description:TODO
 * @Date 2020/12/7 上午10:44
 * @Version V1.0
 **/
public class JDBCTest {

    ClassPathXmlApplicationContext ioc;

    @Before
    public void before(){
         ioc = new ClassPathXmlApplicationContext("spring.xml"); //创建 Spring 的 IOC 容器
    }


    @Test
    public void test01(){
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean);
    }


    /*
    jabc 演示
     */
    @Test
    public void test02(){
        JdbcTemplate bean = ioc.getBean(JdbcTemplate.class);
        Long aLong = bean.queryForObject("select COUNT(*) from t_user", Long.class);
        System.out.println(aLong);
    }
    /*
       jabc 查询单个
    */
    @Test
    public void test03(){
        JdbcTemplate bean = ioc.getBean(JdbcTemplate.class);
        Long aLong = bean.queryForObject("select COUNT(*) from t_user", Long.class);
        System.out.println(aLong);
    }

    /*
    查询一个实例类
     */
    @Test
    public void test04(){
        JdbcTemplate bean = ioc.getBean(JdbcTemplate.class);
        //数据库字段名和属性名一样 利用BeanPropertyRowMapper
        User user = bean.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));

//        User user = bean.queryForObject("select * from t_user where id = 1",
//                (resultSet, i) -> {
//            User o = new User();
//            o.setId(resultSet.getInt("id"));
//            return o;
//        });
        System.out.println(user);
    }

    /*
    查询List<>实体
     */
    @Test
    public void test05() {
        JdbcTemplate bean = ioc.getBean(JdbcTemplate.class);
        List<User> user = bean.query("select * from t_user",new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
    @After
    public void after(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t悔余生" + simpleDateFormat.format(date));
    }
}
