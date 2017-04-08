package x.superman.mapper;

import java.util.List;
import x.superman.pojo.generator.TbkCommodity;
import x.superman.pojo.generator.TbkCommodityExample;

public interface TbkCommodityMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbkCommodity record);

    int insertSelective(TbkCommodity record);

    List<TbkCommodity> selectByExample(TbkCommodityExample example);

    TbkCommodity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbkCommodity record);

    int updateByPrimaryKey(TbkCommodity record);
}