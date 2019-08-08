package day21.mybatis.day21mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static final Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;



    /**
     * SqlSession工厂类变量，只要拥有一个就行了
     */
    static SqlSessionFactory sqlSessionFactory = null;

    public static void initFactory(){
        if(null == sqlSessionFactory){
            createFactory();
        }
    }


    public static void createFactory(){

        synchronized (LOCK){
            if(null != sqlSessionFactory) {
                return;
            }
            String path = "batis-config.xml";
            InputStream inputStream = null;
            try {
                // 从classpath位置开始，读取对应path的文件
                inputStream = Resources.getResourceAsStream(path);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    // SqlSessionFactory -》 SqlSession ->相当于数据库中的Connection

    public static SqlSession getSqlSession(){
        initFactory();
        return sqlSessionFactory.openSession();
    }



}
