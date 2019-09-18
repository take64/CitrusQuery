package tk.citrus.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriversTest
{
    @Test
    void クラスの読み込みができる()
    {
        try
        {
            Drivers.load(Drivers.SQLITE);
        }
        catch (ClassNotFoundException e)
        {
            fail(e.getMessage());
        }
        assertTrue(true);
    }
}
