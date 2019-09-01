package tk.citrus.query.builder.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;
import tk.citrus.query.builder.parse.ColumnDef;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreateTableQueryTest
{
    @Test
    void 生成_SQLが生成できる()
    {
        CreateTableQuery createTableQuery = new CreateTableQuery();

        // クエリを生成して取得
        String query = createTableQuery
                .table("employees")
                .column("employee_id", ColumnDef.INTEGER, true)
                .column("name", ColumnDef.TEXT)
                .primaryKey(new ArrayList(){{
                   add("employee_id");
                }})
                .callQuery();

        // 想定通りか
        assertEquals("CREATE TABLE employees (employee_id INTEGER NOT NULL, name TEXT, PRIMARY KEY (employee_id));", query);
    }
}
