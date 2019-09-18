package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;
import tk.citrus.query.builder.parse.Order;
import tk.citrus.query.builder.parse.Where;

import java.util.ArrayList;
import java.util.List;

/**
 * INSERT
 */
public class DeleteQuery extends QueryStruct<DeleteQuery>
{

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
    public DeleteQuery()
    {
        this.setQueryType(QueryTypes.DELETE);
    }



    /**
     * テーブル設定
     *
     * @param table テーブル名
     * @return メソッドチェイン用の自身返却
     */
    public DeleteQuery from(String table)
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
    public DeleteQuery where(String column, String operator, Object value)
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
    public DeleteQuery where(String column, Object value)
    {
        return this.where(column, Where.OPERATOR_EQUAL, value);
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuilder builder = new StringBuilder("");

        // FROM句まで
        builder.append(this.getQueryType())
                .append(" FROM ")
                .append(this.getTable());

        // WHERE句
        builder.append(Where.query(this.getWheres()));

        return builder.append(";").toString();
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
