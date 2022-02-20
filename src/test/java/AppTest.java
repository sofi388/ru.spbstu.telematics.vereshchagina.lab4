import junit.framework.TestCase;

import java.util.ArrayList;

public class AppTest extends TestCase{
        /**
         * Create the test case
         *
         * @param testName name of the test case
         */
    public AppTest( String testName )
        {
            super( testName );
        }

     /*
        public static Test suite()
        {
            return new TestSuite( AppTest.class );
        }
*/
        /**
         * Rigourous Test :-)*/

        public void testApp()
        {
            assertTrue( true );
        }

     public void testTime() {
         System.out.println("Optimal number of threads");
         int limitNumber = 1000; // до какого числа ищем простые числа
         for (int nThreads = 1; nThreads < 100; nThreads++) {//<50
            // final Prime[] pThreads = new Prime[nThreads];
             ArrayList<Prime> pThreads = new ArrayList<Prime>();
             int countForAvarage = 20; // количество циклов для усреднения времени
             long avarageElapsedTime = 0;
             for(int c = 0; c < countForAvarage; c++) {
                 long startTime = System.currentTimeMillis();
                 for (int i = 0; i < nThreads; i++) {
                     Prime p = new Prime();
                     p.bound = (limitNumber / nThreads) * i;
                     p.upperBound = p.bound + (limitNumber / nThreads);
                     p.start();
                     pThreads.add(p);
                 }
                 for (Prime p : pThreads) {
                     try {
                         p.join(); //ждем завершения потока
                     } catch (InterruptedException ignored) {
                     }
                 }
                 long stopTime = System.currentTimeMillis();
                 long elapsedTime = stopTime - startTime;
                 avarageElapsedTime += elapsedTime;
             }
             avarageElapsedTime /= countForAvarage; //усредняем время
             System.out.println("Num of threads = " + nThreads + "  Execution time = : " + avarageElapsedTime + " millisecs");
         }
     }
           /*
        public void testTime1() {

            //проведем тест на время для следующих количеств потока
            // 1, 2, 4, 5, 10, 20, 25 потоков
            int caseMass[] = {1, 4, 10, 25};
            System.out.println("Optimal number of threads");
            for (int k = 0; k < 4; k++) {

                int nThreads = caseMass[k];
                final Prime[] pThreads = new Prime[nThreads];

                long startTime = System.currentTimeMillis();
                for (int i = 0; i < nThreads; i++) {
                    pThreads[i] = new Prime();
                    pThreads[i].bound = (1000/caseMass[k])*i;//100 * i;
                    pThreads[i].upperBound = (1000/caseMass[k])*i + (1000/caseMass[k]);
                    pThreads[i].start();
                    try {
                        pThreads[i].join(10);
                    } catch (InterruptedException ex) {
                    }
                }
                long stopTime = System.currentTimeMillis();
                long elapsedTime = (-1) * (startTime - stopTime);
                System.out.println("\n Num of threads = "+  caseMass[k] + " ") ;
                System.out.println(" Execution time = : "+  elapsedTime + " millisecs \n") ;

                for (int j = 0; j<nThreads; j++){
                    System.out.println("Thread " + (j + 1) + " " + pThreads[j].primeList);
                }
                // k++;
            }
        }
*/
}