import junit.framework.TestCase;

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

            //проведем тест на время для следующих количеств потока
            // 1, 2, 4, 5, 10, 20, 25 потоков
            int caseMass[] = {1, 4, 10, 25};
            System.out.println("Optimal number of threads");
            for (int k = 0; k < 4; k++) {

                int nThreads = caseMass[k];
                final prime[] pThreads = new prime[nThreads];

                long startTime = System.currentTimeMillis();
                for (int i = 0; i < nThreads; i++) {
                    pThreads[i] = new prime();
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
            }
        }
}
