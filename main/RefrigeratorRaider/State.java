package RefrigeratorRaider;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface State {
	   public void doAction(Context context) throws FileNotFoundException, IOException;
	}//end State