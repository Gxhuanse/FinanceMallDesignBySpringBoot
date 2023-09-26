package com.gxh.mapper;

import com.gxh.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {

}
