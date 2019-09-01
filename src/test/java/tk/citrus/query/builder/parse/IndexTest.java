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
 * インデックス定義test
 */
class IndexTest
{
    @Test
    void 生成_CREATE_TABLE時のプライマリキー()
    {
        // カラム定義
        List<ColumnDef> columns = new ArrayList<>();
        columns.add(ColumnDef.generate("employee_id", ColumnDef.INTEGER, true));
        columns.add(ColumnDef.generate("name", ColumnDef.TEXT, "TEST"));

        // プライマリキー
        Index index = Index.primaryKey(columns);

        // クエリを生成して取得
        String query = Index.query(index);

        // 想定通りか
        assertEquals("PRIMARY KEY (employee_id, name)", query);
    }



    @Test
    void 生成_CREATE_TABLE時のユニークキー()
    {
        // カラム定義
        List<ColumnDef> columns = new ArrayList<>();
        columns.add(ColumnDef.generate("employee_id", ColumnDef.INTEGER, true));
        columns.add(ColumnDef.generate("name", ColumnDef.TEXT, "TEST"));

        // ユニークキー
        Index index = Index.uniqueKey(columns);

        // クエリを生成して取得
        String query = Index.query(index);

        // 想定通りか
        assertEquals("UNIQUE (employee_id, name)", query);
    }



    @Test
    void 生成_ALTER_TABLE時のインデックス()
    {
        // カラム定義
        List<ColumnDef> columns = new ArrayList<>();
        columns.add(ColumnDef.generate("employee_id", ColumnDef.INTEGER, true));
        columns.add(ColumnDef.generate("name", ColumnDef.TEXT, "TEST"));

        // インデックス
        Index index = Index.index("idx_employees", columns);

        // クエリを生成して取得
        String query = Index.query(index, "employees");

        // 想定通りか
        assertEquals("INDEX idx_employees ON employees (employee_id, name)", query);
    }



    @Test
    void 生成_ALTER_TABLE時のユニークインデックス()
    {
        // カラム定義
        List<ColumnDef> columns = new ArrayList<>();
        columns.add(ColumnDef.generate("employee_id", ColumnDef.INTEGER, true));
        columns.add(ColumnDef.generate("name", ColumnDef.TEXT, "TEST"));

        // プライマリキー
        Index index = Index.uniqueIndex("uk_employees", columns);

        // クエリを生成して取得
        String query = Index.query(index, "employees");

        // 想定通りか
        assertEquals("UNIQUE INDEX uk_employees ON employees (employee_id, name)", query);
    }
}
