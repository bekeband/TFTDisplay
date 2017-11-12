import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;

public class Hardware {
	
	public enum c_MODE {BIT18, BIT24};

	public static int tftwidth;
	public static int tftheight;

	private PaletteData palette;
    private ImageData RAMData;
    
    
    private c_MODE MODE;

    public Hardware(int atftwidth, int atftheight, c_MODE aMODE)
    {
    	palette = new PaletteData(0xFF , 0xFF00 , 0xFF0000);
    	tftwidth = atftwidth;
    	tftheight = atftheight;
    	MODE = aMODE;
    	RAMData = new ImageData(tftwidth, tftheight, 24, palette);
    }

    private int GetColorWord(PaletteData p)
    {	int result;
    	if (MODE == c_MODE.BIT24)
    	{
        	result = (p.blueMask | p.greenMask | p.redMask);    		
    	} else
    		if (MODE == c_MODE.BIT18)
    		{
            	result = ((p.blueMask & 0b11111100) | (p.greenMask & 0b11111100) | (p.redMask & 0b1111100));    			
    		} else
    		{
    	    	return 0;    			
    		}
    	return result;
    }
    
    private void write_data(int x1, int y1, int x2, int y2, PaletteData pixeldata)
    {	int x, y;
    	for (x = x1; x < x2; x++)
    	{
    		for (y = y1; y < y2; y++)
    		{
    			RAMData.setPixel(x, y, GetColorWord(pixeldata));
    		}
    	}
    }
    
    public void writePixel(int x, int y, PaletteData pixel)
    {
    	write_data(x, y, x + 1, y + 1, pixel);
    }
    
    public ImageData GetImageData() {return RAMData;};
    
}
