package per.zzch.gmall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.oms.entity.Order;
import per.zzch.gmall.oms.mapper.OrderMapper;
import per.zzch.gmall.oms.service.OrderService;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
