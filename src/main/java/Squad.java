public class Squad {

	private String mSquadName;
	private int mMaxSize;
	private String mCause;
	private Hero mTeam;

	public Squad(String name, int size, String cause)
	{
		mSquadName = name;
		mMaxSize = size;
		mCause = cause;
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
}