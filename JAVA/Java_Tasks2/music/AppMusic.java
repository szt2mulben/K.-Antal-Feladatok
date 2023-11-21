package music;

public class AppMusic {
    public static void main(String[] args) {
        ElectricGuitar elektromosGitar = new ElectricGuitar(6,"Twang");
        elektromosGitar.play();
        BassGuitar basszusGitar = new BassGuitar(4,"Duum-duum-duum");
        basszusGitar.play();
        Violin violin = new Violin(4,"Screech");
        violin.play();
    }
}