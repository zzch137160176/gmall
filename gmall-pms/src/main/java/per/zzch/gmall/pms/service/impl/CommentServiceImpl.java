package per.zzch.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.zzch.gmall.pms.entity.Comment;
import per.zzch.gmall.pms.mapper.CommentMapper;
import per.zzch.gmall.pms.service.CommentService;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author zzch
 * @since 2020-03-01
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
