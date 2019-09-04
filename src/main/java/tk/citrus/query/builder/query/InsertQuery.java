package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * INSERT
 */
public class InsertQuery extends QueryStruct<InsertQuery>
{
    /**
     * カラム名と値の対応表
     */
    private Map<String, Object> values = new LinkedHashMap<>();



    /**
     * constructor.
     */
    public InsertQuery()
    {
        this.setQueryType(QueryTypes.INSERT);
    }



    /**
     * カラム名と値設定
     *
     * @param column カラム名
     * @param value  値
     * @return メソッドチェイン用の自身返却
     */
    public InsertQuery value(String column, Object value)
    {
        this.getValues().put(column, value);

        return this;
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuffer buffer = new StringBuffer("");

        // INSERT
        buffer.append(this.getQueryType())
                .append(" INTO ")
                .append(this.getTable())
                .append(" (");

        // カラム
        StringBuffer columnBuffer = new StringBuffer("");
        this.getValues().forEach((column, value) -> {
            if (columnBuffer.length() > 0)
            {
                columnBuffer.append(", ");
            }
            columnBuffer.append(column);
        });
        buffer.append(columnBuffer.toString());
        buffer.append(") VALUES (");

        // 値
        StringBuffer valueBuffer = new StringBuffer("");
        this.getValues().forEach((column, value) -> {
            if (valueBuffer.length() > 0)
            {
                valueBuffer.append(", ");
            }
            valueBuffer.append("?");
        });
        buffer.append(valueBuffer.toString());
        buffer.append(")");

        return buffer.append(";").toString();
    }



    public Map<String, Object> getValues()
    {
        return values;
    }



    public void setValues(Map<String, Object> values)
    {
        this.values = values;
    }
}
