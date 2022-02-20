import java.util.ArrayList;
import java.util.List;

public class Prime extends Thread{
    public int count = 0;
    public int bound;//Для отделения потоков, нижняя граница числа каждого потока
    public int upperBound;
    public List<Integer> primeList = new ArrayList<>();

    public boolean isPrime(int n){

        if (n == 1 || n == 0) return false;
        for (int i = 2; i < (int)n/2; i++)
        {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int n = bound; n <= upperBound; n++) { 
                if (isPrime(n)){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                count++;
                primeList.add(n);
            }
        }
    }
}
