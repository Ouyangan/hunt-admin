package com.hunt.controller;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysPermissionGroup;
import com.hunt.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hunt.util.ResponseCode;
import com.hunt.util.Result;

import java.util.List;

/**
 * 权限模块
 */
@Api("权限模块")
@Controller
@RequestMapping("permission")
public class PermissionController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "跳转至权限模块", httpMethod = "GET", produces = "text/html")
    @RequiresPermissions("permission:list")
    @RequestMapping(value = "permission", method = RequestMethod.GET)
    public String permission() {
        return "system/permission";
    }

    /**
     * 新增权限
     *
     * @param groupId     权限组id
     * @param name        名称
     * @param code        编码
     * @param description 描述
     * @param isFinal     是否可修改
     * @return
     */
    @ApiOperation(value = "新增权限", httpMethod = "POST", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:insert")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam long groupId,
                         @RequestParam String name,
                         @RequestParam String code,
                         @RequestParam String description,
                         @RequestParam(defaultValue = "1") int isFinal) {
        boolean isExistName = sysPermissionService.isExistName(groupId, name);
        boolean isExistCode = sysPermissionService.isExistCode(groupId, code);
        System.out.println(isExistName);
        System.out.println(isExistCode);
        if (isExistName) {
            return Result.error("该分组下名称已存在1");
        }
        if (isExistCode) {
            return Result.error("该权限分组下编码已存在已存在");
        }
        SysPermission sysPermission = new SysPermission();
        sysPermission.setName(name);
        sysPermission.setCode(code);
        sysPermission.setDescription(description);
        sysPermission.setIsFinal(isFinal);
        sysPermission.setSysPermissionGroupId(groupId);
        long id = sysPermissionService.insertPermission(sysPermission);
        return Result.success(id);
    }

    /**
     * 删除权限
     *
     * @param id id
     * @return
     */
    @ApiOperation(value = "删除权限", httpMethod = "GET", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:delete")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result delete(@RequestParam long id) {
        SysPermission sysPermission = sysPermissionService.selectById(id);
        if (sysPermission == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (sysPermission.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysPermission.setStatus(2);
        // TODO: 2016/10/26  级联删除关联表 ,角色权限,用户权限
        sysPermissionService.update(sysPermission);
        return Result.success();
    }

    /**
     * 更新权限
     *
     * @param id          id
     * @param groupId     权限组id
     * @param name        名称
     * @param code        编码
     * @param description 描述
     * @return
     */
    @ApiOperation(value = "更新权限", httpMethod = "POST", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestParam long id,
                         @RequestParam long groupId,
                         @RequestParam String name,
                         @RequestParam String code,
                         @RequestParam String description) {
        SysPermission sysPermission = sysPermissionService.selectById(id);
        if (sysPermission == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (sysPermission.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        boolean isExistName = sysPermissionService.isExistNameExcludeId(id, groupId, name);
        if (isExistName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        boolean isExistCode = sysPermissionService.isExistCodeExcludeId(id, groupId, code);
        if (isExistCode) {
            return Result.error(ResponseCode.code_already_exist.getMsg());
        }
        sysPermission.setName(name);
        sysPermission.setCode(code);
        sysPermission.setDescription(description);
        sysPermission.setSysPermissionGroupId(groupId);
        sysPermissionService.update(sysPermission);
        return Result.success();
    }

    /**
     * 查询权限列表
     *
     * @param page 起始页码
     * @param rows 分页大小
     * @return
     */
    @ApiOperation(value = "查询权限列表", httpMethod = "GET", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageInfo list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "30") int rows) {
        PageInfo pageInfo = sysPermissionService.selectPage(page, rows);
        return pageInfo;
    }

    /**
     * 新增权限组
     *
     * @param name        名称
     * @param description 描述
     * @return
     */
    @ApiOperation(value = "新增权限组", httpMethod = "POST", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:group:insert")
    @RequestMapping(value = "group/insert", method = RequestMethod.POST)
    public Result insertGroup(@RequestParam String name,
                              @RequestParam String description) {
        boolean isExistGroupName = sysPermissionService.isExistGroupName(name);
        if (isExistGroupName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysPermissionGroup sysPermissionGroup = new SysPermissionGroup();
        sysPermissionGroup.setName(name);
        sysPermissionGroup.setDescription(description);
        sysPermissionGroup.setIsFinal(2);
        long id = sysPermissionService.insertPermissionGroup(sysPermissionGroup);
        return Result.success(id);
    }

    /**
     * 查询权限组
     *
     * @return
     */
    @ApiOperation(value = "查询权限组", httpMethod = "GET", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("permission:group:list")
    @RequestMapping(value = "group/list", method = RequestMethod.GET)
    public List<SysPermissionGroup> selectGroup() {
        List<SysPermissionGroup> list = sysPermissionService.selectGroup();
        return list;
    }

}
