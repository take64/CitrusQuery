package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.QueryTypes;

/**
 * DROP TABLE
 */
public class DropTableQuery extends QueryStruct<DropTableQuery>
{
    /**
    * constructor.
     */
    public DropTableQuery()
    {
        this.setQueryType(QueryTypes.DROP_TABLE);
    }



    @Override
    public String callQuery()
    {
        // 文字列作成
        StringBuilder builder = new StringBuilder("");

        // DROP TABLE
        builder.append(this.getQueryType())
                .append(" ")
                .append(this.getTable());

        return builder.append(";").toString();
    }
}
