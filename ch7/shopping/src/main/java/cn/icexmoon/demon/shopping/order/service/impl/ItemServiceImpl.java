package cn.icexmoon.demon.shopping.order.service.impl;

import cn.icexmoon.demon.shopping.order.entity.Item;
import cn.icexmoon.demon.shopping.order.mapper.ItemMapper;
import cn.icexmoon.demon.shopping.order.service.IItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
