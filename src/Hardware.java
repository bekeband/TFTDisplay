import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;

public class Hardware {
	
	public static int tftwidth = 320;
	public static int tftheight = 240;

	private PaletteData palette;
    private ImageData RAMData;

	
    public Hardware()
    {
    	palette = new PaletteData(0xFF , 0xFF00 , 0xFF0000);
    	RAMData = new ImageData(tftwidth, tftheight, 24, palette);
    }
    
//    public SetPixel()
    
}
