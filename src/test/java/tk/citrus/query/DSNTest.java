package tk.citrus.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DSNTest
{
    @Test
    void DSN情報が生成できる()
    {
        String filepath = "/var/lib/date.sqlite";

        DSN dsn = DSN.sqliteDSN(filepath);

        assertEquals(DSN.JDBC_SQLITE, dsn.getProtocol());
        assertEquals(filepath, dsn.getFilepath());
    }



    @Test
    void DSN文字列が生成できる()
    {
        String filepath = "/var/lib/date.sqlite";

        DSN dsn = DSN.sqliteDSN(filepath);

        assertEquals(DSN.JDBC_SQLITE + filepath,
                dsn.toString());
    }
}
