package com.surf.advisor.dict;

import com.surf.advisor.dict.api.model.DictionaryItem;
import com.surf.advisor.dict.api.service.IDictionaryService;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class DictionaryController {

  private final IDictionaryService dictionaryService;

  @GetMapping("/{dictionaryKey}")
  List<DictionaryItem> getDictionary(
    @NotBlank @PathVariable("dictionaryKey") String dictionaryKey,
    @Pattern(regexp = "[A-Z]{2}") @RequestParam(value = "lang", required = false) String lang) {
    return dictionaryService.getDictionary(dictionaryKey, lang);
  }

  @GetMapping("/health-check")
  public String healthCheck() {
    return "ok";
  }

}
