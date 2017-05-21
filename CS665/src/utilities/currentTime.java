package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class currentTime {
	
	protected Calendar calendar;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	private Date creationDate;
	protected String stringDate;
	
	public currentTime(){
		calendar = Calendar.getInstance();
		creationDate = calendar.getTime();
		stringDate = sdf.format(creationDate);
	}
	
	
	/**returns the date the instance was created.
	 * @return the date of when the instance was created.
	 */
	public Date getInstanceDate(){return creationDate;}
	
	
	/**returns the date the instance was created formated as a string yyyy/mm/dd.
	 * @return a string date formated yyyy/mm/dd
	 */
	public String getStringDate(){return stringDate;}

}//end currentTime