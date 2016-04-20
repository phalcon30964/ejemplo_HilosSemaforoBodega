
import java.util.concurrent.Semaphore;


public class Bodega {

    private int cant;
    private Semaphore mutexC;
    private Semaphore espDisp;
    private Semaphore artDisp;

    private int cant1;
    private Semaphore mutex1;
    private Semaphore art1Disp;
    
    private int cant2;
    private Semaphore mutex2;
    private Semaphore art2Disp;

    public Bodega() {
    cant = 0;
    mutexC = new Semaphore(1);
    espDisp = new Semaphore(200);
    artDisp = new Semaphore(0);

    cant1 = 0;
    mutex1 = new Semaphore(1);
    art1Disp = new Semaphore(0);
    
    cant2 = 0;
    mutex2 = new Semaphore(1);
    art2Disp = new Semaphore(0);
    }

    public void descargar(int tipo) throws InterruptedException {
        if(tipo==1){
            espDisp.acquire(10);
            
            mutex1.acquire();
            cant1++;
            mutex1.release();
            
            art1Disp.release();
            
            mutexC.acquire();
            cant+=10;
            mutexC.release();
            
            artDisp.release(10);
        }else if(tipo==2){
            espDisp.acquire(15);
            
            mutex2.acquire();
            cant2++;
            mutex2.release();
            
            art2Disp.release();
            
            mutexC.acquire();
            cant+=15;
            mutexC.release();
            
            artDisp.release(15);
        } 
        System.out.println("Hay "+cant1+" articulos1 y "+cant2+" articulos2. Un volumen de "+cant);
    }

    public void empacar() throws InterruptedException {
        art1Disp.acquire(3);
        art2Disp.acquire(4);
        
        artDisp.acquire(90);
        mutexC.acquire();
        cant-=90;
        mutexC.realease();
        espDisp.release(90);
        
        mutex1.acquire();
        cant1-=3;
        mutex1.release();
        
        mutex2.acquire();
        cant2-=4;
        mutex2.release();
        System.out.println("Hay "+cant1+" articulos1 y "+cant2+" articulos2. Un volumen de "+cant);
    }    
}
