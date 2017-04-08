package x.superman.mapper;

import java.util.List;
import x.superman.pojo.generator.TbkCommoditySettle;
import x.superman.pojo.generator.TbkCommoditySettleExample;

public interface TbkCommoditySettleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbkCommoditySettle record);

    int insertSelective(TbkCommoditySettle record);

    List<TbkCommoditySettle> selectByExample(TbkCommoditySettleExample example);

    TbkCommoditySettle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbkCommoditySettle record);

    int updateByPrimaryKey(TbkCommoditySettle record);
}