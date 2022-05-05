package cn.icexmoon.demon.shopping.user.service.impl;

import cn.icexmoon.demon.shopping.user.entity.Cart;
import cn.icexmoon.demon.shopping.user.mapper.CartMapper;
import cn.icexmoon.demon.shopping.user.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-05
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
