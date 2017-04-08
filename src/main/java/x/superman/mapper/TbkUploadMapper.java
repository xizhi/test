package x.superman.mapper;

import java.util.List;
import x.superman.pojo.generator.TbkUpload;
import x.superman.pojo.generator.TbkUploadExample;

public interface TbkUploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbkUpload record);

    int insertSelective(TbkUpload record);

    List<TbkUpload> selectByExample(TbkUploadExample example);

    TbkUpload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbkUpload record);

    int updateByPrimaryKey(TbkUpload record);
}