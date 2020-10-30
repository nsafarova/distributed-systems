package ada;

import java.io.File;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter one of the modes (0 -> single threaded, 1 -> multi-threaded): ");
        int n = sc.nextInt();

        if(n == 1) {
            long start = System.currentTimeMillis();
            System.out.println("Mode: Multi-threaded");

            String file1 = "http://www.ubicomp.org/ubicomp2003/adjunct_proceedings/proceedings.pdf";
            String file2 = "https://www.hq.nasa.gov/alsj/a17/A17_FlightPlan.pdf";
            String file3 = "https://ars.els-cdn.com/content/image/1-s2.0-S0140673617321293-mmc1.pdf";
            String file4 = "http://www.visitgreece.gr/deployedFiles/StaticFiles/maps/Peloponnese_map.pdf";

            File output1 = new File("./resources/file1.pdf");
            File output2 = new File("./resources/file2.pdf");
            File output3 = new File("./resources/file3.pdf");
            File output4 = new File("./resources/file4.pdf");

            System.out.print("Files: ");
            Thread t1 = new Thread(new Download1(file1, output1), "t1");
            Thread t2 = new Thread(new Download2(file2, output2), "t2");
            Thread t3 = new Thread(new Download3(file3, output3), "t3");
            Thread t4 = new Thread(new Download4(file4, output4), "t4");

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();

            long end = System.currentTimeMillis();
            double time = (double)(end - start)/1000;
            System.out.println();
            System.out.println("Time: " + time + "s");
        }

        else if(n == 0) {
            long start = System.currentTimeMillis();
            System.out.println("Mode: Single threaded");

            String file1 = "http://www.ubicomp.org/ubicomp2003/adjunct_proceedings/proceedings.pdf";
            String file2 = "https://www.hq.nasa.gov/alsj/a17/A17_FlightPlan.pdf";
            String file3 = "https://ars.els-cdn.com/content/image/1-s2.0-S0140673617321293-mmc1.pdf";
            String file4 = "http://www.visitgreece.gr/deployedFiles/StaticFiles/maps/Peloponnese_map.pdf";

            File output1 = new File("./resources/file1.pdf");
            File output2 = new File("./resources/file2.pdf");
            File output3 = new File("./resources/file3.pdf");
            File output4 = new File("./resources/file4.pdf");

            System.out.print("Files: ");
            Thread t1 = new Thread(new Download1(file1, output1), "t1");
            Thread t2 = new Thread(new Download2(file2, output2), "t2");
            Thread t3 = new Thread(new Download3(file3, output3), "t3");
            Thread t4 = new Thread(new Download4(file4, output4), "t4");

            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            t4.start();
            t4.join();

            long end = System.currentTimeMillis();
            double time = (double)(end - start)/1000;
            System.out.println();
            System.out.println("Time: " + time + "s");
        }

        else System.out.println("ERROR. Please, try again!");
    }
}
