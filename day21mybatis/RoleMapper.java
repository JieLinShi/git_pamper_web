package day21.mybatis.day21mybatis;

import java.util.List;

public interface RoleMapper {
    /**
     * 查找所有的role信息
     * @return
     */
    List<Role> findAllRole();

    /**
     * 根据ID查找role信息
     * @return
     */
    Role findRoleById(int id);

    /**
     * 增加角色信息
     * @param role
     * @return
     */
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRoleById(int id);

}
