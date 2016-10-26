package com.hunt.controller;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SysOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.Result;

/**
 * 组织机构模块
 */
@Controller
@RequestMapping("organization")
public class OrganizationController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private SysOrganizationService sysOrganizationService;

    @RequestMapping(value = "organization", method = RequestMethod.GET)
    public String organization() {

        return "system/organization";
    }

    /**
     * 新增机构
     *
     * @param name        名称
     * @param description 描述
     * @param fullName    全称
     * @param parentId    父级id
     * @param isFinal     是否可修改
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String fullName,
                         @RequestParam long parentId,
                         @RequestParam(defaultValue = "1") int isFinal) {
        boolean isExistFullName = sysOrganizationService.isExistFullName(fullName);
        if (isExistFullName) {
            return Result.error("全称重复,请重新填写!");
        }
        SysOrganization organization = new SysOrganization();
        organization.setFullName(fullName);
        organization.setName(name);
        organization.setDescription(description);
        organization.setParentId(parentId);
        organization.setIsFinal(isFinal);
        long i = sysOrganizationService.insertOrganization(organization);
        return Result.success();
    }

    /**
     * 删除机构
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result delete(@RequestParam long id) {
        SysOrganization sysOrganization = sysOrganizationService.selectOrganization(id);
        if (sysOrganization == null) {
            return Result.error("组织机构不存在!");
        }
        if (sysOrganization.getIsFinal() == 2) {
            return Result.error("该数据不可删除!");
        }
        int i = sysOrganizationService.deleteOrganization(id);
        return Result.success();
    }

    /**
     * 更新机构
     *
     * @param id          id
     * @param name        名称
     * @param description 描述
     * @param fullName    全称
     * @param parentId    父级id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestParam long id,
                         @RequestParam String name,
                         @RequestParam String fullName,
                         @RequestParam String description,
                         @RequestParam long parentId) {
        System.out.println("id = [" + id + "], name = [" + name + "], fullName = [" + fullName + "], description = [" + description + "], parentId = [" + parentId + "]");
        SysOrganization sysOrganization = sysOrganizationService.selectOrganization(id);
        if (sysOrganization == null) {
            return Result.error("组织机构不存在!");
        }
        if (sysOrganization.getIsFinal() == 2) {
            return Result.error("该数据不可编辑!");
        }
        if (sysOrganization.getId() == parentId) {
            return Result.error("上级机构不能选择自己,请选择其他组织机构!");
        }
        boolean isExistFullNameExcludeId = sysOrganizationService.isExistFullNameExcludeId(id, fullName);
        if (isExistFullNameExcludeId) {
            return Result.error("全称重复,请重新填写!");
        }
        SysOrganization organization = new SysOrganization();
        organization.setId(id);
        organization.setFullName(fullName);
        organization.setName(name);
        organization.setDescription(description);
        organization.setParentId(parentId);
        sysOrganizationService.updateOrganization(organization);
        return Result.success();
    }

    /**
     * 查询机构列表
     *
     * @param page 起始页码
     * @param row  分页大小
     * @param id   顶级id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public PageInfo select(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "row", defaultValue = "15") int row,
                           @RequestParam(value = "id", defaultValue = "1") long id) {
        PageInfo pageInfo = sysOrganizationService.selectPage(page, row, id);
        return pageInfo;
    }

}
