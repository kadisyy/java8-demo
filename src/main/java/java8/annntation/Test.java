package java8.annntation;


/**
 * Test.java
 * 
 * @author IT唐伯虎 2014年7月11日
 */
public class Test
{
    public static void main(String[] args)
    {
        User user = new User();
        
        user.setName("liang11");
        user.setAge("11");
        
        System.out.println(UserCheck.check(user));
    }
}