/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simtravel.test;
 
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
 
public class DateIterator
   implements Iterator<Date>, Iterable<Date>
{
 
    private Calendar end = Calendar.getInstance();
    private Calendar current = Calendar.getInstance();
 
    public DateIterator(Date start, Date end)
    {
        this.end.setTime(end);
        this.end.add(Calendar.DATE, -1);
        this.current.setTime(start);
        this.current.add(Calendar.DATE, -1);
    }
 
    @Override
    public boolean hasNext()
    {
        return !current.after(end);
    }
 
    @Override
    public Date next()
    {
        current.add(Calendar.DATE, 30);
        return current.getTime();
    }
 
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException(
           "Cannot remove");
    }
 
    @Override
    public Iterator<Date> iterator()
    {
        return this;
    }
 
    public static void main(String[] args)
    {
      Date d1 = new Date();
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, 100);
      Date d2 = cal.getTime();
 
      Iterator<Date> i = new DateIterator(d1, d2);
      while(i.hasNext())
      {
         Date date = i.next();
         System.out.println(date);
      }
    }
}