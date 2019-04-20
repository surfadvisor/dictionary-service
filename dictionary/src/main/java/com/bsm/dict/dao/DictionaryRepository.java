package com.bsm.dict.dao;

import com.bsm.dict.api.model.DictionaryItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictionaryRepository {

  List<DictionaryItem> selectDictionary(@Param("dictKey") String dictKey,
                                        @Param("lang") String lang);
}
