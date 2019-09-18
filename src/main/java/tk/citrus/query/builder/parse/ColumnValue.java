package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

/**
 * カラムと値の対応
 */
public class ColumnValue
{
    /**
     * カラム
     */
    private String column;

    /**
     * 値
     */
    private Object value;



    /**
     * カラムと値
     *
     * @param column カラム名
     * @param value  値
     * @return 生成したカラムと値情報
     */
    public static ColumnValue generate(String column, Object value)
    {
        ColumnValue parse = new ColumnValue();
        parse.setColumn(column);
        parse.setValue(value);
        return parse;
    }



    public String getColumn()
    {
        return column;
    }



    public void setColumn(String column)
    {
        this.column = column;
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
