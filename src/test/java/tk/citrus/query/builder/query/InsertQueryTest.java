package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        InsertQuery insertQuery = new InsertQuery();

        // クエリを生成して取得
        String query = insertQuery.table("employees")
                .value("employee_id", 1000)
                .value("name", "jhon")
                .callQuery();

        // 想定通りか
        assertEquals("INSERT INTO employees (employee_id, name) VALUES (?, ?);", query);
    }
}
