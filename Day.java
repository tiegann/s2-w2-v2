class Day{
    private int dayOfYear;
    private boolean rain;

    public Day(int dayOfYear, boolean rained){
        this.dayOfYear = dayOfYear;
        this.rain = rained;
    }
    public int dayOfYear(){
        return this.dayOfYear;
    }

    public void setRain(boolean didRain){
        this.rain = didRain;
    }
    public boolean didRain(){
        return this.rain;
    }
}