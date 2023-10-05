package com.gxh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxh.entity.UserBean;
import com.gxh.entity.dto.user.UserSeletPageConditionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserBean> {

    List<UserBean> selectAllUser();

    UserBean selectByNameAndPass(@Param("name") String name, @Param("pass") String pass);

    int updataPasswordById(@Param("id") int id, @Param("pass") String pass);

    UserBean selectPassById(int id);

    List<UserBean> selectUserByPageCondition(UserSeletPageConditionDTO dto);

    @Update("update situ_prj_02_boot.tb_user set user_status=#{userStatus} where id=#{id}")
    int updateStatus(UserBean bean);

    @Select("select  count(*)as count from situ_prj.tb_user")
    int selectCount();

    @Select("select *from situ_prj_02_boot.tb_user limit #{page},#{limit}")
    List<UserBean> selectAllUserByPage(@Param("page") int page, @Param("limit") int limit);

    int insertUser(UserBean userBean);

    int deleteUser(UserBean userBean);

    int updateUser(UserBean userBean);
}
