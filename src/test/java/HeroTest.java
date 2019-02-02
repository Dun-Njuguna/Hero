import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest{

  @After
  public void tearDown() {
    Hero.clear();
  }

  @Test
  public void hero_instantiatesCorrectly_true() 
  {
    Hero testHero = new Hero("dun", "10" ,"nn", "nn");
    assertEquals(true, testHero instanceof Hero);
  }

  @Test
  public void getName_returns_name_dun()
  {
  	Hero testHero = new Hero("dun", "10" ,"nn", "nn");
  	assertEquals("dun", testHero.getName());
  }

  @Test
  public void getAge_returns_age_10()
  {
  	Hero testHero = new Hero("dun", "10" ,"nn", "nn");
  	assertEquals("10",testHero.getAge());
  }

  @Test
  public void getPower_returns_power_nn()
  {
  	Hero testHero = new Hero("dun", "10" ,"nn", "nn");
  	assertEquals("nn", testHero.getSpecialPower());
  }

  @Test
  public void getWeakness_returns_weakness_nn()
  {
  	Hero testHero = new Hero("dun", "10" ,"nn", "nn");
  	assertEquals("nn", testHero.getWeakness());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Hero firstTask = new Hero("dun", "10" ,"nn", "nn");
    Hero secondTask = new Hero("dun", "10" ,"nn", "nn");
    assertEquals(true, Hero.all().contains(firstTask));
    assertEquals(true, Hero.all().contains(secondTask));
  }

  @Test
  public void getId_heroInstantiateWithAnID_1() {
    Hero myTask = new Hero("dun", "10" ,"nn", "nn");
    assertEquals(1, myTask.getId());
  }

  @Test
  public void find_returnsheroWithSameId_secondTask() {
    Hero firstTask = new Hero("dun", "10" ,"nn", "nn");
    Hero secondTask = new Hero("dun", "10" ,"nn", "nn");
    assertEquals(Hero.find(secondTask.getId()), secondTask);
  }
}