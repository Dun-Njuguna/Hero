import java.util.ArrayList;
import java.util.List;

public class Hero {

	private String mName;
	private int mAge;
	private String mSpecialPower;
	private String mWeakness;
	private static List<Hero> instances = new ArrayList<Hero>();
  	private int mId;
  	private List<Squad> mSquad;

	public Hero(String name, int age, String power, String weakness)
	{
		mName = name;
		mAge = age;
		mSpecialPower = power;
		mWeakness = weakness;
		instances.add(this);
		mId = instances.size();
		mSquad = new ArrayList<Squad>();
	}

	public String getName() 
	{
    	return mName;
  	}

	public int getAge() 
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
    	try {
    	  return instances.get(id - 1);
    	}catch (IndexOutOfBoundsException exception) {
      	  return null;
    	}
	}

	public List<Squad> getSquad() {
	  return mSquad;
	}

	public void addSquad(Squad squad) {
	  mSquad.add(squad);
	}

}