package cn.icexmoon.demon.shopping.item.service.impl;

import cn.icexmoon.demon.shopping.item.entity.Item;
import cn.icexmoon.demon.shopping.item.mapper.ItemMapper;
import cn.icexmoon.demon.shopping.item.service.IItemService;
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
