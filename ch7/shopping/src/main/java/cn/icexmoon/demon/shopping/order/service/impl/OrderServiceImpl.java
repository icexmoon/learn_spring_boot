package cn.icexmoon.demon.shopping.order.service.impl;

import cn.icexmoon.demon.shopping.order.entity.Order;
import cn.icexmoon.demon.shopping.order.mapper.OrderMapper;
import cn.icexmoon.demon.shopping.order.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
