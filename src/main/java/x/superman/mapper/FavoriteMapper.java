package x.superman.mapper;

import java.util.List;
import x.superman.pojo.generator.Favorite;
import x.superman.pojo.generator.FavoriteExample;

public interface FavoriteMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    List<Favorite> selectByExample(FavoriteExample example);

    Favorite selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}