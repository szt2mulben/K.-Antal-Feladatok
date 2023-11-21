package music;

 class Violin extends stringedInstrument {
    String sound;
    public Violin(int numberOfStrings, String sound) {
        this.numberOfStrings = numberOfStrings;
        this.sound = sound;
        this.name = "Violin";
    }

    @Override
    public void play() {
        System.out.println("Violin jatszasa.");
        sound();
    }

    @Override
    public void sound() {
        System.out.println(sound);
    }
}
