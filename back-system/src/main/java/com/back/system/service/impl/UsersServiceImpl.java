package com.back.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.system.mapper.UsersMapper;
import com.back.system.domain.Users;
import com.back.system.service.IUsersService;
import com.back.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author back
 * @date 2024-03-29
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Users selectUsersByUserId(Long userId)
    {
        return usersMapper.selectUsersByUserId(userId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param users 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param users 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param users 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        return usersMapper.updateUsers(users);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param userIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUserIds(String userIds)
    {
        return usersMapper.deleteUsersByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param userId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUserId(Long userId)
    {
        return usersMapper.deleteUsersByUserId(userId);
    }
}
