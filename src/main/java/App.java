/* Многопоточный поиск простых чисел от 0 до 1000.
* Разделение на 10 потоков. Каждый i-ый поток  ищет простые числа в своем диапазоне [100*i - 100; 100*i].
* Executed time - время работы программы
* */

public class App{
    static long startTime = System.currentTimeMillis();
    static long stopTime = System.currentTimeMillis();
    static long elapsedTime;// = (-1)*(startTime - stopTime);

    static long elapsed = 0;// = (-1)*(startTime - stopTime);
    public static void main(String[] args){
        int nThreads = 10;
        final Prime[] pThreads = new Prime[nThreads];

        for(int i = 0; i<nThreads; i++){
            startTime = System.currentTimeMillis();
            pThreads[i] = new Prime();
            pThreads[i].bound = 10000*i; //1000/10  но мы возьмем  1 000 000/10
            pThreads[i].upperBound = 10000*i+10000;

            pThreads[i].start();
            stopTime = System.currentTimeMillis();
            elapsed = (-1)*(startTime - stopTime);
            elapsedTime+=elapsedTime;
        }
        for (Prime p : pThreads) {
            try {
                p.join();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Execution time = : "+  elapsedTime + " millisecs") ;
        System.out.println("Start time = : "+  startTime + " millisecs") ;
        System.out.println("Stop time = : "+  stopTime + " millisecs") ;

        for (int j = 0; j<10; j++){
            System.out.println("Thread " + (j + 1) + " " + pThreads[j].primeList);
        }

    }
}
