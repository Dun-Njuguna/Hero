import java.util.ArrayList;
import java.util.List;

public class Hero {

	private String mName;
	private String mAge;
	private String mSpecialPower;
	private String mWeakness;
	private static List<Hero> instances = new ArrayList<Hero>();
  	private int mId;


	public Hero(String name, String age, String power, String weakness)
	{
		mName = name;
		mAge = age;
		mSpecialPower = power;
		mWeakness = weakness;
		instances.add(this);
		mId = instances.size();
	}

	public String getName() 
	{
    	return mName;
  	}

	public String getAge() 
	{
    	return mAge;
  	}

  	public String getSpecialPower()
  	{
  		return mSpecialPower;
  	}

  	public String getWeakness()
  	{
  		return mWeakness;
  	}

	public static List<Hero> all() {
		return instances;
	}

	public static void clear() {
	  instances.clear();
	}

  	public int getId() {
       return mId;
  	}

	public static Hero find(int id) {
	  return instances.get(id - 1);
	}

}