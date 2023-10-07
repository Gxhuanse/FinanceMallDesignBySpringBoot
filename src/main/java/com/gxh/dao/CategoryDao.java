package com.gxh.dao;

import com.gxh.entity.Category;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.category.CategorySeletPageConditionInDTO;

import java.util.List;

public interface CategoryDao {

    List<Category> selectCategoryByParentId(Integer id);

    PageDTO selectIserByPageUseCondition(CategorySeletPageConditionInDTO dto);

    PageDTO selectByByPageConditionAndParentName(CategorySeletPageConditionInDTO dto);
}
