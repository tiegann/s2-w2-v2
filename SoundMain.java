public class SoundMain{

    public static void main(String[] args){
        Sound s = new Sound();
        Viewer v = s.getViewer();
        v.addAction("Restore Original", () -> s.restoreOriginal());
        v.addAction("Reverse", () -> s.reverse());
        v.addAction("Double Pitch", () -> s.doublePitch());
        v.addAction("Normalize", () -> s.normalize());
        v.addAction("Fade In (0.5s)", () -> s.fadeIn(0.5));
        v.addAction("Fade Out (0.5s)", () -> s.fadeOut(0.5));
        v.addAction("Echo (250ms)", () -> s.echo(0.25, 0.5));
        v.addAction("Square (440Hz)", () -> s.setSquare(440));
    }
}
