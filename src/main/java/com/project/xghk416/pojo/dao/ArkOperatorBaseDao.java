package com.project.xghk416.pojo.dao;

import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XGHK416
 * @since 2020-07-15
 */
public interface ArkOperatorBaseDao extends BaseMapper<ArkOperatorBasePo> {
    ArkOperatorBasePo getBaseAttribute(@Param("name") String name);

    @Select("select operator_sort_id from ark_operator_base")
    List<Integer> getAllOp();
}
