package MyUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateUtil {
    public static final int standard_time=14;
    public DateUtil(){}
    public String getReturnDate(){
        Date date=new Date();
        SimpleDateFormat return_date=new SimpleDateFormat("yyyy-MM-dd");
        return return_date.format(date.getTime()+standard_time*24*60*60*1000);
    }
    public Date toDate(String strDate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }
}
