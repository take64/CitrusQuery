package tk.citrus.query.builder.parse;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * カラム定義test
 */
class ColumnDefTest
{
    @Test
    void 生成_SQLパーツが生成できる()
    {
        // カラム定義
        List<ColumnDef> columns = new ArrayList<>();
        columns.add(ColumnDef.generate("employee_id", ColumnDef.INTEGER, true));
        columns.add(ColumnDef.generate("name", ColumnDef.TEXT, "TEST"));

        // クエリを生成して取得
        String query = ColumnDef.query(columns);

        // 想定通りか
        assertEquals("employee_id INTEGER NOT NULL, name TEXT DEFAULT TEST", query);
    }
}
