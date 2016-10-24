package com.hunt.dao;

import com.hunt.model.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    //新增
    public Long insert(SysUser SysUser);

    //更新
    public void update(SysUser SysUser);

    //通过对象进行查询
    public SysUser select(SysUser SysUser);

    //通过id进行查询
    public SysUser selectById(@Param("id") Long id);

    //查询全部
    public List<SysUser> selectAll(@Param("sort") String sort, @Param("order") String order, @Param("loginName") String loginName, @Param("zhName") String zhName, @Param("email") String email, @Param("phone") String phone, @Param("address") String address);

    //查询数量
    public int selectCounts();

    boolean selectByLoginName(@Param("loginName") String loginName);

    void deleteById(@Param("id") long id);

    boolean isExistLoginNameExcludeId(@Param("id") long id, @Param("loginName") String loginName);

    SysUser selectUserByLoginName(@Param("loginName") String loginName);
}