package com.surf.advisor.dict.api.service;

import com.surf.advisor.dict.api.model.DictionaryItem;
import java.util.List;
import javax.validation.constraints.NotBlank;

public interface IDictionaryService {

  /**
   *
   * @param dictionaryKey dictionary name
   * @param lang language iso code
   * @return all dictionary entries
   */
  List<DictionaryItem> getDictionary(@NotBlank String dictionaryKey, String lang);
}
