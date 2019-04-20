package com.bsm.dict;

import com.bsm.dict.api.model.DictionaryItem;
import com.bsm.dict.api.service.IDictionaryService;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class DictionaryController {

  private final IDictionaryService dictionaryService;

  @GetMapping("/{dictionaryKey}/{lang}")
  List<DictionaryItem> getDictionary(
    @NotBlank @PathVariable("dictionaryKey") String dictionaryKey,
    @Pattern(regexp = "[A-Z]{2}") @PathVariable("lang") String lang) {
    return dictionaryService.getDictionary(dictionaryKey, lang);
  }

}
