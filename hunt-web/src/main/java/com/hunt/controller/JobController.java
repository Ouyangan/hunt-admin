package com.hunt.controller;

import com.hunt.controller.BaseController;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hunt.util.ResponseCode;
import com.hunt.util.Result;

/**
 * 职位模块
 */
@Api(value = "职位模块")
@Controller
@RequestMapping("job")
public class JobController extends BaseController {
    @Autowired
    private SysRoleOrganizationService roleOrganizationService;

    /**
     * 跳转至职位页面
     *
     * @return
     */
    @ApiOperation(value = "跳转至职位页面", httpMethod = "GET", produces = "text/html")
    @RequiresPermissions("job:list")
    @RequestMapping(value = "job", method = RequestMethod.GET)
    public String job() {
        return "system/job";
    }

    /**
     * 新增职位
     *
     * @param roleId         角色id
     * @param organizationId 组织id
     * @param parentId       父级职位
     * @param name           名称
     * @param description    描述
     * @param fullName       全称
     * @param isFinal        是否可修改
     * @return
     */
    @ApiOperation(value = "新增职位", httpMethod = "POST", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("job:insert")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam long roleId,
                         @RequestParam long organizationId,
                         @RequestParam long parentId,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String fullName,
                         @RequestParam(defaultValue = "1") int isFinal) {

        boolean isExistName = roleOrganizationService.isExistName(name, parentId);
        if (isExistName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysRoleOrganization roleOrganization = new SysRoleOrganization();
        roleOrganization.setName(name);
        roleOrganization.setDescription(description);
        roleOrganization.setFullName(fullName);
        roleOrganization.setSysRoleId(roleId);
        roleOrganization.setSysOrganizationId(organizationId);
        roleOrganization.setParentId(parentId);
        roleOrganization.setIsFinal(isFinal);
        long id = roleOrganizationService.insertRoleOrganization(roleOrganization);
        return Result.success(id);
    }

    /**
     * 更新职位
     *
     * @param id             id
     * @param roleId         角色id
     * @param organizationId 组织id
     * @param parentId       父级职位
     * @param name           名称
     * @param description    描述
     * @param fullName       全称
     * @return
     */
    @ApiOperation(value = "更新职位", httpMethod = "POST", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("job:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestParam long id,
                         @RequestParam long roleId,
                         @RequestParam long organizationId,
                         @RequestParam long parentId,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String fullName) {
        SysRoleOrganization roleOrganization = roleOrganizationService.selectRoleOrganizationById(id);
        if (roleOrganization == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (roleOrganization.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        boolean isExistNameExcludeId = roleOrganizationService.isExistNameExcludeId(id, name, parentId);
        if (isExistNameExcludeId) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        roleOrganization.setName(name);
        roleOrganization.setDescription(description);
        roleOrganization.setFullName(fullName);
        roleOrganization.setSysRoleId(roleId);
        roleOrganization.setSysOrganizationId(organizationId);
        roleOrganization.setParentId(parentId);
        roleOrganizationService.updateRoleOrganization(roleOrganization);
        return Result.success();
    }

    /**
     * 删除职位
     *
     * @param id id
     * @return
     */
    @ApiOperation(value = "删除职位", httpMethod = "GET", produces = "application/json", response = Result.class)
    @ResponseBody
    @RequiresPermissions("job:delete")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result delete(@RequestParam long id) {
        SysRoleOrganization roleOrganization = roleOrganizationService.selectRoleOrganizationById(id);
        if (roleOrganization == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (roleOrganization.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        roleOrganization.setStatus(2);
        roleOrganizationService.updateRoleOrganization(roleOrganization);
        return Result.success();
    }

    /**
     * 查询职位
     *
     * @param page 起始页码
     * @param rows 分页大小
     * @param id   定级id
     * @return
     */
    @ApiOperation(value = "查询职位列表", httpMethod = "GET", produces = "application/json", response = PageInfo.class)
    @ResponseBody
    @RequiresPermissions("job:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageInfo list(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "15") int rows,
                         @RequestParam(defaultValue = "1") long id) {
        PageInfo pageInfo = roleOrganizationService.selectPage(page, rows, id);
        return pageInfo;
    }
}
