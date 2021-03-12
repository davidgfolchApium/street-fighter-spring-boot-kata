import com.restapisample.kata.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    String[][] fighters = new String[][]{
            new String[] {       "",    "Ryu",  "E.Honda",  "Blanka",   "Guile", ""      },
            new String[] { "Balrog",    "Ken",  "Chun Li", "Zangief", "Dhalsim", "Sagat" },
            new String[] {   "Vega", "T.Hawk", "Fei Long",  "Deejay",   "Cammy", "M.Bison"      },
    };

    @Test
    void shouldWorkWithNoMoves() {
        String[] solution = new String[]{};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, new int[]{0,1}, new String[]{}));
    }

    @Test
    void shouldWorkWithFewMoves(){
        String[] moves = new String[] { "up", "left", "right", "left", "left" };
        int[] position = new int[] {1,1};
        String[] solution = new String[] { "Ryu", "Guile", "Ryu", "Guile", "Blanka" };

        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldStopOnEmptySpacesVertically(){
        String[] moves = new String[] { "up" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Balrog" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldStopOnEmptySpacesVertically2(){
        String[] moves = new String[] { "up", "up", "up", "up" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Balrog", "Balrog", "Balrog", "Balrog" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldStopVertically(){
        String[] moves = new String[] { "down", "down", "down", "down" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Vega", "Vega", "Vega", "Vega" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldStopOnEmptySpacesVertically3(){
        String[] moves = new String[] { "up", "up", "up", "up" };
        int[] position = new int[] {1,5};
        String[] solution = new String[] { "Sagat", "Sagat", "Sagat", "Sagat" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldStopVertically4(){
        String[] moves = new String[] { "down", "down", "down", "down" };
        int[] position = new int[] {1,5};
        String[] solution = new String[] { "M.Bison", "M.Bison", "M.Bison", "M.Bison" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldRotateHorizontallyWithEmptySpaces(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] { "Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Ryu", "E.Honda" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldRotateHorizontally(){
        String[] moves = new String[] { "left", "left", "left", "left", "left", "left", "left", "left" };
        int[] position = new int[] {1,3};
        String[] solution = new String[] { "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken" };
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    @Test
    void shouldRotateOnAllRows(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] {"Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy"};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters, position, moves));
    }

    // DO NOT CHANGE THIS VARIABLE!
    // LIST WITH HOLES AND DUPLICATES
    String[][] fighters3 = new String[][]{
            new String[] {      "",    "Ryu",  "E.Honda",  "Cammy",  "Blanka",   "Guile",        "", "Chun Li" },
            new String[] {"Balrog",    "Ken",  "Chun Li",       "", "M.Bison", "Zangief", "Dhalsim", "Sagat"},
            new String[] {  "Vega",       "", "Fei Long", "Balrog",  "Deejay",   "Cammy",        "", "T.Hawk" },
    };

    @Test
    void shouldRotateOnAllRows3(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] {"Cammy", "Blanka", "Guile", "Chun Li", "Ryu", "E.Honda", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "M.Bison", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy"};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters3, position, moves));
    }

    @Test
    void shouldJustWork3(){
        String[] moves = new String[] {"down", "right", "right", "right", "down", "left", "left", "down", "right", "right", "right", "up" };
        int[] position = new int[] {0,3};
        String[] solution = new String[] {"Cammy", "Blanka", "Guile", "Chun Li", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Chun Li"};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters3, position, moves));
    }

    String[][] fighters4 = new String[][]{
            new String[] {      "",     "Ryu",  "E.Honda",  "Cammy" },
            new String[] {"Balrog",     "Ken",  "Chun Li",       "" },
            new String[] {  "Vega",        "", "Fei Long", "Balrog" },
            new String[] {"Blanka",   "Guile",         "", "Chun Li"},
            new String[] {"M.Bison","Zangief",  "Dhalsim", "Sagat"  },
            new String[] {"Deejay",   "Cammy",         "", "T.Hawk" }
    };

    @Test
    void shouldWorkWithLongerGrid4(){
        String[] moves = new String[] {"left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "down", "right", "right", "down", "right", "right", "right", "down", "left", "left", "left", "down", "left", "left", "left"};
        int[] position = new int[] {0,3};
        String[] solution = new String[] {"E.Honda", "Ryu", "Ken", "Chun Li", "Balrog", "Ken", "Chun Li", "Fei Long", "Vega", "Balrog", "Fei Long", "Vega", "Blanka", "Guile", "Chun Li", "Sagat", "M.Bison", "Zangief", "Dhalsim", "Dhalsim", "Zangief", "M.Bison", "Sagat", "T.Hawk", "Cammy", "Deejay", "T.Hawk"};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters4, position, moves));
    }

    @Test
    void shouldWorkWithOddInitialPosition(){
        String[] moves = new String[] {"left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "up", "right", "right", "up", "right", "right", "right"};
        int[] position = new int[] {3,3};
        String[] solution = new String[] {"Guile", "Blanka", "M.Bison", "Zangief", "Dhalsim", "Sagat", "M.Bison", "Deejay", "T.Hawk", "Cammy", "Deejay", "T.Hawk", "Sagat", "M.Bison", "Zangief", "Guile", "Chun Li", "Blanka", "Guile"};
        assertThat(solution).isEqualTo(Solution.superStreetFighterize(fighters4, position, moves));
    }

}
