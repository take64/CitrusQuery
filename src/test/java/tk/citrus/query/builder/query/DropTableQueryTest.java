package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DropTableQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        DropTableQuery dropTableQuery = new DropTableQuery();

        // クエリを生成して取得
        String query = dropTableQuery
                .table("employees")
                .callQuery();

        // 想定通りか
        assertEquals("DROP TABLE employees;", query);
    }
}
