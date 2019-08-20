package com.surf.advisor.dict.dao;

import com.surf.advisor.dict.api.model.DictionaryItem;
import java.util.List;

public interface DictionaryRepository {

  List<DictionaryItem> selectDictionary(String dictKey, String lang);
}
