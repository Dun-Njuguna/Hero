import java.util.ArrayList;
import java.util.List;

public class Squad {

	private String mSquadName;
	private int mMaxSize;
	private String mCause;
	private static ArrayList<Squad> instances = new ArrayList<Squad>();
	private int mId;

	public Squad(String name, int size, String cause)
	{
		mSquadName = name;
		mMaxSize = size;
		mCause = cause;
		instances.add(this);
		mId = instances.size();
	}

	public String getName() 
	{
    	return mSquadName;
  	}

	public int getSize() 
	{
    	return mMaxSize;
  	}

  	public String getCause()
  	{
  		return mCause;
  	}

  	public static Squad find(int id) {
    	try {
    	  return instances.get(id - 1);
    	}catch (IndexOutOfBoundsException exception) {
      	  return null;
    	}
	}

	public static List<Squad> all() {
		return instances;
	}
}