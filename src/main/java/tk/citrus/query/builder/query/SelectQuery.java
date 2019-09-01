package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;
import tk.citrus.query.builder.parse.Column;
import tk.citrus.query.builder.parse.Order;
import tk.citrus.query.builder.parse.Where;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SELECT
 */
public class SelectQuery extends QueryStruct
{
    /**
     * カラム
     */
    private List<Column> columns = new ArrayList<>();

    /**
     * WHERE句
     */
    private List<Where> wheres = new ArrayList<>();

    /**
     * ORDER BY句
     */
    private List<Order> orders = new ArrayList<>();



    /**
     * constructor.
     */
    public SelectQuery()
    {
        this.setQueryType(QueryTypes.SELECT);
    }



    /**
     * 取得カラムの設定
     *
     * @param columns カラム名配列
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery column(String[] columns)
    {
        // カラムの追加
        Arrays.stream(columns).forEach(column -> {
            this.getColumns().add(Column.generate(column));
        });

        return this;
    }



    /**
     * 取得カラムの設定
     *
     * @param column カラム名
     * @param alias  エイリアス
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery column(String column, String alias)
    {
        // カラムの追加
        this.getColumns().add(Column.generate(column, alias));

        return this;
    }



    /**
     * 取得カラムの設定
     *
     * @param column カラム名
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery column(String column)
    {
        return this.column(column, null);
    }



    /**
     * テーブル設定
     *
     * @param table テーブル名
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery from(String table)
    {
        this.setTable(table);

        return this;
    }



    /**
     * 比較子指定のWHERE句
     *
     * @param column   カラム名
     * @param operator 比較
     * @param value    値
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery where(String column, String operator, Object value)
    {
        this.getWheres().add(Where.generate(column, operator, value));

        return this;
    }



    /**
     * 単純なイコールのWHERE句
     *
     * @param column カラム名
     * @param value  値
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery where(String column, Object value)
    {
        return this.where(column, Where.OPERATOR_EQUAL, value);
    }



    /**
     * ORDER BY句
     *
     * @param column カラム名
     * @param order  順序
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery orderBy(String column, String order)
    {
        this.getOrders().add(Order.generate(column, order));

        return this;
    }



    /**
     * ORDER BY 自動昇順
     *
     * @param column カラム名
     * @return メソッドチェイン用の自身返却
     */
    public SelectQuery orderBy(String column)
    {
        return this.orderBy(column, Order.ORDER_ASC);
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuffer buffer = new StringBuffer("");

        // カラム文字列
        String column = Column.query(this.getColumns());

        // FROM句まで
        buffer.append(this.getQueryType())
                .append(" ")
                .append(column)
                .append(" FROM ")
                .append(this.getTable());

        // WHERE句
        buffer.append(Where.query(this.getWheres()));

        // ORDER BY句以降
        buffer.append(Order.query(this.getOrders()));

        return buffer.append(";").toString();
    }



    public List<Column> getColumns()
    {
        return columns;
    }



    public void setColumns(List<Column> columns)
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



    public List<Order> getOrders()
    {
        return orders;
    }



    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }
}
