package com.tz.basemapper.config.provider;

import com.tz.basemapper.config.annotation.Column;
import com.tz.basemapper.config.annotation.Exclude;
import com.tz.basemapper.config.annotation.Table;
import com.tz.basemapper.util.ConvertUtils;
import com.tz.basemapper.util.ToolUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className: BaseSqlProvider
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:37
 * @version: 1.0
 **/
public class BaseSqlProvider<T> {

    public String get(T bean) {

        SQL sql = new SQL();

        Class clazz = bean.getClass();
        Annotation annotation = clazz.getAnnotation(Table.class);
        Table tn = annotation != null ? (Table) annotation : null;
        String tableName = tn != null ?
                tn.value() : ToolUtils.humpToLine(clazz.getSimpleName()).replaceAll("_entity", "").substring(1);

        List<Field> fields = getFields(clazz);
        Map<String, String> columnMap = getColumnNames(fields);
        columnMap.forEach((key, value) -> {
            sql.SELECT(key + " as " + value);
        });
        sql.FROM(tableName);

        List<Field> primaryKeyField = getPrimarkKeyFields(clazz, fields);

        if (!primaryKeyField.isEmpty()) {
            for (Field pkField : primaryKeyField) {
                pkField.setAccessible(true);
                sql.WHERE(pkField.getName() + "=" + String.format("#{" + pkField.getName() + "}"));
            }
        } else {
            sql.WHERE("1 = 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        }
        System.out.println("getSql:" + sql.toString());
        return sql.toString();
    }

    private Map<String, String> getColumnNames(List<Field> fields) {
        return ConvertUtils.toMap(fields, t -> {
            Column c = t.getAnnotation(Column.class);
            if (c == null || StringUtils.isEmpty(c.value())) {
                return t.getName();
            } else {
                return c.value();
            }
        }, t -> {
            return t.getName();
        });
    }


    private List<Field> getPrimarkKeyFields(Class clazz) {
        return getPrimarkKeyFields(clazz, getFields(clazz));
    }

    private List<Field> getPrimarkKeyFields(Class clazz, List<Field> fields) {
        return CollectionUtils.isEmpty(fields) ? new ArrayList<>() : ConvertUtils.toList(fields, t -> {
            t.setAccessible(true);
            Column key = t.getAnnotation(Column.class);
            return key != null && key.primary();
        }, t -> t);
    }

    private List<Field> getFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Exclude key = field.getAnnotation(Exclude.class);
            if (key == null) {
                fieldList.add(field);
            }
        }
        return fieldList;
    }
}
