package com.gxh.service.impl;

import com.gxh.entity.Category;
import com.gxh.mapper.CategoryDao;
import com.gxh.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements ICategoryService {

}
