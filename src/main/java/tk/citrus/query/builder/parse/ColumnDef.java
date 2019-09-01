package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * カラム定義
 */
public class ColumnDef
{
    /**
     * 型：TEXT
     */
    public static String TEXT = "TEXT";

    /**
     * 型：NUMERIC
     */
    public static String NUMERIC = "NUMERIC";

    /**
     * 型：INTEGER
     */
    public static String INTEGER = "INTEGER";

    /**
     * 型：REAL
     */
    public static String REAL = "REAL";

    /**
     * 型：BLOB
     */
    public static String BLOB = "BLOB";

    /**
     * カラム
     */
    private String column;

    /**
     * 型
     */
    private String type;

    /**
     * NOT NULL
     */
    private Boolean notNull;

    /**
     * 初期値
     */
    private String defaultValue;



    /**
     * カラム生成
     *
     * @param column      カラム名称
     * @param type        型
     * @param isNotNull   true:NULL不許可
     * @param defaultVale デフォルト値
     * @return 生成したカラム情報
     */
    public static ColumnDef generate(String column, String type, Boolean isNotNull, String defaultVale)
    {
        ColumnDef parse = new ColumnDef();
        parse.setColumn(column);
        parse.setType(type);
        parse.setNotNull(isNotNull);
        parse.setDefaultValue(defaultVale);
        return parse;
    }



    /**
     * カラム生成
     *
     * @param column    カラム名称
     * @param type      型
     * @param isNotNull true:
     * @return 生成したカラム情報
     */
    public static ColumnDef generate(String column, String type, Boolean isNotNull)
    {
        return ColumnDef.generate(column, type, isNotNull, null);
    }



    /**
     * カラム生成
     *
     * @param column       カラム名称
     * @param type         型
     * @param defaultValue デフォルト値
     * @return 生成したカラム情報
     */
    public static ColumnDef generate(String column, String type, String defaultValue)
    {
        return ColumnDef.generate(column, type, false, defaultValue);
    }



    /**
     * カラム生成
     *
     * @param column カラム名称
     * @param type   型
     * @return 生成したカラム情報
     */
    public static ColumnDef generate(String column, String type)
    {
        return ColumnDef.generate(column, type, false);
    }



    /**
     * カラムリストを受けてSQL文字列を生成する
     *
     * @param columns カラムリスト
     * @return ", " 区切りのカラム文字列を返す
     */
    @NotNull
    public static String query(List<ColumnDef> columns)
    {
        if (columns.isEmpty() == true)
        {
            // リストが空なら*を返す
            return "*";
        }

        StringBuffer buffer = new StringBuffer("");
        columns.forEach(column -> {
            if (buffer.length() > 0)
            {
                // カラム接続子追加
                buffer.append(", ");
            }
            // カラム追加
            buffer.append(column.getColumn());
            // 型追加
            buffer.append(" ").append(column.getType());
            // NOT NULL
            if (column.isNotNull() == true)
            {
                buffer.append(" NOT NULL");
            }
            // DEFAULT VALUE
            if (column.getDefaultValue() != null)
            {
                buffer.append(" DEFAULT ").append(column.getDefaultValue().toString());
            }
        });

        return buffer.toString();
    }



    /**
     * カラム文字列の配列を生成して返却
     *
     * @param columns カラムリスト
     * @return カラム文字列の配列
     */
    public static List<String> convertColumnStrings(List<ColumnDef> columns)
    {
        List<String> results = new ArrayList<>();
        columns.forEach(column -> {
            results.add(column.getColumn());
        });
        return results;
    }



    public String getColumn()
    {
        return column;
    }



    public void setColumn(String column)
    {
        this.column = column;
    }



    public String getType()
    {
        return type;
    }



    public void setType(String type)
    {
        this.type = type;
    }



    public Boolean isNotNull()
    {
        return notNull;
    }



    public void setNotNull(Boolean notNull)
    {
        this.notNull = notNull;
    }



    public String getDefaultValue()
    {
        return defaultValue;
    }



    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }
}
