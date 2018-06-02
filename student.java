
public class student extends person
{
  private String program;
private String id;
private String email;

  public student(String n, String bdate, String idcard, String addr, String prog, String stuid, String mail)
  {
     super(n, bdate,idcard,addr);
     program = prog;
id = stuid;
email = mail;

  }
 
 public String getprogram()
	{
	  return  program;
	}
public String getid()
	{
	  return  id;
	}
public String getemail()
	{
	  return  email;
	}
}