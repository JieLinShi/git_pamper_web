
package day21.mybatis.day21mybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * Type interface com.train.day21mybatis.RoleMapper is not known to the MapperRegistry.
 * MapperRegistry由mybatis提供，错误是其对RoleMapper接口的存在是不知道的
 * RoleMapper.xml中已配置了namespace="com.train.day21mybatis.RoleMapper" 指定这个接口，
 * 为什么还是不知道呢？
 * 没有代码加载配置过RoleMapper.xml->怎么会找到呢？
 *
 */
public class Main {
    //
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    private static final boolean IS_OUTPUT_LOGGER = false;

    public static void main(String[] args) {
         SqlSession sqlSession = null;
        RoleMapper roleMapper = null;
        try{
             sqlSession = com.train.day21mybatis.SqlSessionFactoryUtil.getSqlSession();
             roleMapper = sqlSession.getMapper(RoleMapper.class);
//             List<Role> roleList = roleMapper.findAllRole();
//             if (null != roleList){
//                 roleList.forEach(System.out::println);
//             }
//             Role role = roleMapper.findRoleById(1);
//             LOGGER.debug(role);
            Role role = new Role();
            role.setId(1);
            role.setNote("冯导真棒");
            role.setRoleName("导演");
//            int count = roleMapper.insertRole(role);
//            int count = roleMapper.updateRole(role);


            int count = roleMapper.deleteRoleById(1);
            // 提交，一定要执行
            sqlSession.commit();

            LOGGER.debug("count = " + count);

         } catch (Exception e){
             e.printStackTrace();
         } finally {
             if(null != sqlSession) {
                 sqlSession.close();
             }
         }
//        Role role = roleMapper.findRoleById(1);

    }
}
