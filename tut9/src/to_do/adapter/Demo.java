package to_do.adapter;

//import tuts.tut9.complete.adapter.adapter.SquarePegAdapter;
//import tuts.tut9.complete.adapter.round.RoundHole;
//import tuts.tut9.complete.adapter.round.RoundPeg;
//import tuts.tut9.complete.adapter.square.SquarePeg;

import to_do.adapter.adapter.SquarePegAdapter;
import to_do.adapter.round.RoundHole;
import to_do.adapter.round.RoundPeg;
import to_do.adapter.square.SquarePeg;

/**
 * Somewhere in client code...
 */
public class Demo {
    public static void main(String[] args) {
        //TO-DO: Create 2 instances of RoundHole and RoundPeg with same radius
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        //TO-DO: If RoundHole instance can "fits" with RoundPeg instance => show a message
        if (roundHole.fits(roundPeg))
            System.out.println("Round hole fits round peg!");
        //TO-DO: Create 2 instances of SquarePeg with 2 different widths
        SquarePeg peg1 = new SquarePeg(5);
        SquarePeg peg2 = new SquarePeg(15);
        //Note: You can't make RoundHole instance "fit" with SquarePeg instance
        //Therefore, we need to use Adapter for solving the problem.

        //TO-DO: Create 2 corresponding instances of SquarePegAdapter
        SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(peg1);
        SquarePegAdapter squarePegAdapter2 = new SquarePegAdapter(peg2);
        //TO-DO: If the RoundHole instance can "fits" with "small" RoundPegAdapter instance
        //show a suitable message
        if (roundHole.fits(squarePegAdapter1))
            System.out.println("This round hole fits the small square peg adapter");
        //TO-DO: If the RoundHole instance can not "fits" with "big" RoundPegAdapter instance
        //show a suitable message
        if (!roundHole.fits(squarePegAdapter2))
            System.out.println("This round hole doesn't fit the big square peg adapter");
    }
}