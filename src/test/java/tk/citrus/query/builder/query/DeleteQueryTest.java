package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        DeleteQuery deleteQuery = new DeleteQuery();

        // クエリを生成して取得
        String query = deleteQuery.from("employees")
                .where("employee_id", 1000)
                .where("name", "john")
                .callQuery();

        // 想定通りか
        assertEquals("DELETE FROM employees WHERE employee_id = ? AND name = ?;", query);
    }
}
