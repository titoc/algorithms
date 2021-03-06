package misc;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class TestEquationSolver {

    @Test
    public void testSolve() throws Exception{
        common(new EquationSolver());
    }

    @Test
    public void testSolveBackTrack() throws Exception{
        common(new EquationSolverBackTrack());
    }

    public void common(EqSolver solver) throws Exception{
        String s;

        s = "4\n" +
                "8 5 2 -2";

        processSpec(s, "-*", solver);

        // works but too slow
        s = "5\n" +
                "1 1 1 1 4";

        processSpec(s, "+++", solver);

        s = "5\n" +
                "7 5 3 2 29";

        processSpec(s, "*-*", solver);

        s = "7\n" +
                "1 2 3 4 5 6 720";

        processSpec(s, "*****", solver);

        s = "7\n" +
                "4 -3 6 2 20 5 3";

        processSpec(s, "+*++-", solver);

        s = "3\n" +
                "-15 -15 225";

        processSpec(s, "*", solver);

        s = "3\n" +
                "1 2 2";

        processSpec(s, "*", solver);

        s = "4\n" +
                "1 2 3 6";

        processSpec(s, "**", solver);

        s = "5\n" +
                "1 2 3 4 24";

        processSpec(s, "***", solver);


    }

    private void processSpec(String s, String expected, EqSolver solver) throws Exception{
        Scanner scanner = new Scanner(new ByteArrayInputStream(s.getBytes("UTF-8")));
        scanner.useDelimiter("\n");
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<String> nums = new ArrayList<String>();
        String line = scanner.nextLine().trim();
        StringTokenizer st = new StringTokenizer(line, " ");
        for (int i = 0; i < n - 1; i++) {
            nums.add(st.nextToken().trim());
        }
        int result = Integer.parseInt(st.nextToken().trim());
        List<String> out = solver.solve(nums, result);
        StringBuilder sb = new StringBuilder();
        if(out != null) {
            for(String o : out) {
                sb.append(o);
            }
        }
        Assert.assertEquals(expected, sb.toString().trim());
        System.out.println(sb.length() == 0 ? "NO SOLUTION" : sb.toString());
    }
}
