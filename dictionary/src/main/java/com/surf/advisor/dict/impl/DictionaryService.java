package com.surf.advisor.dict.impl;

import com.surf.advisor.dict.api.model.DictionaryItem;
import com.surf.advisor.dict.api.service.IDictionaryService;
import com.surf.advisor.dict.dao.DictionaryRepository;
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
