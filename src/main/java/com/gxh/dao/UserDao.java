package com.gxh.dao;

import com.gxh.entity.UserBean;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.user.UserSeletPageConditionDTO;

import java.util.List;

public interface UserDao {
    List<UserBean> selectAllUser();

    UserBean selectByNameAndPass(String name, String pass);

    UserBean selectPassById(int id);

    int updataPasswordById(int id,String pass);

    int updateStatus(UserBean bean);

    PageDTO selectIserByPageUseCondition(UserSeletPageConditionDTO dto);

    PageDTO selectByPageUseMybatisPlusReturnPage(int page, int limit);

    int selectCount();

    List<UserBean> selectAllUserByPage(int page,int limit);

    int insertUser(UserBean userBean);

    int deleteUser(UserBean userBean);

    int updateUser(UserBean userBean);
}
