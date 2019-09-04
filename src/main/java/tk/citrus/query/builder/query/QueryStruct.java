package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

/**
 * クエリ情報
 */
abstract public class QueryStruct<T>
{
    /**
     * クエリタイプ
     */
    private String queryType;

    /**
     * 操作テーブル
     */
    private String table;



    /**
     * テーブル設定
     *
     * @param table テーブル名
     * @return メソッドチェイン用の自身返却
     */
    public T table(String table)
    {
        this.setTable(table);

        return (T)this;
    }



    /**
     * SQL文字列を生成して取得
     *
     * @return SQL文字列
     */
    abstract public String callQuery();



    public String getQueryType()
    {
        return queryType;
    }



    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }



    public String getTable()
    {
        return table;
    }



    public void setTable(String table)
    {
        this.table = table;
    }
}
