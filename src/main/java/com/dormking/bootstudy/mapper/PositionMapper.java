package com.dormking.bootstudy.mapper;

import com.dormking.bootstudy.bean.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Package: com.dormking.bootstudy.mapper
 * @ClassName: PositionMapper
 * @Author: dormking
 * @CreateTime: 2020/11/21 01:20
 * @Description:
 */
@Mapper
public interface PositionMapper {

    Position getPositionByName(@Param("name") String name);
}
