
public class person
{
	private String name;
	private String birthdate;
private String cnic;
private String address;
	public person(String n, String bdate, String idcard, String addr)
	{
	  name = n;
	  birthdate= bdate;
cnic = idcard;
address = addr;

	}

	public String getname()
	{
	  return  name;
	}
public String getdob()
	{
	  return  birthdate;
	}
public String getcnic()
	{
	  return  cnic;
	}
public String getaddress()
	{
	  return  address;
	}
}