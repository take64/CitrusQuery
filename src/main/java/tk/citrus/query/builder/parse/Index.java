package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * インデックス定義
 */
public class Index
{
    /**
     * プライマリキー
     */
    public static String PRIMARY_KEY = "PRIMARY KEY";

    /**
     * ユニークキー
     */
    public static String UNIQUE_KEY = "UNIQUE";

    /**
     * インデックス
     */
    public static String INDEX = "INDEX";

    /**
     * ユニークインデックス
     */
    public static String UNIQUE_INDEX = "UNIQUE INDEX";

    /**
     * インデックスタイプ
     */
    private String indexType;

    /**
     * カラム
     */
    private List<ColumnDef> columns;

    /**
     * インデックス名
     */
    private String name;



    /**
     * インデックス生成
     *
     * @param indexType インデックス種別
     * @param columns   カラムリスト
     * @param name      インデックス名称
     * @return 生成したインデックス情報
     */
    public static Index generate(String indexType, List<ColumnDef> columns, String name)
    {
        Index parse = new Index();
        parse.setIndexType(indexType);
        parse.setColumns(columns);
        parse.setName(name);
        return parse;
    }



    /**
     * プライマリキー生成
     *
     * @param columns カラムリスト
     * @return 生成したインデックス情報
     */
    public static Index primaryKey(List<ColumnDef> columns)
    {
        return Index.generate(Index.PRIMARY_KEY, columns, null);
    }



    /**
     * ユニークキー生成
     *
     * @param columns カラムリスト
     * @return 生成したインデックス情報
     */
    public static Index uniqueKey(List<ColumnDef> columns)
    {
        return Index.generate(Index.UNIQUE_KEY, columns, null);
    }



    /**
     * インデックス生成
     *
     * @param name    インデックス名称
     * @param columns カラムリスト
     * @return 生成したインデックス情報
     */
    public static Index index(String name, List<ColumnDef> columns)
    {
        return Index.generate(Index.INDEX, columns, name);
    }



    /**
     * ユニークインデックス生成
     *
     * @param name    インデックス名称
     * @param columns カラムリスト
     * @return 生成したインデックス情報
     */
    public static Index uniqueIndex(String name, List<ColumnDef> columns)
    {
        return Index.generate(Index.UNIQUE_INDEX, columns, name);
    }



    /**
     * インデックス情報を受けてSQL文字列を生成する
     *
     * @param index インデックス
     * @return インデックス文字列を返す
     */
    @NotNull
    public static String query(Index index)
    {
        if (index.getColumns().isEmpty() == true)
        {
            // リストが空なら空文字を返す
            return "";
        }

        List<String> columns = ColumnDef.convertColumnStrings(index.getColumns());

        StringBuffer buffer = new StringBuffer("");
        // PRIMARY KEY or UNIQUE
        buffer.append(index.getIndexType())
                .append(" (")
                .append(String.join(", ", columns))
                .append(")");

        return buffer.toString();
    }



    /**
     * インデックス情報を受けてSQL文字列を生成する
     *
     * インデックスを後付けするときに使う想定
     *
     * @param index インデックス
     * @param table テーブル名称
     * @return インデックス文字列を返す
     */
    @NotNull
    public static String query(Index index, String table)
    {
        if (index.getColumns().isEmpty() == true)
        {
            // リストが空なら空文字を返す
            return "";
        }

        List<String> columns = ColumnDef.convertColumnStrings(index.getColumns());

        StringBuffer buffer = new StringBuffer("");
        // INDEX or UNIQUE INDEX
        buffer.append(index.getIndexType())
                .append(" ")
                .append(index.getName())
                .append(" ON ")
                .append(table)
                .append(" (")
                .append(String.join(", ", columns))
                .append(")");

        return buffer.toString();
    }



    public String getIndexType()
    {
        return indexType;
    }



    public void setIndexType(String indexType)
    {
        this.indexType = indexType;
    }



    public List<ColumnDef> getColumns()
    {
        return columns;
    }



    public void setColumns(List<ColumnDef> columns)
    {
        this.columns = columns;
    }



    public String getName()
    {
        return name;
    }



    public void setName(String name)
    {
        this.name = name;
    }
}
