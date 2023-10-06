package com.gxh.mapper;

import com.gxh.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxh.entity.dto.category.CategorySeletPageConditionOutDTO;
import com.gxh.entity.dto.category.CategorySeletPageConditionInDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategorySeletPageConditionOutDTO> selectPageConditionAndParentName(CategorySeletPageConditionInDTO dto);

    List<CategorySeletPageConditionOutDTO> selectPageConditionAndParentNameCount(CategorySeletPageConditionInDTO dto);
}
