class Solution {
    public double angleClock(int hour, int minutes) {
        double h=30*hour;
        double min=minutes*5.5;
        double angle=(double)Math.abs(h-min);
        if(angle>180.0){
            return (double)360-angle;
        }
        return angle;
    }
}