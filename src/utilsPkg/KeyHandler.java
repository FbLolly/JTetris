package utilsPkg;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import mainPkg.Defines;
import mainPkg.JTetris;

public class KeyHandler {
	public boolean pressedEscape;
	public int direction; // -1 = left, 0 = nothing, 1 = male
	public boolean rotating; // 1 = rotating, 0 = not rotating
	public boolean hardDrop;
	
	public KeyHandler() {
		this.pressedEscape = false;
		this.direction = 0;
		this.rotating = false;
	}
	
	public void handleKeys(JTetris jtetris) {
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("ENTER"), "escape");
		
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("W"), "w");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("D"), "d");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("S"), "s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("A"), "a");

		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("UP"), "w");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("RIGHT"), "d");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("DOWN"), "s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("LEFT"), "a");

		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("SPACE"), "space");

		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("released S"), "released_s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("released DOWN"), "released_s");
		
		jtetris.getActionMap().put("escape", new PressedEsc());
		jtetris.getActionMap().put("w", new PressedW());
		jtetris.getActionMap().put("d", new PressedD());
		jtetris.getActionMap().put("s", new PressedS());
		jtetris.getActionMap().put("released_s", new ReleasedS());
		jtetris.getActionMap().put("a", new PressedA());
		jtetris.getActionMap().put("space", new PressedSpace());
	}
	
	public class PressedEsc extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			pressedEscape = true;
		}
	}
	
	public class PressedW extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			rotating = true;
		}
	}
	
	public class PressedD extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			direction = 1;
		}
	}
	
	public class PressedS extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			Defines.waiting = Defines.FPS/10;
		}
	}

	public class ReleasedS extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			Defines.waiting = Defines.FPS;
		}
		
	}
	
	public class PressedA extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			direction = -1;
		}
	}

	public class PressedSpace extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			hardDrop = true;
		}
	}
}

















