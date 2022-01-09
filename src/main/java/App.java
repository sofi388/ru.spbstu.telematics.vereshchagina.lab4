/* Многопоточный поиск простых чисел от 0 до 1000.
* Разделение на 10 потоков. Каждый i-ый поток  ищет простые числа в своем диапазоне [100*i - 100; 100*i].
* Executed time - время работы программы
* */
public class App{
    public static void main(String[] args){
        int nThreads = 10;
        final prime[] pThreads = new prime[nThreads];

        long startTime = System.currentTimeMillis();
        for(int i = 0; i<nThreads; i++){
            pThreads[i] = new prime();
            pThreads[i].bound = 100*i;
            pThreads[i].start();
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = (-1)*(startTime - stopTime);
        System.out.println("Execution time = : "+  elapsedTime + " millisecs") ;

        for (int j = 0; j<10; j++){
            System.out.println("Thread " + (j + 1) + " " + pThreads[j].primeList);
        }
    }
}
