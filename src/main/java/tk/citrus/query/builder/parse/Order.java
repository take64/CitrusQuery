package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * ORDER BY句
 */
public class Order
{
    /**
     * 昇順
     */
    public static final String ORDER_ASC = "ASC";

    /**
     * 降順
     */
    public static final String ORDER_DESC = "DESC";

    /**
     * 順序指定カラム
     */
    private String column;

    /**
     * 順序指定方向
     */
    private String order;



    /**
     * ORDER BY句生成
     *
     * @param column カラム
     * @param order  順序
     * @return 生成したORDER BY情報
     */
    public static Order generate(String column, String order)
    {
        Order parse = new Order();
        parse.setColumn(column);
        parse.setOrder(order);
        return parse;
    }



    /**
     * ORDER BY句生成
     *
     * @param column
     * @return 生成したORDER BY情報
     */
    public static Order generate(String column)
    {
        return Order.generate(column, ORDER_ASC);
    }



    /**
     * ORDER BY句リストを受けてSQL文字列を生成する
     *
     * @param orders Orderリスト
     * @return " ORDER BY 〜" から始まるORDER BY句文字列を返す
     */
    @NotNull
    public static String query(List<Order> orders)
    {
        if (orders.isEmpty() == true)
        {
            // リストが空なら空文字を返す
            return "";
        }

        StringBuilder builder = new StringBuilder("");
        orders.forEach(order -> {
            if (builder.length() > 0)
            {
                // 接続子追加
                builder.append(", ");
            }
            // 順序追加
            builder.append(order.getColumn())
                    .append(" ")
                    .append(order.getOrder());
        });

        // ORDER BY句挿入
        builder.insert(0, " ORDER BY ");

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



    public String getOrder()
    {
        return order;
    }



    public void setOrder(String order)
    {
        this.order = order;
    }
}
