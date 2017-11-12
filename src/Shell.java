import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;


public class Shell extends org.eclipse.swt.widgets.Shell {
	
	private static Shell shell;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			shell = new Shell(display);
			shell.layout();
			
			shell.addListener(SWT.Paint, event -> drawRectangles(event));
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    private static void drawRectangles(Event e) {

        GC gc = e.gc;

        Color c1 = new Color(e.display, 50, 50, 200);
        gc.setBackground(c1);
        gc.fillRectangle(10, 15, 90, 60);

        Color c2 = new Color(e.display, 105, 90, 60);
        gc.setBackground(c2);
        gc.fillRectangle(130, 15, 90, 60);

        Color c3 = new Color(e.display, 33, 200, 100);
        gc.setBackground(c3);
        gc.fillRectangle(250, 15, 90, 60);

        gc.fillRoundRectangle(5,5,90,45,25,15);
  
        PaletteData p = new PaletteData(0xFF , 0xFF00 , 0xFF0000);
        Hardware TFTHardware = new Hardware(320, 240, Hardware.c_MODE.BIT18);

	    for (int x=0; x<48; x++){
	    	for(int y=0; y<48; y++){
	        	TFTHardware.writePixel(x, y, p);
	         }
	    };
        
        Image image = new Image(Display.getDefault(), TFTHardware.GetImageData());
        
        gc.drawImage(image, 0, 0);
        
/*		PaletteData palette = new PaletteData(0xFF , 0xFF00 , 0xFF0000);
	    ImageData imageData = new ImageData(48,48,24,palette);
	    for (int x=0;x<48;x++){
	        for(int y=0;y<48;y++){
	            if(y > 11 && y < 35 && x > 11 && x < 35){
	             imageData.setPixel(x,y,0xFF00);   // Set the center to green
	            } else {
	                imageData.setPixel(x,y,0xFF);   // and everything else to red
	         }
	        }
	    };
	    Image image = new Image(Display.getDefault(), imageData);
	    
	    */
        
        c1.dispose();
        c2.dispose();
        c3.dispose();
    }
	
	
	/**
	 * Create the shell.
	 * @param display
	 */
	public Shell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(349, 10, 75, 25);
		btnNewButton.setText("New Button");

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

//	    Display display = Display.getDefault();
//	    Image image = new Image(display, imageData);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
