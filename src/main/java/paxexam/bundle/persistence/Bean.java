package paxexam.bundle.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ingo Weiss on 25/01/2014.
 */

@Entity
public class Bean
{
	@Id
	int id;
	@Column(nullable = false)
	String property;

	public Bean()
	{
	}

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return property;
	}
}
