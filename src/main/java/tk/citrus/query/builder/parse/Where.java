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
    public static String PREPEND_AND = "AND";

    /**
     * OR 接続
     */
    public static String PREPEND_OR = "OR";

    /**
     * = 比較
     */
    public static String OPERATOR_EQUAL = "=";

    /**
     * != 比較
     */
    public static String OPERATOR_NOT_EQUAL = "!=";

    /**
     * IN 句
     */
    public static String OPERATOR_IN = "IN";

    /**
     * NOT IN 句
     */
    public static String OPERATOR_NOT_IN = "NOT IN";

    /**
     * BETWEEN 句
     */
    public static String OPERATOR_BETWEEN = "BETWEEN";

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
     * @param column
     * @param operator
     * @param value
     * @param prepend
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
     * @param column
     * @param operator
     * @param value
     * @return 生成したWHERE情報
     */
    public static Where generate(String column, String operator, Object value)
    {
        return Where.generate(column, operator, value, PREPEND_AND);
    }



    /**
     * WHERE句生成(=)
     *
     * @param column
     * @param value
     * @return 生成したWHERE情報
     */
    public static Where generate(String column, Object value)
    {
        return Where.generate(column, OPERATOR_EQUAL, value, PREPEND_AND);
    }



    /**
     * WHERE句リストを受けてSQL文字列を生成する
     *
     * @param wheres
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

        StringBuffer buffer = new StringBuffer("");
        wheres.forEach(where -> {
            if (buffer.length() > 0)
            {
                // 条件接続子追加
                buffer.append(" ")
                        .append(where.getPrepend())
                        .append(" ");
            }
            // 条件追加
            buffer.append(where.getColumn())
                    .append(" ")
                    .append(where.getOperator())
                    .append(" ?");
        });

        // WHERE句挿入
        buffer.insert(0, " WHERE ");

        return buffer.toString();
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
