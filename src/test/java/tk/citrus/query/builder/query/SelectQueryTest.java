package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        SelectQuery selectQuery = new SelectQuery();

        // クエリを生成して取得
        String query = selectQuery.from("employees")
                .column("employee_id", "id")
                .column("name")
                .where("employee_id", 1)
                .where("name", "LIKE", "john%")
                .orderBy("employee_id")
                .orderBy("name", "DESC")
                .callQuery();

        // 想定通りか
        assertEquals("SELECT employee_id AS id, name FROM employees WHERE employee_id = ? AND name LIKE ? ORDER BY employee_id ASC, name DESC;", query);
    }
}
