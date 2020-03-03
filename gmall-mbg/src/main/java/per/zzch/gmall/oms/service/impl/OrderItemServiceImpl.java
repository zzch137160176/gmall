package per.zzch.gmall.oms.service.impl;

import per.zzch.gmall.oms.entity.OrderItem;
import per.zzch.gmall.oms.mapper.OrderItemMapper;
import per.zzch.gmall.oms.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
