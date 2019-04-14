import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements KeyListener, ActionListener{

	private Thread loopThread;
	public static JFrame frame;
	public static int FRAME_WIDTH = 1500, FRAME_HEIGHT = 1250;
	public static ArrayList<Line> colors;
	
	public Main() {
		frame = new JFrame("Sorter");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populate();
//		try {
//			Thread.sleep(2000);
//			shuffle();
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		insertionSort();
		//bubbleSort();
		Timer timer = new Timer(1, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		colors.forEach(color -> color.render(g));
	}
	
	private static void populate() {
		colors = new ArrayList<Line>();
		int r = 255, b = 0, g = 0;
		for(int i = 0; i < 1500; i++) {
			 if ( r == 255 && g < 255 && b == 0 ){
		      g++;
		     }
		    if ( g == 255 && r > 0 && b == 0 ) {
		      r--;
		      }
		    if ( g == 255 && b < 255 && r == 0 ) {
		      b++;
		      }
		    if ( b == 255 && g > 0 && r == 0 ) {
		      g--;
		      }
		    if ( b == 255 && r < 255 && g == 0 ) {
		      r++;
		      }
		    if ( r == 255 && b > 0 && g == 0 ) {
		      b--;
		      }
			colors.add(new Line(r, g, b, i));
		}
	}
	
	public static int getIndex(Line obj) {
		for(int i = 0; i < colors.size(); i++) {
			if(colors.get(i).equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public void shuffle() {
		Random rand = new Random();
		for(int i = 0; i < colors.size(); i++) {
			int indexToSwap = rand.nextInt(colors.size());
			Line tempLine = colors.get(indexToSwap);
			colors.set(indexToSwap, colors.get(i));
			colors.set(i, tempLine);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(loopThread == null) {
				break;
			}
		}
		System.out.println("Shuffle Complete");
	}
	
	public void bubbleSort() {
		for(int i = 0; i < colors.size(); i++) {
			for(int i2 = 0; i2 < colors.size()-i-1; i2++) {
				if(colors.get(i2).getVal() > colors.get(i2+1).getVal()) {
					Line temp = colors.get(i2+1);
					colors.set(i2+1, colors.get(i2));
					colors.set(i2, temp);
					slowDown(10);
				}
			}
		}
	}
	
	public void insertionSort() { 
        int n = colors.size(); 
        for (int i = 1; i < n; ++i) { 
            Line key = colors.get(i); 
            int j = i - 1; 
            while (j >= 0 && colors.get(j).getVal() > key.getVal()) {
            	colors.set(j+1, colors.get(j));
                j = j - 1; 
                slowDown(10);
            } 
            colors.set(j + 1, key);
        } 
    } 
	
	  public void selectionSort() { 
	        int n = colors.size(); 
	        for (int i = 0; i < n-1; i++) { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (colors.get(j).getVal() < colors.get(min_idx).getVal()) 
	                    min_idx = j; 
	            Line temp = colors.get(min_idx); 
	            colors.set(min_idx, colors.get(i)); 
	            colors.set(i, temp); 
	            slowDown(1000);
	        } 
	  } 
	  
	  public int partition(int low, int high) { 
		  Line pivot = colors.get(high);  
		  int i = (low-1); 
		  for (int j=low; j<high; j++) { 
			  if (colors.get(j).getVal() <= pivot.getVal()) { 
				  i++; 
				  Line temp = colors.get(i); 
				  colors.set(i, colors.get(j));
				  colors.set(j, temp);
				  slowDown(250);
			  } 
		  } 
		  Line temp = colors.get(i+1); 
		  colors.set(i+1, colors.get(high)); 
		  colors.set(high, temp); 
		  slowDown(250);
		  return i+1; 
	  } 
	  
	  public void quickSort(int low, int high) { 
		  if (low < high) { 
			  int pi = partition(low, high); 
			  quickSort(low, pi-1); 
			  quickSort(pi+1, high); 
		  } 
	  } 
	  
	  public void merge(int l, int m, int r) { 
		  int n1 = m - l + 1; 
          int n2 = r - m; 
  
          Line[] L = new Line[n1]; 
          Line[] R = new Line[n2]; 
  
          for (int i=0; i<n1; ++i) 
              L[i] = colors.get(l + i); 
          for (int j=0; j<n2; ++j) 
              R[j] = colors.get(m + 1+ j); 
  
 
          int i = 0, j = 0; 
  
          int k = l; 
          while (i < n1 && j < n2) {
        		slowDown(300);
              if (L[i].getVal() <= R[j].getVal()) { 
                  colors.set(k, L[i]); 
                  i++; 
              }else{ 
                  colors.set(k, R[j]); 
                  j++; 
              } 
              k++; 
          } 
  
          while (i < n1) { 
        	slowDown(300);
              colors.set(k, L[i]); 
              i++; 
              k++; 
          } 
  
          while (j < n2)  {
        	  slowDown(300);
              colors.set(k, R[j]); 
              j++; 
              k++; 
          } 
    	slowDown(300);
	} 
	  
	public void mergeSort(int l, int r) { 
        if (l < r) { 
            int m = (l+r)/2; 
            mergeSort(l, m); 
            mergeSort(m+1, r); 
  	        merge(l, m, r); 
        } 
	} 
	
	public void toggleBlack(int index1, int index2) {
		if(!colors.get(index1).isBlack()) {
			colors.get(index1).setBlack(true);
		}else{
			colors.get(index1).setBlack(false);
		}
		if(!colors.get(index2).isBlack()) {
			colors.get(index2).setBlack(true);
		}else{
			colors.get(index2).setBlack(false);
		}
	}
	
	public void slowDown(int multiplier) {
		if(multiplier == 1) {
			System.out.println();
		}else {
			System.out.println();
			slowDown(multiplier-1);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					populate();
					shuffle();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_B:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					bubbleSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_I:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					insertionSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_S:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					selectionSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_M:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					mergeSort(0, colors.size()-1);
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_Q:
			if(loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					quickSort(0, colors.size()-1);
				}
			};
			loopThread.start();
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	

}