package com.project.xghk416.service.serviceImpl;

import com.project.xghk416.pojo.po.UserPo;
import com.project.xghk416.pojo.dao.UserDao;
import com.project.xghk416.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XGHK416
 * @since 2019-11-07
 */
@Service
public class UserImplService extends ServiceImpl<UserDao, UserPo> implements UserService {

}
