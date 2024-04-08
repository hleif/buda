package com.back.web.controller.system;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.back.common.utils.DateUtils;
import com.back.web.controller.demo.domain.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.back.common.annotation.Log;
import com.back.common.enums.BusinessType;
import com.back.system.domain.Users;
import com.back.system.service.IUsersService;
import com.back.common.core.controller.BaseController;
import com.back.common.core.domain.AjaxResult;
import com.back.common.utils.poi.ExcelUtil;
import com.back.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author back
 * @date 2024-03-29
 */
@Api("用户信息管理")
@Controller
@RequestMapping("/system/users")
public class UsersController extends BaseController
{
    private String prefix = "system/users";

    @Autowired
    private IUsersService usersService;

    @RequiresPermissions("system:users:view")
    @GetMapping()
    public String users()
    {
        return prefix + "/users";
    }

    /**
     * 查询列表
     */
    @ApiOperation("获取用户列表")
    @RequiresPermissions("system:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Users users)
    {

//        users.setAppointmentTime(DateUtils.dateTimeNow("yyyy-MM-dd"));
        startPage();
        List<Users> list = usersService.selectUsersList(users);
        return getDataTable(list);
    }

    /**
     * 查询列表
     */
    @ApiOperation("同步状态")
    @RequiresPermissions("system:users:updateList")
    @PostMapping("/updateList")
    @ResponseBody
    public AjaxResult updateList(Users users)
    {
        startPage();
        List<Users> list = usersService.selectUsersList(users);
        return success(list);
    }

    /**
     * 导出列表
     */
    @ApiOperation("导出")
    @RequiresPermissions("system:users:export")
    @Log(title = "【用户导出】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Users users)
    {
        List<Users> list = usersService.selectUsersList(users);
        ExcelUtil<Users> util = new ExcelUtil<Users>(Users.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增保存
     */
    @ApiOperation("新增")
    @RequiresPermissions("system:users:add")
    @Log(title = "【用户新增】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserModel model) throws InvocationTargetException, IllegalAccessException {
        Users users = new Users(0L,model.getUsername(), model.getPhone(), model.getWxid(), model.getIdNumber(), model.getOpenid(), model.getUsercode(), model.getAppointmentStatus(), model.getQrcodeLink(), model.getBookId(), model.getUserUuid(), model.getAppointmentTime());
        return toAjax(usersService.insertUsers(users));
    }

    /**
     * 修改
     */
    @RequiresPermissions("system:users:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        Users users = usersService.selectUsersByUserId(userId);
        mmap.put("users", users);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @ApiOperation("修改")
    @RequiresPermissions("system:users:edit")
    @Log(title = "【用户修改】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit/{userId}")
    @ResponseBody
    public AjaxResult editSave(UserModel model, @PathVariable Long userId)
    {
        Users users = new Users(userId,model.getUsername(), model.getPhone(), model.getWxid(), model.getIdNumber(), model.getOpenid(), model.getUsercode(), model.getAppointmentStatus(), model.getQrcodeLink(), model.getBookId(), model.getUserUuid(), model.getAppointmentTime());
        return toAjax(usersService.updateUsers(users));
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequiresPermissions("system:users:remove")
    @Log(title = "【用户删除】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(usersService.deleteUsersByUserIds(ids));
    }
}
