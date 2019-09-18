package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * カラム指定
 */
public class Column
{
    /**
     * カラム
     */
    private String column;

    /**
     * カラムエイリアス
     */
    private String alias;



    /**
     * カラム生成
     *
     * @param column カラム名
     * @param alias  エイリアス
     * @return 生成したカラム情報
     */
    public static Column generate(String column, String alias)
    {
        Column parse = new Column();
        parse.setColumn(column);
        parse.setAlias(alias);
        return parse;
    }



    /**
     * カラム生成
     *
     * @param column カラム名
     * @return 生成したカラム情報
     */
    public static Column generate(String column)
    {
        return Column.generate(column, null);
    }



    /**
     * カラムリストを受けてSQL文字列を生成する
     *
     * @param columns Columnリスト
     * @return ", " 区切りのカラム文字列を返す
     */
    @NotNull
    public static String query(List<Column> columns)
    {
        if (columns.isEmpty() == true)
        {
            // リストが空なら*を返す
            return "*";
        }

        StringBuilder builder = new StringBuilder("");
        columns.forEach(column -> {
            if (builder.length() > 0)
            {
                // カラム接続子追加
                builder.append(", ");
            }
            // カラム追加
            builder.append(column.getColumn());
            if (column.getAlias() != null)
            {
                // エイリアス追加
                builder.append(" AS ")
                        .append(column.getAlias());
            }
        });

        return builder.toString();
    }


    public String getColumn()
    {
        return column;
    }



    public void setColumn(String column)
    {
        this.column = column;
    }



    public String getAlias()
    {
        return alias;
    }



    public void setAlias(String alias)
    {
        this.alias = alias;
    }
}
