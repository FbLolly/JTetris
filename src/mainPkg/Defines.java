package mainPkg;

import java.awt.Color;

import javax.swing.JComponent;

public class Defines {
	public static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

	public static int FPS = 60;
	public static int waiting = FPS;

	public static final int tileSize = 32;

	public static final int gridX = 10; //with a 1920x1080 screen this works perfectly
	public static final int gridY = 20; //with a 1920x1080 screen this works perfectly

	public static final int width = gridX * tileSize;
	public static final int height = gridY * tileSize;

	public static final int amount = 8;
	public static final int size = 4;

	public static final int buttonNum = 2;
	public static final int buttonAnimationSpeed = 7;

	public static final int buttonWidth = 500;
	public static final int buttonHeight = 50;

	public static final String[] buttonText = {"Play", "Quit"};
	public static final Color rosePurple = new Color(186, 85, 211);

	public static Color[] colors = {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red};

	public static int[][][][] pieces = {
		{
			{
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0}
			},
			{
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 1, 0, 0},
				{1, 1, 0, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 1, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{0, 0, 1, 1},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 0},
				{0, 0, 1, 1},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 1},
				{0, 0, 1, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 1},
				{0, 0, 1, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{0, 1, 1, 1},
				{0, 1, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 1, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 0, 1},
				{0, 1, 1, 1},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 0}
			}
		},
		{
			{
				{0, 0, 0, 0},
				{0, 1, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 1, 0, 0},
				{0, 1, 1, 1},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			},
			{
				{0, 0, 1, 1},
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
			}
		}
	};
}
//Copyright 2024 FbLolly
