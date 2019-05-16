import java.awt.Color;
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

public class Main extends JPanel implements KeyListener, ActionListener {

	private Thread loopThread;
	private static SortingTypes sortingType = SortingTypes.RainbowLines;
	public static JFrame frame;
	public static double FRAME_WIDTH = 2000, FRAME_HEIGHT = 1400;
	public static ArrayList<SortingType> objs;

	public Main() {
		frame = new JFrame("Sorter");
		frame.setSize((int) FRAME_WIDTH, (int) FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populate();
		Timer timer = new Timer(1, this);
		timer.start();
	}

	public static void main(String[] args) {
		new Main();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int) FRAME_WIDTH, (int) FRAME_HEIGHT);
		objs.forEach(color -> color.render(g));
	}

	private static void populate() {
		objs = new ArrayList<SortingType>();
		int r = 255, b = 0, g = 0;
		for (int i = 0; i < 2000; i++) {
			switch (sortingType) {
			case RainbowLines:
				if (r == 255 && g < 255 && b == 0) {
					g++;
				}
				if (g == 255 && r > 0 && b == 0) {
					r--;
				}
				if (g == 255 && b < 255 && r == 0) {
					b++;
				}
				if (b == 255 && g > 0 && r == 0) {
					g--;
				}
				if (b == 255 && r < 255 && g == 0) {
					r++;
				}
				if (r == 255 && b > 0 && g == 0) {
					b--;
				}
				objs.add(new RainbowLine(r, g, b, i));
				break;
			case Points:
				objs.add(new Points(i));
				break;
			case Bars:
				objs.add(new Bar(i));
				break;
			}
		}
	}

	public static int getIndex(SortingType obj) {
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i).equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public void shuffle() {
		Random rand = new Random();
		for (int i = 0; i < objs.size(); i++) {
			int indexToSwap = rand.nextInt(objs.size());
			SortingType tempLine = objs.get(indexToSwap);
			objs.set(indexToSwap, objs.get(i));
			objs.set(i, tempLine);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (loopThread == null) {
				break;
			}
		}
		System.out.println("Shuffle Complete");
	}

	public void bubbleSort() {
		for (int i = 0; i < objs.size(); i++) {
			for (int i2 = 0; i2 < objs.size() - i - 1; i2++) {
				if (objs.get(i2).getVal() > objs.get(i2 + 1).getVal()) {
					SortingType temp = objs.get(i2 + 1);
					objs.set(i2 + 1, objs.get(i2));
					objs.set(i2, temp);
					slowDown(10);
				}
			}
		}
	}

	public void insertionSort() {
		int n = objs.size();
		for (int i = 1; i < n; ++i) {
			SortingType key = objs.get(i);
			int j = i - 1;
			while (j >= 0 && objs.get(j).getVal() > key.getVal()) {
				objs.set(j + 1, objs.get(j));
				j = j - 1;
				slowDown(5);
			}
			objs.set(j + 1, key);
		}
	}

	public void selectionSort() {
		int n = objs.size();
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (objs.get(j).getVal() < objs.get(min_idx).getVal())
					min_idx = j;
			SortingType temp = objs.get(min_idx);
			objs.set(min_idx, objs.get(i));
			objs.set(i, temp);
			slowDown(1000);
		}
	}

	public int partition(int low, int high) {
		SortingType pivot = objs.get(high);
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (objs.get(j).getVal() <= pivot.getVal()) {
				i++;
				SortingType temp = objs.get(i);
				objs.set(i, objs.get(j));
				objs.set(j, temp);
				slowDown(250);
			}
		}
		SortingType temp = objs.get(i + 1);
		objs.set(i + 1, objs.get(high));
		objs.set(high, temp);
		slowDown(250);
		return i + 1;
	}

	public void quickSort(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);
			quickSort(low, pi - 1);
			quickSort(pi + 1, high);
		}
	}

	public void merge(int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		SortingType[] L = new SortingType[n1];
		SortingType[] R = new SortingType[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = objs.get(l + i);
		for (int j = 0; j < n2; ++j)
			R[j] = objs.get(m + 1 + j);

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			slowDown(600);
			if (L[i].getVal() <= R[j].getVal()) {
				objs.set(k, L[i]);
				i++;
			} else {
				objs.set(k, R[j]);
				j++;
			}
			k++;
		}

		while (i < n1) {
			// slowDown(600);
			objs.set(k, L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			// slowDown(600);
			objs.set(k, R[j]);
			j++;
			k++;
		}
		// slowDown(300);
	}

	public void mergeSort(int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}

	public void slowDown(int multiplier) {
		if (multiplier == 1) {
			System.out.println();
		} else {
			System.out.println();
			slowDown(multiplier - 1);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			if (loopThread != null)
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
			if (loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					bubbleSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_I:
			if (loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					insertionSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_S:
			if (loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					selectionSort();
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_M:
			if (loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					mergeSort(0, objs.size() - 1);
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_Q:
			if (loopThread != null)
				loopThread.interrupt();
			loopThread = new Thread() {
				public void run() {
					quickSort(0, objs.size() - 1);
				}
			};
			loopThread.start();
			break;
		case KeyEvent.VK_RIGHT:
			switch (sortingType) {
			case RainbowLines:
				sortingType = SortingTypes.Points;
				break;
			case Points:
				sortingType = SortingTypes.Bars;
				break;
			case Bars:
				sortingType = SortingTypes.RainbowLines;
				break;
			}
			populate();
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

	public enum SortingTypes {
		RainbowLines, Points, Bars
	}

}