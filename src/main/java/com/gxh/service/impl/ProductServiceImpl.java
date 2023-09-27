package com.gxh.service.impl;

import com.gxh.entity.Product;
import com.gxh.mapper.ProductMapper;
import com.gxh.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
