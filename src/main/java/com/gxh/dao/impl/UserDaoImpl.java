package com.gxh.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxh.dao.UserDao;
import com.gxh.entity.UserBean;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.user.UserSeletPageConditionDTO;
import com.gxh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserBean> selectAllUser() {
        System.out.println("UserDaoImpl被调用");
        return mapper.selectAllUser();
    }

    @Override
    public PageDTO selectIserByPageUseCondition(UserSeletPageConditionDTO dto) {

        PageDTO pagedto=new PageDTO();

        PageHelper.startPage(dto.getCurr(),dto.getNums());

        List<UserBean> userBeanList = mapper.selectUserByPageCondition(dto);

        PageInfo<UserBean> pageInfo=new PageInfo<>(userBeanList);

        pagedto.setCount(pageInfo.getTotal());
        pagedto.setList(pageInfo.getList());
        return pagedto;
    }



    @Override
    public PageDTO selectByPageUseMybatisPlusReturnPage(int page, int limit) {
        IPage<UserBean> iPage=new Page<>(page,limit);
        mapper.selectPage(iPage,null);

        PageDTO pageinfo=new PageDTO();

        Long count= iPage.getTotal();
        List<UserBean> userBeanList=iPage.getRecords();

        pageinfo.setCount(count);
        pageinfo.setList(userBeanList);
        return pageinfo;
    }

    @Override
    public UserBean selectByNameAndPass(String name,String pass) {
        return mapper.selectByNameAndPass(name,pass);
    }

    @Override
    public int updataPasswordById(int id, String pass) {
        return mapper.updataPasswordById(id, pass);
    }

    @Override
    public UserBean selectPassById(int id) {
        return mapper.selectPassById(id);
    }

    @Override
    public int selectCount() {
        return mapper.selectCount();
    }

    @Override
    public List<UserBean> selectAllUserByPage(int page, int limit) {
        int m=(page-1)*limit;
        return mapper.selectAllUserByPage(m, limit);
    }

    @Override
    public int updateStatus(UserBean bean) {
        return mapper.updateStatus(bean);
    }

    @Override
    public int insertUser(UserBean userBean) {
        return mapper.insert(userBean);
    }

    @Override
    public int userDeleteById(Integer id) {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteUser(UserBean userBean) {
        return mapper.deleteUser(userBean);
    }

    @Override
    public int updateUser(UserBean userBean) {
        return mapper.updateById(userBean);
    }
}
