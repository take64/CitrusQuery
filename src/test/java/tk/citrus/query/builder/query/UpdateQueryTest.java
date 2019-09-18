package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        UpdateQuery updateQuery = new UpdateQuery();

        // クエリを生成して取得
        String query = updateQuery.table("employees")
                .set("name","smith")
                .where("employee_id", 1000)
                .where("name", "john")
                .callQuery();

        // 想定通りか
        assertEquals("UPDATE employees SET name = ? WHERE employee_id = ? AND name = ?;", query);
    }
}
