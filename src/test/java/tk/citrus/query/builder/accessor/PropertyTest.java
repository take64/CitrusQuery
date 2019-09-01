package tk.citrus.query.builder.accessor;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * テーブルプロパティ
 */
class PropertyTest
{
    @Test
    public void プロパティが取得できる()
    {
        EmployeePropertyTest property = new EmployeePropertyTest();

        assertArrayEquals(new String[]{"employee_id", "name"},
                property.propertyKeys().toArray());
    }

}
