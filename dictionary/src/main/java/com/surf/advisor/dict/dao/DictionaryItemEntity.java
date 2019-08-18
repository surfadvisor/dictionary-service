package com.surf.advisor.dict.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "DICT_ITEM")
public class DictionaryItemEntity implements Serializable {

  @DynamoDBHashKey
  private String dictName;

  @DynamoDBRangeKey
  private String itemName;

  @DynamoDBAttribute
  private Map<String, String> value;


}
