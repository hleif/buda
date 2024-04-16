package com.back.web.controller.system;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.back.common.json.JSONObject;
import com.back.web.controller.demo.domain.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 客户管理
 *
 * @author back
 * @date 2024-03-29
 */
@Api("用户信息管理")
@Controller
@RequestMapping("/system/users")
public class UsersController extends BaseController {
    private String prefix = "system/users";

    @Autowired
    private IUsersService usersService;

    @RequiresPermissions("system:users:view")
    @GetMapping()
    public String users() {
        return prefix + "/users";
    }

    /**
     * 查询列表
     */
    @ApiOperation("获取用户列表")
    @RequiresPermissions("system:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Users users) {

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
    public AjaxResult updateList(Users users) {

        List<Users> theUsers = usersService.selectUsersList(users);

        JSONObject.JSONArray jsonArray = new JSONObject.JSONArray();
        for (Users theUser : theUsers) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user_id", theUser.getUserId());
            jsonObject.put("username", theUser.getUsername());
            jsonObject.put("phone", theUser.getPhone());
            jsonObject.put("wxid", theUser.getWxid());
            jsonObject.put("id_number", theUser.getIdNumber());
            jsonObject.put("openid", theUser.getOpenid());
            jsonObject.put("usercode", theUser.getUsercode());
            jsonObject.put("appointment_status", theUser.getAppointmentStatus());
            jsonObject.put("qrcode_link", theUser.getQrcodeLink());
            jsonObject.put("book_id", theUser.getBookId());
            jsonObject.put("user_uuid", theUser.getUserUuid());
            jsonObject.put("appointment_time", theUser.getAppointmentTime());
            jsonArray.add(jsonObject);

        }
        JSONObject param = new JSONObject();
        param.put("data", jsonArray);

        StringBuffer result = new StringBuffer();
        //连接
        HttpURLConnection connection = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //创建连接对象
            URL url = new URL("http://bgapi.ixiaohe.top/updateUserStatus");
            //创建连接
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方法
            connection.setRequestMethod("PUT");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);
            //DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //设置是否可读取
            connection.setDoOutput(true);
            connection.setDoInput(true);
            //设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //拼装参数
            if (null != param && !param.equals("")) {
                //设置参数
                os = connection.getOutputStream();
                //拼装参数
                os.write(param.toString().getBytes(StandardCharsets.UTF_8));
            }
            System.out.println(param.toString());

//            connection.connect();
            //读取响应
            System.out.println(connection.getResponseMessage());
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                if (null != is) {
                    br = new BufferedReader(new InputStreamReader(is, "GBK"));
                    String temp = null;
                    while (null != (temp = br.readLine())) {
                        result.append(temp);
                        result.append("\r\n");
                    }
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接
            connection.disconnect();
        }

        System.out.println("res>>>>>>>>>>>"+result.toString());

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
    public AjaxResult export(Users users) {
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
        Users users = new Users(0L, model.getUsername(), model.getPhone(), model.getWxid(), model.getIdNumber(), model.getOpenid(), model.getUsercode(), model.getAppointmentStatus(), model.getQrcodeLink(), model.getBookId(), model.getUserUuid(), model.getAppointmentTime());
        return toAjax(usersService.insertUsers(users));
    }

    /**
     * 修改
     */
    @RequiresPermissions("system:users:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
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
    public AjaxResult editSave(UserModel model, @PathVariable Long userId) {
        Users users = new Users(userId, model.getUsername(), model.getPhone(), model.getWxid(), model.getIdNumber(), model.getOpenid(), model.getUsercode(), model.getAppointmentStatus(), model.getQrcodeLink(), model.getBookId(), model.getUserUuid(), model.getAppointmentTime());
        return toAjax(usersService.updateUsers(users));
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequiresPermissions("system:users:remove")
    @Log(title = "【用户删除】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(usersService.deleteUsersByUserIds(ids));
    }
}
