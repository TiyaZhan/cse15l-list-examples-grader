import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

class LengthChecker implements StringChecker{
  @Override
  public boolean checkString(String s){
    return s.length()>3;
  }
}
public class TestListExamples {
  // Write your grading tests here!
  @Test
  public void testSimpleFilter(){
    ArrayList<String> input = new ArrayList<>();
    input.add("abd");
    input.add("abcd");
    input.add("aaaaaa");
    input.add("bbbbb");
    ArrayList<String> exp = new ArrayList<>();
    exp.add("abcd");
    exp.add("aaaaaa");
    exp.add("bbbbb");
    assertEquals(exp, ListExamples.filter(input, new LengthChecker()));
  }

  @Test 
	public void testFilter() {
    ArrayList<String> input = new ArrayList<String>();
    ArrayList<String> exp = new ArrayList<String>();
    input.add("a");
    input.add("abcd");
    input.add("accd");
    exp.add("abcd");
  
    exp.add("accd");
    ArrayList<String> result = (ArrayList<String>)ListExamples.filter(input, new LengthChecker());
    assertEquals(exp.get(1), result.get(1));
	}

  @Test(timeout = 1000)
  public void testSimpleMerge(){
    ArrayList<String> input1 = new ArrayList<>();
    ArrayList<String> input2 = new ArrayList<>();
    ArrayList<String> exp = new ArrayList<>();

    input1.add("a");
    input2.add("b");
    exp.add("a");
    exp.add("b");
    assertEquals(exp, ListExamples.merge(input2, input1));
  }
  @Test(timeout = 1000)
  public void testMerge()
  {
    ArrayList<String> input1 = new ArrayList<String>();
    ArrayList<String> input2 = new ArrayList<String>();

    input1.add("a");
    input1.add("c");
    input2.add("b");
    input2.add("d");
    ArrayList<String> exp = new ArrayList<String>();
    exp.add("a");
    exp.add("b");
    exp.add("c");
    exp.add("d");

    assertEquals(exp, ListExamples.merge(input1, input2));
    }
}
