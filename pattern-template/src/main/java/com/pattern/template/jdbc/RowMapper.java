package com.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * ORM映射定制化的接口。
 * 针对每一行进行处理，每一行：ResultSet，行号：rowNum。
 * @param <T>
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
