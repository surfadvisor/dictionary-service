package com.bsm.dict.impl;

import com.bsm.dict.api.model.DictionaryItem;
import com.bsm.dict.api.service.IDictionaryService;
import com.bsm.dict.dao.DictionaryRepository;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DictionaryService implements IDictionaryService {

  private final DictionaryRepository dictionaryRepository;

  @Override
  public List<DictionaryItem> getDictionary(@NotBlank String dictKey, String lang) {
    return dictionaryRepository.selectDictionary(dictKey, lang);
  }
}
