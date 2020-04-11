package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Role;
import com.my.blog.mapper.RoleMapper;
import com.my.blog.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
         * </p>
        *
        * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
        */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
