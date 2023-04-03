package com.sisheng.yygh.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sisheng.yygh.model.order.OrderInfo;
import com.sisheng.yygh.vo.order.OrderCountQueryVo;
import com.sisheng.yygh.vo.order.OrderCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bobochang
 * @description
 * @created 2022/7/16-13:05
 **/
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    //查询预约统计数据的方法
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);

}
