package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;
import tk.citrus.query.builder.parse.ColumnValue;
import tk.citrus.query.builder.parse.Where;

import java.util.ArrayList;
import java.util.List;

/**
 * UPDATE
 */
public class UpdateQuery extends QueryStruct<UpdateQuery>
{
    /**
     * カラム
     */
    private List<ColumnValue> columns = new ArrayList<>();

    /**
     * WHERE句
     */
    private List<Where> wheres = new ArrayList<>();



    /**
     * constructor.
     */
    public UpdateQuery()
    {
        this.setQueryType(QueryTypes.UPDATE);
    }



    /**
     * カラム名と値設定
     *
     * @param column カラム名
     * @param value  値
     * @return メソッドチェイン用の自身返却
     */
    public UpdateQuery set(String column, Object value)
    {
        this.getColumns().add(ColumnValue.generate(column, value));

        return this;
    }



    /**
     * 単純なイコールのWHERE句
     *
     * @param column カラム名
     * @param value  値
     * @return メソッドチェイン用の自身返却
     */
    public UpdateQuery where(String column, Object value)
    {
        this.getWheres().add(Where.generate(column, value));

        return this;
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuilder builder = new StringBuilder("");

        // INSERT
        builder.append(this.getQueryType())
                .append(" ")
                .append(this.getTable())
                .append(" SET ")
                .append(this.joinedSet())
                .append(Where.query(this.getWheres()));

        return builder.append(";").toString();
    }



    /**
     * SET句の生成
     *
     * @return SET句文字列
     */
    private String joinedSet()
    {
        StringBuilder builder = new StringBuilder("");
        this.getColumns().forEach((ColumnValue columnValue) -> {
            if (builder.length() > 0)
            {
                builder.append(", ");
            }
            builder.append(columnValue.getColumn())
                    .append(" = ?");
        });
        return builder.toString();
    }



//    /**
//     * カラムと値の対応マップから値の数の分の？をカンマ区切りで連結した文字列を取得
//     *
//     * @return カラムと値の対応マップから値の数の分の？をカンマ区切りで連結した文字列
//     */
//    private String joinedValuesPrepare()
//    {
//        StringBuilder builder = new StringBuilder("");
//        this.getValues().forEach((column, value) -> {
//            if (builder.length() > 0)
//            {
//                builder.append(", ");
//            }
//            builder.append("?");
//        });
//        return builder.toString();
//    }



    public List<ColumnValue> getColumns()
    {
        return columns;
    }



    public void setColumns(List<ColumnValue> columns)
    {
        this.columns = columns;
    }



    public List<Where> getWheres()
    {
        return wheres;
    }



    public void setWheres(List<Where> wheres)
    {
        this.wheres = wheres;
    }
}
