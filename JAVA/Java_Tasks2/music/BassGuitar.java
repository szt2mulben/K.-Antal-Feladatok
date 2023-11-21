package music;

 class BassGuitar extends stringedInstrument {
    String sound;
    public BassGuitar(int numberOfStrings, String sound) {
        this.numberOfStrings = numberOfStrings;
        this.sound = sound;
        this.name = "Bass Guitar";
    }

    @Override
    public void play() {
        System.out.println("Basszusgitár");
        sound();
    }

    @Override
    public void sound() {
        System.out.println(sound);
    }
}