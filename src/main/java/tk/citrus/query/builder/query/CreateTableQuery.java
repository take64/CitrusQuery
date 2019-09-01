package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;
import tk.citrus.query.builder.parse.ColumnDef;
import tk.citrus.query.builder.parse.Index;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE TABLE
 */
public class CreateTableQuery extends QueryStruct<CreateTableQuery>
{
    /**
     * カラム
     */
    private List<ColumnDef> columns = new ArrayList<>();

    /**
     * インデックス
     */
    private Index index;



    /**
    * constructor.
     */
    public CreateTableQuery()
    {
        this.setQueryType(QueryTypes.CREATE_TABLE);
    }



    /**
     * カラムの設定
     *
     * @param column カラム名
     * @param type   型
     * @return メソッドチェイン用の自身返却
     */
    public CreateTableQuery column(String column, String type)
    {
        this.getColumns().add(ColumnDef.generate(column, type));

        return this;
    }



    /**
     * カラムの設定
     *
     * @param column
     * @param type
     * @param isNotNull
     * @return メソッドチェイン用の自身返却
     */
    public CreateTableQuery column(String column, String type, Boolean isNotNull)
    {
        this.getColumns().add(ColumnDef.generate(column, type, isNotNull));

        return this;
    }



    /**
     * プライマリキー設定
     *
     * @param columnNames カラム配列
     * @return メソッドチェイン用の自身返却
     */
    public CreateTableQuery primaryKey(List<String> columnNames)
    {
        List<ColumnDef> indexColumns = new ArrayList<>();

        columnNames.forEach(columnName -> {
            this.getColumns().forEach(columnDef -> {
                if (columnName.equals(columnDef.getColumn()) == true)
                {
                    indexColumns.add(columnDef);
                }
            });
        });

        this.setIndex(Index.primaryKey(indexColumns));

        return this;
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuffer buffer = new StringBuffer("");

        // CREATE TABLE
        buffer.append(this.getQueryType())
                .append(" ")
                .append(this.getTable())
                .append(" (");

        // カラム文字列
        buffer.append(ColumnDef.query(this.getColumns()));

        // プライマリキー/ユニークキー
        if (this.getIndex() != null)
        {
            buffer.append(", ").append(Index.query(this.getIndex()));
        }

        buffer.append(")");

        return buffer.append(";").toString();
    }



    public List<ColumnDef> getColumns()
    {
        return columns;
    }



    public void setColumns(List<ColumnDef> columns)
    {
        this.columns = columns;
    }



    public Index getIndex()
    {
        return index;
    }



    public void setIndex(Index index)
    {
        this.index = index;
    }
}
