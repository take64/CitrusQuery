package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * WHERE句
 */
public class Where
{
    /**
     * AND 接続
     */
    public static final String PREPEND_AND = "AND";

    /**
     * OR 接続
     */
    public static final String PREPEND_OR = "OR";

    /**
     * = 比較
     */
    public static final String OPERATOR_EQUAL = "=";

    /**
     * != 比較
     */
    public static final String OPERATOR_NOT_EQUAL = "!=";

    /**
     * IN 句
     */
    public static final String OPERATOR_IN = "IN";

    /**
     * NOT IN 句
     */
    public static final String OPERATOR_NOT_IN = "NOT IN";

    /**
     * BETWEEN 句
     */
    public static final String OPERATOR_BETWEEN = "BETWEEN";

    /**
     * 条件接続子
     */
    private String prepend = Where.PREPEND_AND;

    /**
     * 条件カラム
     */
    private String column;

    /**
     * 条件比較子
     */
    private String operator;

    /**
     * 条件比較値
     */
    private Object value;



    /**
     * WHERE句生成
     *
     * @param column   カラム名
     * @param operator 比較
     * @param value    値
     * @param prepend  条件接続子
     * @return 生成したWHERE情報
     */
    public static Where generate(String column, String operator, Object value, String prepend)
    {
        Where parse = new Where();
        parse.setPrepend(prepend);
        parse.setColumn(column);
        parse.setOperator(operator);
        parse.setValue(value);
        return parse;
    }



    /**
     * WHERE句生成(=)
     *
     * @param column   カラム名
     * @param operator 比較
     * @param value    値
     * @return 生成したWHERE情報
     */
    public static Where generate(String column, String operator, Object value)
    {
        return Where.generate(column, operator, value, PREPEND_AND);
    }



    /**
     * WHERE句生成(=)
     *
     * @param column カラム名
     * @param value  値
     * @return 生成したWHERE情報
     */
    public static Where generate(String column, Object value)
    {
        return Where.generate(column, OPERATOR_EQUAL, value, PREPEND_AND);
    }



    /**
     * WHERE句リストを受けてSQL文字列を生成する
     *
     * @param wheres Whereリスト
     * @return " WHERE 〜" から始まるWHERE句文字列を返す
     */
    @NotNull
    public static String query(List<Where> wheres)
    {
        if (wheres.isEmpty() == true)
        {
            // リストが空なら空文字を返す
            return "";
        }

        StringBuilder builder = new StringBuilder("");
        wheres.forEach(where -> {
            if (builder.length() > 0)
            {
                // 条件接続子追加
                builder.append(" ")
                        .append(where.getPrepend())
                        .append(" ");
            }
            // 条件追加
            builder.append(where.getColumn())
                    .append(" ")
                    .append(where.getOperator())
                    .append(" ?");
        });

        // WHERE句挿入
        builder.insert(0, " WHERE ");

        return builder.toString();
    }



    public String getPrepend()
    {
        return prepend;
    }



    public void setPrepend(String prepend)
    {
        this.prepend = prepend;
    }



    public String getColumn()
    {
        return column;
    }



    public void setColumn(String column)
    {
        this.column = column;
    }



    public String getOperator()
    {
        return operator;
    }



    public void setOperator(String operator)
    {
        this.operator = operator;
    }



    public Object getValue()
    {
        return value;
    }



    public void setValue(Object value)
    {
        this.value = value;
    }
}
