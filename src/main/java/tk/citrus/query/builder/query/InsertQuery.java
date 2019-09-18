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
     * カラム名と値の対応マップ
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
        StringBuilder builder = new StringBuilder("");

        // INSERT
        builder.append(this.getQueryType())
                .append(" INTO ")
                .append(this.getTable())
                .append(" (")
                .append(this.joinedValuesColumn())
                .append(") VALUES (")
                .append(this.joinedValuesPrepare())
                .append(")");

        return builder.append(";").toString();
    }



    /**
     * カラムと値の対応マップからカラム名をカンマ区切りで連結した文字列を取得
     *
     * @return カラムと値の対応マップからカラム名をカンマ区切りで連結した文字列
     */
    private String joinedValuesColumn()
    {
        StringBuilder builder = new StringBuilder("");
        this.getValues().forEach((column, value) -> {
            if (builder.length() > 0)
            {
                builder.append(", ");
            }
            builder.append(column);
        });
        return builder.toString();
    }



    /**
     * カラムと値の対応マップから値の数の分の？をカンマ区切りで連結した文字列を取得
     *
     * @return カラムと値の対応マップから値の数の分の？をカンマ区切りで連結した文字列
     */
    private String joinedValuesPrepare()
    {
        StringBuilder builder = new StringBuilder("");
        this.getValues().forEach((column, value) -> {
            if (builder.length() > 0)
            {
                builder.append(", ");
            }
            builder.append("?");
        });
        return builder.toString();
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
