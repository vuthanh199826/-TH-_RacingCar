public class Car implements Runnable{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int start = 0;
        long startTime = System.currentTimeMillis();
       while (start < 100){
           int speed = (int) Math.round(Math.random()*20);
           start +=speed;
           String location = "|";
           int percentTravel = (start*100)/100;
           for (int i = 0; i < 100; i+= 2) {
               if(percentTravel >= i + 2){
                   location += "=";
               }else if(percentTravel >= i && percentTravel < i + 2){
                   location += "o";
               }else {
                   location += "-";
               }
               location += "|";
               System.out.println("car" + name + location + " " + Math.min(100,start) + "km");
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
           long endTime = System.currentTimeMillis();
           System.out.println("car " + name + " finish " + (endTime - startTime)/1000 + "s");

       }
    }
}
