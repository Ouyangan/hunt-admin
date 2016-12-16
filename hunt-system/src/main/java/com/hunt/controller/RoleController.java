package com.hunt.controller;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysRole;
import com.hunt.service.SysRoleService;
import com.hunt.service.SystemService;
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

/**
 * @Author ouyangan
 * @Date 2016/10/14/14:46
 * @Description
 */
@Api("角色模块")
@RequestMapping("role")
@Controller
public class RoleController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SystemService systemService;

    @ApiOperation(value = "跳转至角色模块", httpMethod = "GET", produces = "text/html")
    @RequiresPermissions("role:list")
    @RequestMapping(value = "role", method = RequestMethod.GET)
    public String role() {
        return "system/role";
    }

    /**
     * 新增角色
     *
     * @param name          名称
     * @param description   描述
     * @param permissionIds 权限ids
     * @param isFinal       是否可修改
     * @return
     */
    @ApiOperation(value = "新增角色", httpMethod = "POST", produces = "application/json", response = Result.class)
    @RequiresPermissions("role:insert")
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String permissionIds,
                         @RequestParam(defaultValue = "1") int isFinal) {
        boolean isExsitRoleName = sysRoleService.isExsitRoleName(name);
        if (isExsitRoleName) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        SysRole sysRole = new SysRole();
        sysRole.setName(name);
        sysRole.setDescription(description);
        sysRole.setIsFinal(isFinal);
        long id = sysRoleService.insertRole(sysRole, permissionIds);
        return Result.success(id);
    }

    /**
     * 更新角色
     *
     * @param id            id
     * @param name          名称
     * @param description   描述
     * @param permissionIds 权限ids
     * @return
     */
    @ApiOperation(value = "更新角色", httpMethod = "POST", produces = "application/json", response = Result.class)
    @RequiresPermissions("role:update")
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestParam long id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String permissionIds) {
        System.out.println("id = [" + id + "], name = [" + name + "], description = [" + description + "], permissionIds = [" + permissionIds + "]");
        boolean isExsitRoleNameExcludeId = sysRoleService.isExsitRoleNameExcludeId(id, name);
        if (isExsitRoleNameExcludeId) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysRole sysRole = sysRoleService.selectById(id);
        if (sysRole == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (sysRole.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysRole.setId(id);
        sysRole.setName(name);
        sysRole.setDescription(description);
        sysRoleService.updateRole(sysRole, permissionIds);
        systemService.clearAuthorizationInfoByRoleId(id);
        return Result.success();
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除角色", httpMethod = "POST", produces = "application/json", response = Result.class)
    @RequiresPermissions("role:delete")
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(@RequestParam long id) {
        SysRole sysRole = sysRoleService.selectById(id);
        if (sysRole == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (sysRole.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysRole.setStatus(2);
        sysRoleService.deleteRole(sysRole);
        systemService.clearAuthorizationInfoByRoleId(id);
        return Result.success();
    }

    /**
     * 角色列表
     *
     * @param page 起始页码
     * @param rows 分页大小
     * @return
     */
    @ApiOperation(value = "角色列表", httpMethod = "GET", produces = "application/json", response = PageInfo.class)
    @RequiresPermissions("role:list")
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageInfo list(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "15") int rows) {
        PageInfo pageInfo = sysRoleService.selectPage(page, rows);
        return pageInfo;
    }
}