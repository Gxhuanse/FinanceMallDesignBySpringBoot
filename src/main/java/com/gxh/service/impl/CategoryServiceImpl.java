package com.gxh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxh.entity.Category;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.category.CategoryQueryReturnDTO;
import com.gxh.entity.dto.category.CategorySeletPageConditionDTO;
import com.gxh.mapper.CategoryMapper;
import com.gxh.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<Category> selectCategoryByParentId(Integer id) {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Category::getParentId,id);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public PageDTO selectIserByPageUseCondition(CategorySeletPageConditionDTO dto) {
        IPage<Category> iPage=new Page<>(dto.getCurr(),dto.getNums());
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();

        wrapper.like(dto.getCtName()!=null,Category::getCtName,dto.getCtName());
        wrapper.like(dto.getCtDiscrip()!=null,Category::getCtDiscrip,dto.getCtDiscrip());
        wrapper.eq(dto.getParentId()!=null,Category::getParentId,dto.getParentId());
        wrapper.eq(dto.getCtRecom()!=null,Category::getCtRecom,dto.getCtRecom());
        wrapper.eq(dto.getCtStatus()!=null,Category::getCtStatus,dto.getCtStatus());

        categoryMapper.selectPage(iPage,wrapper);

        PageDTO pageInfo=new PageDTO();
        Long count=iPage.getTotal();
        List<Category> categoryList=iPage.getRecords();

        pageInfo.setCount(count);
        pageInfo.setList(categoryList);

        return pageInfo;
    }

    @Override
    public PageDTO selectByByPageConditionAndParentName(CategorySeletPageConditionDTO dto) {
        PageDTO pageInfo=new PageDTO();
        dto.setCurr((dto.getCurr()-1)*dto.getNums());

        int size = categoryMapper.selectPageConditionAndParentNameCount(dto).size();
        List<CategoryQueryReturnDTO> dtoList= categoryMapper.selectPageConditionAndParentName(dto);
        pageInfo.setCount((long) size);
        pageInfo.setList(dtoList);
        return pageInfo;
    }
}
