public class SoundMain{

    public static void main(String[] args){
        Sound s = new Sound();
        Viewer v = s.getViewer();
        v.addAction("Restore Original", () -> s.restoreOriginal());
        v.addAction("Reverse", () -> s.reverse());
        v.addAction("Double Pitch", () -> s.doublePitch());
        v.addAction("Normalize", () -> s.normalize());
        v.addAction("Fade In (2s)", () -> s.fadeIn(2));
        v.addAction("Fade Out (1s)", () -> s.fadeOut(1));
        v.addAction("Echo (250ms)", () -> s.echo(0.25, 0.5));
        v.addAction("Square (440Hz)", () -> s.setSquare(440));
    }
}
