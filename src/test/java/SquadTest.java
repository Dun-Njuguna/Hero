import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest
{
	@Test
	 public void Squad_instantiatesCorrectly_true()
	 {
	 	Squad testSquad = new Squad("first", 5, "win");
	 	assertEquals(true, testSquad instanceof Squad);
	 } 

	@Test
  	public void getName_returns_name_first()
  	{
  		Squad testSquad = new Squad("first", 5, "win");
  		assertEquals("first", testSquad.getName());
  	}
	
  	@Test
  	public void getAge_returns_age_5()
  	{
  		Squad testSquad = new Squad("first", 5, "win");
  		assertEquals(5,testSquad.getSize());
  	}
	
  	@Test
  	public void getPower_returns_power_win()
  	{
  		Squad testSquad = new Squad("first", 5, "win");
  		assertEquals("win", testSquad.getCause());
  	}
}