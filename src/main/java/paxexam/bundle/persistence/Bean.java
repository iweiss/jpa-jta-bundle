package paxexam.bundle.persistence;

/**
 * Created by lasombra on 25/01/2014.
 */
public class Bean
{
	String property;

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	@Override
	public String toString()
	{
		return property;
	}
}
