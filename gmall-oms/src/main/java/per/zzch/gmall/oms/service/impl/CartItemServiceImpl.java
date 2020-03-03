package per.zzch.gmall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.oms.entity.CartItem;
import per.zzch.gmall.oms.mapper.CartItemMapper;
import per.zzch.gmall.oms.service.CartItemService;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}
