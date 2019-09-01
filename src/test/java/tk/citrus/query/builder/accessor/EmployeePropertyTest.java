package tk.citrus.query.builder.accessor;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.annotation.PROPERTY;

class EmployeePropertyTest extends Property
{
    @PROPERTY
    protected Integer employee_id;

    @PROPERTY
    protected String name;



    public Integer getEmployeeId()
    {
        return employee_id;
    }



    public void setEmployeeId(Integer employee_id)
    {
        this.employee_id = employee_id;
    }



    public String getName()
    {
        return name;
    }



    public void setName(String name)
    {
        this.name = name;
    }
}
