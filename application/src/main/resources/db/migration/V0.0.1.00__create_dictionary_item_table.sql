create table DICT_ITEM (
  dict_name varchar(128) not null,
  item_name varchar(128) not null,
  lang_iso char(2) not null,
  item_value text not null,
  primary key (dict_name, item_name, lang_iso)
);

create function merge_dict_item(varchar(128), varchar(128), char(2), text) returns void
language plpgsql
as $$
begin
  insert into DICT_ITEM(dict_name, item_name, lang_iso, item_value) values ($1, $2, $3, $4)
  on conflict (dict_name, item_name, lang_iso)
  do update set item_value = $4;
end;
$$;
