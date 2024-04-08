package com.back.system.mapper;

import java.util.List;
import com.back.system.domain.Users;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author back
 * @date 2024-03-29
 */
public interface UsersMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Users selectUsersByUserId(Long userId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param users 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增【请填写功能名称】
     * 
     * @param users 【请填写功能名称】
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改【请填写功能名称】
     * 
     * @param users 【请填写功能名称】
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUsersByUserId(Long userId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsersByUserIds(String[] userIds);
}
