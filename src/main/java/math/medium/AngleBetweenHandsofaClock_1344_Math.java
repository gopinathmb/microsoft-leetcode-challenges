package math.medium

/*
Notes:

Angle covered by clock hands
__________________________________
        | Hour Hand | Minute Hand
________|___________|_____________
1 hour  |    30     |    360
1 min   |    0.5    |     6
----------------------------------


Formula:
O(1)
-----------------------------
|Math.abs(hour*30 - min*5.5)|
-----------------------------

Angle between both:

	   h_angle =  hours*30 +   0.5*min
   -   m_angle =  0        +   6  *min
____________________________________
	    angle  = 30*hours - 5.5*min 
        
        
Base Case:
1) Angle when hour hand representing 12.
2) We have to choose smallest angle. If hands cross 180 degree.
        
===========================================================================

class AngleBetweenHandsofaClock_1344_Math {
    public double angleClock(int hour, int min) {
    
        //When hour hand will cross 12:00 its angle will start from zero
        int hour_degree = (hour%12)*60+min;
        //Angle of hour hand will be different after 12.00 O clock i.e. start from 0.
        
        if (180 < Math.abs(hour_degree*0.5-min*6)){
            return 360 - Math.abs(hour_degree*0.5-min*6);
        }
        else{
            return Math.abs(hour_degree*0.5-min*6);
        }
             
    }
}
============================================================================


class AngleBetweenHandsofaClock_1344_Math {
    public double angleClock(int hour, int min){
        double min_angle = min*6;
        //Total angle of hour hand is angle made by hour hand + angle made due to minutes
        double hour_angle = hour*30 + min*0.5;
        double total_angle = Math.abs(min_angle - hour_angle);
        return Math.min(total_angle, 360 - total_angle);
    }
}
=============================================================================
*/

class AngleBetweenHandsofaClock_1344_Math {
    public double angleClock(int hour, int min){      
        return Math.min(Math.abs(hour*30 - min*5.5), 360 - Math.abs(hour*30 - min*5.5));
    }
}


