package com.surf.advisor.dict.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryItem {

  /**
   * Dictionary item key
   */
  @NotBlank
  private String key;

  /**
   * Language ISO code
   */
  @NotBlank
  @Pattern(regexp = "[A-Z]{2}")
  private String lang;

  /**
   * Dictionary item value
   */
  @NotNull
  private String value;

}
