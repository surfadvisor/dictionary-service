package com.surf.advisor.dict.dao;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.surf.advisor.dict.api.model.DictionaryItem;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DynamoDbDictionaryDao implements DictionaryRepository {

  private final DynamoDBMapper mapper;

  @Override
  public List<DictionaryItem> selectDictionary(String dictKey, String lang) {

    var partitionKey = new DictionaryItemEntity();
    partitionKey.setDictName(dictKey);

    var queryExpression = new DynamoDBQueryExpression<DictionaryItemEntity>()
      .withHashKeyValues(partitionKey);

    List<DictionaryItemEntity> results = mapper.query(DictionaryItemEntity.class, queryExpression);

    return ofNullable(results).orElse(emptyList()).stream()
      .map(entity -> DictionaryItem.builder()
        .value(ofNullable(entity.getValue()).map(val -> val.get(lang)).orElse(null))
        .key(entity.getItemName())
        .lang(lang)
        .build()
      ).collect(toList());
  }
}
