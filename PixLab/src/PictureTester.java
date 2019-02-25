import java.awt.Robot;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroRed();
	  beach.explore();
  }
  
  public static void testZeroGreen(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroGreen();
	  beach.explore();
  }
  
  public static void testZeroAlpha(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroAlpha();
	  beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("cat collage.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void convertToBlackAndWhite(){
	  Picture pic = new Picture("femaleLionAndHall.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(Pixel[] p : pixels)
		  for(Pixel pixel : p){
			  int average = (int)pixel.getAverage();
			  pixel.setRed(average);
			  pixel.setBlue(average);
			  pixel.setGreen(average);
		  }
	  pic.explore();
  }
  
  public static void adjustBrightness(double val){
	  Picture pic = new Picture("koala.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(Pixel[] p : pixels)
		  for(Pixel pixel : p){
			  pixel.setRed((int)(pixel.getRed()*val));
			  pixel.setBlue((int)(pixel.getBlue()*val));
			  pixel.setGreen((int)(pixel.getGreen()*val));
		  }
	
	  pic.explore();
  }
  

  public static void adjustBrightness2(double val){
	  Picture pic = new Picture("koala.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(Pixel[] p : pixels){
		  for(Pixel pixel : p){
			  double newVal = val;
			  double brightestVal = Math.max(Math.max(pixel.getRed(), pixel.getGreen()), pixel.getBlue());
			  if(brightestVal * val > 255)
				  newVal = 255.0/brightestVal;
			  pixel.setRed((int)(pixel.getRed()*newVal));
			  pixel.setBlue((int)(pixel.getBlue()*newVal));
			  pixel.setGreen((int)(pixel.getGreen()*newVal));
		  }
	  }
	  pic.explore();
  }
  
  public static void vetrticalMirror(){
	  Picture pic = new Picture("redMotorcycle.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 0; row < pixels.length; row++){
		  for(int col = 0; col < pixels[row].length; col++){
			  pixels[row][pixels[row].length - 1 - col].setRed(pixels[row][col].getRed());
			  pixels[row][pixels[row].length - 1 - col].setBlue(pixels[row][col].getBlue());
			  pixels[row][pixels[row].length -1 - col].setGreen(pixels[row][col].getGreen());
		  }
	  }
	  pic.explore();
  }
  
  public static void horizontalMirror(){
	  Picture pic = new Picture("redMotorcycle.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 0; row < pixels.length; row++){
		  for(int col = 0; col < pixels[row].length; col++){
			  pixels[pixels.length - 1 - row][col].setRed(pixels[row][col].getRed());
			  pixels[pixels.length - 1 - row][col].setBlue(pixels[row][col].getBlue());
			  pixels[pixels.length - 1 - row][col].setGreen(pixels[row][col].getGreen());
		  }
	  }
	  pic.explore();
  }
  
  public static void vetrticalHorizontalMirror(){
	  Picture pic = new Picture("redMotorcycle.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 0; row < pixels.length; row++){
		  for(int col = 0; col < pixels[row].length; col++){
			  pixels[pixels.length - 1 - row][pixels[row].length - 1 - col].setRed(pixels[row][col].getRed());
			  pixels[pixels.length - 1 - row][pixels[row].length - 1 - col].setBlue(pixels[row][col].getBlue());
			  pixels[pixels.length - 1 - row][pixels[row].length -1 - col].setGreen(pixels[row][col].getGreen());
		  }
	  }
	  pic.explore();
  }
  
  public static void flipVertical(){
	  Picture pic = new Picture("butterfly1.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 0; row < pixels.length; row++){
		  for(int col = 0; col < pixels[row].length/2; col++){
			 int redVal = pixels[row][col].getRed(), greenVal = pixels[row][col].getGreen(), blueVal = pixels[row][col].getBlue(); 
			 setPixel(pixels[row][col], pixels[row][pixels[row].length-1-col]);
			 pixels[row][pixels[row].length-1-col].setRed(redVal);
			 pixels[row][pixels[row].length-1-col].setGreen(greenVal);
			 pixels[row][pixels[row].length-1-col].setBlue(blueVal);
		  }
	  }
	  pic.explore();
  }
  
  public static void flipHorizontal(){
	  Picture pic = new Picture("butterfly1.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 0; row < pixels.length/2; row++){
		  for(int col = 0; col < pixels[row].length; col++){
			 int redVal = pixels[row][col].getRed(), greenVal = pixels[row][col].getGreen(), blueVal = pixels[row][col].getBlue(); 
			 setPixel(pixels[row][col], pixels[pixels.length-1-row][col]);
			 pixels[pixels.length-1-row][col].setRed(redVal);
			 pixels[pixels.length-1-row][col].setGreen(greenVal);
			 pixels[pixels.length-1-row][col].setBlue(blueVal);
		  }
	  }
	  pic.explore();
  }
  
  public static void diagonalMirror(){
	  Picture pic = new Picture("butterfly1.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  System.out.println("Length: " + pixels[0].length);
	  int slope = pixels.length/pixels[0].length;
	  System.out.println(slope);
	 for(int row = 0; row < pixels.length; row++){
		 for(int col = 0; col < pixels[row].length; col++){
			 if(pixels.length-row < slope * col + pixels.length)
			 setPixel(pixels[pixels.length-1-row][pixels[row].length-1-col], pixels[row][col]);
		 }
	 }
	 pic.explore();
  }
  
  public static void repairTemple(){
	
	  Picture pic = new Picture("temple.jpg");
	  pic.explore();
	  Pixel[][] pixels = pic.getPixels2D();
	  for(int row = 27; row <= 96; row++){
		  for(int col = 13; col <= 275; col++){
			  pixels[row][276*2-col].setRed(pixels[row][col].getRed());
			  pixels[row][276*2-col].setGreen(pixels[row][col].getGreen());
			  pixels[row][276*2-col].setBlue(pixels[row][col].getBlue());
		  }
	  }
	  pic.explore();
  }
  
  public static void setPixel(Pixel changingPixel, Pixel targetPixel){
	  changingPixel.setRed(targetPixel.getRed());
	  changingPixel.setBlue(targetPixel.getBlue());
	  changingPixel.setGreen(targetPixel.getGreen());
	  changingPixel.setAlpha(targetPixel.getAlpha());
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	 //adjustBrightness2(6);
    //adjustBrightness2(5);
	//repairTemple();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
	//testMirrorDiagonal();
    testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}